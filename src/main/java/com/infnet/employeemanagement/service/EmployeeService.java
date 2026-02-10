package com.infnet.employeemanagement.service;

import com.infnet.employeemanagement.dto.request.EmployeeRequest;
import com.infnet.employeemanagement.dto.response.AddressResponse;
import com.infnet.employeemanagement.dto.response.EmployeeResponse;
import com.infnet.employeemanagement.entity.Address;
import com.infnet.employeemanagement.entity.Employee;
import com.infnet.employeemanagement.exception.EmployeeNotFoundException;
import com.infnet.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeResponse> getEmployees(){
        return employeeRepository.findAll().stream().map(this::response).toList();
    }

    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException());
        return response(employee);
    }

    public EmployeeResponse createEmployee(EmployeeRequest request) {
        Address address = new Address();
        address.setStreet(request.getAddress().getStreet());
        address.setCity(request.getAddress().getCity());
        address.setState(request.getAddress().getState());
        address.setZipCode(request.getAddress().getZipCode());

        Employee employee = new Employee();
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setAddress(address);
        Employee saved = employeeRepository.save(employee);
        return response(saved);
    }

    public EmployeeResponse updateEmployee(Long id, EmployeeRequest request) {
        Employee existentEmployee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException());

        existentEmployee.setFirstName(request.getFirstName());
        existentEmployee.setLastName(request.getLastName());

        existentEmployee.getAddress().setStreet(request.getAddress().getStreet());
        existentEmployee.getAddress().setCity(request.getAddress().getCity());
        existentEmployee.getAddress().setState(request.getAddress().getState());
        existentEmployee.getAddress().setZipCode(request.getAddress().getZipCode());
        Employee updatedEmployee = employeeRepository.save(existentEmployee);
        return response(updatedEmployee);
    }

    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) throw new EmployeeNotFoundException();
        employeeRepository.deleteById(id);
    }

    private EmployeeResponse response(Employee employee) {
        AddressResponse address = new AddressResponse(
                employee.getAddress().getStreet(),
                employee.getAddress().getCity(),
                employee.getAddress().getState(),
                employee.getAddress().getZipCode()
        );

        return new EmployeeResponse(employee.getId(), employee.getFirstName(), employee.getLastName(), address);
    }
}
