package com.example.homework28.service;

import com.example.homework28.exception.EmployeeNotFoundException;
import com.example.homework28.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class DepartmentService {
    private final List<Employee> employees;
    @Autowired
    public DepartmentService(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee findMaxSalary(String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals(department))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee findMinSalary(String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals(department))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> all(String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals(department))
                .collect(Collectors.toList());
    }
    public Map<String, List<Employee>> getAll() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
