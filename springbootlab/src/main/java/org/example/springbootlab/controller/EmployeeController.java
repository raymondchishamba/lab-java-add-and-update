package org.example.springbootlab.controller;

import org.example.springbootlab.model.Employee;
import org.example.springbootlab.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllDoctors() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getDoctorById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    @GetMapping("/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable String status) {
        return employeeService.getEmployeesByStatus(status);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable String department) {
        return employeeService.getEmployeesByDepartment(department);
    }
    // Add new doctor
    @PostMapping
    public ResponseEntity<Employee> addDoctor(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Change doctor status
    @PatchMapping("/{employeeId}/status")
    public ResponseEntity<Employee> changeDoctorStatus(@PathVariable Long employeeId, @RequestBody String status) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) {
            employee.setStatus(status);
            Employee updatedEmployee = employeeService.updateEmployee(employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update doctor's department
    @PatchMapping("/{employeeId}/department")
    public ResponseEntity<Employee> updateDoctorDepartment(@PathVariable Long employeeId, @RequestBody String department) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) {
            employee.setDepartment(department);
            Employee updatedEmployee = employeeService.updateEmployee(employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}