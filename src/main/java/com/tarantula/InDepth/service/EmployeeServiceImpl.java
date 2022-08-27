package com.tarantula.InDepth.service;

import com.tarantula.InDepth.entities.Employee;
import com.tarantula.InDepth.exceptions.EmployeeNotFoundException;
import com.tarantula.InDepth.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchEmployeesList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long employeeId) throws EmployeeNotFoundException {
        //return employeeRepository.findById(employeeId).orElse(null);
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee not found.");
        }
        return employee.get();
    }

    @Override
    public Employee findByEmployeeName(String name) throws EmployeeNotFoundException{
        return employeeRepository.findByEmployeeName(name);
    }
}
