package com.mastery.java.task.dao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import com.mastery.java.task.service.EmployeeRowMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.Date;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private String employeeTableName;

    public EmployeeDaoImpl() {
    }

    public EmployeeDaoImpl(String employeeTableName) {
        this.employeeTableName = employeeTableName;
    }

    @Override
    public void create(String firstName, String lastName, Long departmentId, String jobTitle, Gender gender, Date dateOfBirth) {
        String sql = "insert into "+employeeTableName+" (first_name, last_name, department_id, job_title, gender, date_of_birth) " +
                "values (?, ?, ?, ?, cast(? as gender), ?)";
        jdbcTemplate.update(sql, firstName, lastName, departmentId, jobTitle, gender.toString(), dateOfBirth);
    }

    @Override
    public Employee getById(Long employeeId) {
        String sql = "select * from "+ employeeTableName +" where employee_id = ?";
        List list = jdbcTemplate.query(sql, new Object[]{employeeId}, new int[]{Types.BIGINT}, new EmployeeRowMapperUtil());
        if(list.isEmpty()){
            return null;
        } else {
            return (Employee) list.get(0);
        }
    }

    @Override
    public List<Employee> listEmployees() {
        String sql = "select * from "+ employeeTableName;
        return jdbcTemplate.query(sql, new EmployeeRowMapperUtil());
    }

    @Override
    public void removeById(Long employeeId) {
        String sql = "delete from "+employeeTableName+" where employee_id = ?";
        jdbcTemplate.update(sql, employeeId);
    }

    @Override
    public void updateById(Long employeeId, String firstName, String lastName, Long departmentId, String jobTitle, Gender gender, Date dateOfBirth) {
        String sql = "update "+employeeTableName+" set first_name=?, last_name=?, department_id=?, job_title=?, " +
                "gender=cast(? as gender), date_of_birth=? where employee_id=?";
        Employee employee = getById(employeeId);
        if(firstName == null){
            firstName = employee.getFirstName();
        }
        if(lastName == null){
            lastName = employee.getLastName();
        }
        if(departmentId == null){
            departmentId = employee.getDepartmentId();
        }
        if(jobTitle == null){
            jobTitle = employee.getJobTitle();
        }
        if(gender == null){
            gender = employee.getGender();
        }
        if(dateOfBirth == null){
            dateOfBirth = employee.getDateOfBirth();
        }
        jdbcTemplate.update(sql, firstName, lastName, departmentId, jobTitle, gender.toString(), dateOfBirth, employeeId);
    }
}
