package task.dao;

import com.mastery.java.task.dao.EmployeeDaoImpl;
import com.mastery.java.task.dto.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import task.samples.EmployeeSamples;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeDaoTest {

    @InjectMocks
    private EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl("employee");

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    public void createTest(){
        //given
        Employee newEmpl = EmployeeSamples.getEmployee();

        //then
        assertDoesNotThrow(() -> employeeDaoImpl.create(newEmpl.getFirstName(), newEmpl.getLastName(),
                newEmpl.getDepartmentId(), newEmpl.getJobTitle(), newEmpl.getGender(), newEmpl.getDateOfBirth()));
    }

    @Test
    public void getByIdTest(){
        //given
        Long enployeeId = 0L;

        //when
        Employee employee = employeeDaoImpl.getById(enployeeId);

        //then
        assertNull(employee);
    }

    @Test
    public void listEmployeesTest(){
        //then
        assertTrue(employeeDaoImpl.listEmployees().isEmpty());
    }

    @Test
    public void removeByIdTest(){
        //given
        Long employeeId = 0L;

        //then
        assertDoesNotThrow(() -> employeeDaoImpl.removeById(employeeId));
    }

    @Test
    public void updateByIdTest(){
        //given
        Employee employee = EmployeeSamples.getEmployee();

        //then
        assertDoesNotThrow(() -> employeeDaoImpl.updateById(employee.getEmployeeId(), employee.getFirstName(),
                employee.getLastName(), employee.getDepartmentId(), employee.getJobTitle(), employee.getGender(),
                employee.getDateOfBirth()));
    }
}
