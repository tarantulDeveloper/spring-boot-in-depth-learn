package com.tarantula.InDepth.service;

import com.tarantula.InDepth.entities.Employee;
import com.tarantula.InDepth.exceptions.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> fetchEmployeesList();
    Employee getEmployee(Long employeeId) throws EmployeeNotFoundException;

    Employee findByEmployeeName(String name) throws EmployeeNotFoundException;
}
