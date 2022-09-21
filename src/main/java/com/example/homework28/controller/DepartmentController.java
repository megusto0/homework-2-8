package com.example.homework28.controller;

import com.example.homework28.model.Employee;
import com.example.homework28.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findMaxSalary(@RequestParam("departmentId") String department) {
        return departmentService.findMaxSalary(department);
    }

    @GetMapping("/mix-salary")
    public Employee findMinSalary(@RequestParam("departmentId") String department) {
        return departmentService.findMinSalary(department);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> findEmployeesFromDepartment(@RequestParam("departmentId") String department) {
        return departmentService.findEmployeesFromDepartment(department);
    }
    @GetMapping("/all")
    public Map<String, List<Employee>> findEmployees() {return departmentService.findEmployees();}


}
