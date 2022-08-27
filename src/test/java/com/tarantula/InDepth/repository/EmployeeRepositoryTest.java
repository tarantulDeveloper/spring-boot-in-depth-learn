package com.tarantula.InDepth.repository;

import com.tarantula.InDepth.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestEntityManager entityManager;


    @BeforeEach
    void setUp() {
        Employee employee = Employee.builder()
                .employeeName("Mendi")
                .salary(34000)
                .build();

        entityManager.persist(employee);
    }

    @Test
    public void whenFindById_thenReturnEmployee() {
        Employee employee = employeeRepository.findById(1L).get();
        assertEquals(employee.getEmployeeName(), "Mendi");
    }
}