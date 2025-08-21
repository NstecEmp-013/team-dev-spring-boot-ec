package com.fullness.ec.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import com.fullness.ec.entity.EmployeeAccount;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeAccountRepositoryTest {
    @Autowired
    EmployeeAccountRepository employeeAccountRepository;

    @Test
    public void testSelectByName(){
        EmployeeAccount result = employeeAccountRepository.selectByName("admin");
        assertNotNull(result);
        assertEquals("admin", result.getName());
        assertEquals(1, result.getEmployeeId());
    }
    
}
