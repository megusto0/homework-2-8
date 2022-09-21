package com.example.homework28.service;

import com.example.homework28.exception.EmployeeNotFoundException;
import com.example.homework28.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class DepartmentService {
    private final EmployeeService employeeService;
    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public Employee findMaxSalary(String department) {
        return employeeService.getList().stream()
                .filter(e -> e.getDepartment().equals(department))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee findMinSalary(String department) {
        return employeeService.getList().stream()
                .filter(e -> e.getDepartment().equals(department))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> findEmployeesFromDepartment(String department) {
        return employeeService.getList().stream()
                .filter(e -> e.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    public Map<String, List<Employee>> findEmployees() {
        return employeeService.getList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }



}
