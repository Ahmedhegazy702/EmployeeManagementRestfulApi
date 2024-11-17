package com.managementsystem.employeemanagement.entities;

import com.managementsystem.employeemanagement.UniqeEmail;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;


@Entity
@Table(name = "Employee",uniqueConstraints = @UniqueConstraint(columnNames = "email"))

@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @UniqeEmail
    @NotNull(message = "Email cannot be null")

    private String email;

    @NotNull(message = "Position cannot be null")
    @Size(min = 3, message = "Position must have at least 3 characters")
    private String position;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public @NotNull(message = "Position cannot be null") @Size(min = 3, message = "Position must have at least 3 characters") String getPosition() {
        return position;
    }

    public void setPosition(@NotNull(message = "Position cannot be null") @Size(min = 3, message = "Position must have at least 3 characters") String position) {
        this.position = position;
    }
}
