package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import java.util.Date;
import java.util.List;

public interface EmployeeDao{

    void create(String firstName, String lastName, Long departmentId, String jobTitle, Gender gender, Date dateOfBirth);
    Employee getById(Long employeeId);
    List<Employee> listEmployees();
    void removeById(Long employeeId);
    void updateById(Long employeeId, String firstName, String lastName, Long departmentId, String jobTitle, Gender gender, Date dateOfBirth);
}