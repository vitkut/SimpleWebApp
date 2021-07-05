package task.samples;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;

import java.util.Date;

public class EmployeeSamples {

    public static Employee getEmployee(){
        return new Employee(1L, "V", "K",
                12L, "J", Gender.MALE, new Date(2000, 12, 02));
    }
}
