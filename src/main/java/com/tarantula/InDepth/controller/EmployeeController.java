package com.tarantula.InDepth.controller;

import com.tarantula.InDepth.entities.Employee;
import com.tarantula.InDepth.exceptions.EmployeeNotFoundException;
import com.tarantula.InDepth.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Value("${welcome.message}")
    private String welcomeMessage;

    private final EmployeeService employeeService;

    //Logger
    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String helloWorld() {
        return welcomeMessage;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        LOGGER.info("Inside saveEmployee of EmployeeController");
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> fetchEmployeesList () {
        return employeeService.fetchEmployeesList();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") Long employeeId) throws EmployeeNotFoundException {
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping("/employees/name/{name}")
    public Employee getEmployeeByName(@PathVariable("name") String name) throws EmployeeNotFoundException {
        return employeeService.findByEmployeeName(name);
    }

}
