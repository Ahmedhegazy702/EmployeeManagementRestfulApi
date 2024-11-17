package com.managementsystem.employeemanagement;

import com.managementsystem.employeemanagement.repository.EmployeeRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqeEmail,String> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if(email==null ){
            return false;
        }
        return !employeeRepository.existsByEmail(email);
    }
}
