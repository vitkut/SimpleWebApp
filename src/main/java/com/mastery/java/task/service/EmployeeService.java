package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dao.EmployeeDaoImpl;
import com.mastery.java.task.dto.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    public void create(Employee newEmployee){
        employeeDao.create(newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee.getDepartmentId(),
                newEmployee.getJobTitle(), newEmployee.getGender(), newEmployee.getDateOfBirth());
        logger.info(newEmployee+"created successfully");
    }

    public Employee getById(Long employeeId) {
        return employeeDao.getById(employeeId);
    }

    public List<Employee> listEmployees() {
        return employeeDao.listEmployees();
    }

    public void removeById(Long employeeId) {
        employeeDao.removeById(employeeId);
        logger.info("Employee with id ["+employeeId+"] successfully removed");
    }

    public void update(Employee newEmployee) {
        employeeDao.updateById(newEmployee.getEmployeeId(), newEmployee.getFirstName(), newEmployee.getLastName(),
                newEmployee.getDepartmentId(), newEmployee.getJobTitle(), newEmployee.getGender(), newEmployee.getDateOfBirth());
        logger.info("Employee with id ["+newEmployee.getEmployeeId()+"] successfully updated");
    }
}
