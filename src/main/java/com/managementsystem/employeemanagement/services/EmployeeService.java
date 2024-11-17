package com.managementsystem.employeemanagement.services;

import com.managementsystem.employeemanagement.entities.Employee;
import com.managementsystem.employeemanagement.exceptionhandling.EntityNotFoundException;
import com.managementsystem.employeemanagement.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    EmployeeRepository employeeRepository;
    public Employee saveEmployee(Employee employee){
        try {
            return employeeRepository.save(employee);
        } catch (Exception e) {
            logger.error("Error occurred while saving employee: {}", e.getMessage());
            throw new RuntimeException("Error occurred while saving employee");
        }
    }

    public Page<Employee> getEmployees(int page, int size, String sortBy, String sortDirection) {
        try {
            Sort sort = sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
            Pageable pageable = PageRequest.of(page, size, sort);
            return employeeRepository.findAll(pageable);
        } catch (Exception e) {
            logger.error("Error occurred while fetching employees: {}", e.getMessage());
            throw new RuntimeException("Error occurred while fetching employees");
        }
    }

    public Employee updateEmployee(Long id,Employee employee){
        try {
            return employeeRepository.findById(id).map(employee1 -> {
                employee1.setFirstName(employee.getFirstName());
                employee1.setLastName(employee.getLastName());
                employee1.setEmail(employee.getEmail());
                return employeeRepository.save(employee1);
            }).orElseThrow(() -> {
                logger.error("Employee not found with ID: {}", id);
                return new EntityNotFoundException("Employee not found!");
            });
        } catch (Exception e) {
            logger.error("Error occurred while updating employee: {}", e.getMessage());
            throw new RuntimeException("Error occurred while updating employee");
        }

    }

    public void deleteEmployee(Long id){
        try {
            employeeRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Error occurred while deleting employee with ID: {}", id);
            throw new RuntimeException("Error occurred while deleting employee");
        }
    }

    public Employee getEmployee(Long id)
    {
        try {
            return employeeRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Employee with id " + id + " not found"));
        } catch (Exception e) {
            logger.error("Error occurred while fetching employee with ID: {}", id);
            throw new RuntimeException("Error occurred while fetching employee");
        }
    }

}
