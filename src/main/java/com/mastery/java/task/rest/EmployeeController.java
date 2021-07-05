package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        try{
            List<Employee> employees = employeeService.listEmployees();
            return ResponseEntity.ok(employees);
        } catch (Exception ex){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "id") Long employeeId){
        try{
            Employee employee = employeeService.getById(employeeId);
            return ResponseEntity.ok(employee);
        } catch (Exception ex){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, "application/json"})
    public ResponseEntity<?> createEmployee(@RequestBody Employee newEmployee){
        try {
            employeeService.create(newEmployee);
            return ResponseEntity.ok().build();
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(newEmployee);
        }
    }

    @PutMapping(path = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, "application/json"})
    public ResponseEntity<Employee> updateEmpployee(@PathVariable(name = "id") Long employeeId, @RequestBody Employee newEmployee){
        try {
            newEmployee.setEmployeeId(employeeId);
            employeeService.update(newEmployee);
            Employee employee = employeeService.getById(employeeId);
            return ResponseEntity.ok(employee);
        } catch (Exception ex){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeEmployeeById(@PathVariable(name = "id") Long employeeId){
        try {
            employeeService.removeById(employeeId);
            return ResponseEntity.ok().build();
        } catch (Exception ex){
            return ResponseEntity.notFound().build();
        }
    }
}
