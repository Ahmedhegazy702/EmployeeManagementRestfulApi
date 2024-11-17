package com.managementsystem.employeemanagement.controller;

import com.managementsystem.employeemanagement.entities.Employee;
import com.managementsystem.employeemanagement.services.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/employees")
@Tag(name = "EmployeeSystem",description = "System")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    @PostMapping()
    public ResponseEntity<Employee> addEmployee(@Valid  @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.saveEmployee(employee));

    }


    @GetMapping("/getAll")
    public Page<Employee> getEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection
    ) {
        return employeeService.getEmployees(page, size, sortBy, sortDirection);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){

        return ResponseEntity.ok(employeeService.getEmployee(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable Long id,@RequestBody Employee employee ){
        return ResponseEntity.ok(employeeService.updateEmployee(id,employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee (@PathVariable Long id){

       employeeService.deleteEmployee(id);
       return ResponseEntity.noContent().build();
    }
}
