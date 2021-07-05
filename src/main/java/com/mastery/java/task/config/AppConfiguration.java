package com.mastery.java.task.config;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dao.EmployeeDaoImpl;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Value("${dao.employeeTableName}")
    private String employeeTableName;

    @Bean
    public EmployeeDao employeeDao(){
        return new EmployeeDaoImpl(employeeTableName);
    }

    @Bean
    public EmployeeService employeeService(){
        return new EmployeeService();
    }
}
