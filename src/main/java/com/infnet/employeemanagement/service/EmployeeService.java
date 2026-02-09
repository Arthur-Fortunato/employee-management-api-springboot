package com.infnet.employeemanagement.service;

import com.infnet.employeemanagement.dto.EmployeeRequest;
import com.infnet.employeemanagement.entity.Address;
import com.infnet.employeemanagement.entity.Employee;
import com.infnet.employeemanagement.exception.EmployeeNotFoundException;
import com.infnet.employeemanagement.repository.EmployeeRepository;
import jakarta.validation.Valid;
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

    public Employee createEmployee(@Valid EmployeeRequest request) {
        Address address = new Address();
        address.setStreet(request.getAddress().getStreet());
        address.setCity(request.getAddress().getCity());
        address.setState(request.getAddress().getState());
        address.setZipCode(request.getAddress().getZipCode());

        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setAddress(address);
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
