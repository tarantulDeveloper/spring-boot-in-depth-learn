package com.tarantula.InDepth.service;

import com.tarantula.InDepth.entities.Employee;
import com.tarantula.InDepth.exceptions.EmployeeNotFoundException;
import com.tarantula.InDepth.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        Employee employee = Employee.builder()
                .employeeName("Mendi")
                .salary(40000)
                .build();

        Mockito.when(employeeRepository.findByEmployeeName("Mendi"))
                .thenReturn(employee);

    }

    @Test
    @DisplayName("Get data based on Employee Name") //or you can disable by @Disabled
    public void whenValidEmployeeName_thenEmployeeShouldFound() throws EmployeeNotFoundException {
        String employeeName = "Mendi";
        Employee found = employeeService.findByEmployeeName(employeeName);
        assertEquals(employeeName, found.getEmployeeName());
    }
}