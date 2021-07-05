package task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import task.samples.EmployeeSamples;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService = new EmployeeService();

    @Mock
    private EmployeeDao employeeDao;


    @Test
    public void createTest(){
        //given
        Employee newEmpl = EmployeeSamples.getEmployee();

        //then
        assertDoesNotThrow(() -> employeeService.create(newEmpl));
    }

    @Test
    public void getByIdTest(){
        //given
        Long employeeId = 0L;

        //when
        Employee employee = employeeService.getById(employeeId);

        //then
        assertNull(employee);
    }

    @Test
    public void listEmployeesTest(){
        //then
        assertTrue(employeeService.listEmployees().isEmpty());
    }

    @Test
    public void removeByIdTest(){
        //given
        Long employeeId = 0L;

        //then
        assertDoesNotThrow(() -> employeeService.removeById(employeeId));
    }

    @Test
    public void updateByIdTest(){
        //given
        Employee employee = EmployeeSamples.getEmployee();

        //then
        assertDoesNotThrow(() -> employeeService.update(employee));
    }
}
