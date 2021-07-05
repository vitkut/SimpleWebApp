package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class EmployeeRowMapperUtil implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Employee(resultSet.getLong("employee_id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getLong("department_id"),
                resultSet.getString("job_title"),
                Gender.valueOf(resultSet.getString("gender")),
                resultSet.getDate("date_of_birth"));
    }
}