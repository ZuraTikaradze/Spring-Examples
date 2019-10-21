package com.github.zuratikaradze.aop.service;

import com.github.zuratikaradze.aop.model.Employee;
import org.springframework.context.annotation.Bean;

public class EmployeeService {

    private Employee employee;

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee e) {
        this.employee = e;
    }
}
