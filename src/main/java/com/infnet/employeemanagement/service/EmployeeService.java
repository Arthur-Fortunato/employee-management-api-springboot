package com.infnet.employeemanagement.service;

import com.infnet.employeemanagement.entity.Employee;
import com.infnet.employeemanagement.exception.EmployeeNotFoundException;
import com.infnet.employeemanagement.exception.GlobalExceptionHandler;
import com.infnet.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException());
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee existentEmployee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException());
        existentEmployee.setFirstName(employee.getFirstName());
        existentEmployee.setLastName(employee.getLastName());
        existentEmployee.setAddress(employee.getAddress());
        return employeeRepository.save(existentEmployee);
    }

    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException();
        }
        employeeRepository.deleteById(id);
    }
}
