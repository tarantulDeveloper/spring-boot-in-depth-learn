package com.tarantula.InDepth.controller;

import com.tarantula.InDepth.entities.Employee;
import com.tarantula.InDepth.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .employeeName("Ahmat")
                .salary(230000)
                .employeeId(1L)
                .build();
    }

    @Test
    void saveEmployee() throws Exception {
        Employee inputEmployee = Employee.builder()
                .employeeName("Ahmat")
                .salary(230000)
                .build();

        Mockito.when(employeeService.saveEmployee(inputEmployee))
                .thenReturn(employee);

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"employeeName\":\"Ahmat\",\n" +
                        "\t\"salary\": 230000\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void getEmployeeByName() throws Exception {
        Mockito.when(employeeService.findByEmployeeName("Ahmat"))
                .thenReturn(employee);
        mockMvc.perform(get("/employees/name/Ahmat")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employeeName").value(employee.getEmployeeName()));
    }
}