package com.bridgelabz.employeepayrollapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bridgelabz.employeepayrollapp.employeedto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.IEmployeeRepository;

@Service
public class EmployeeServiceIMPL implements IEmployeeService{
	@Autowired
	IEmployeeRepository employeeRepository;
	@Override
	public Employee addEmployee(EmployeePayrollDTO employeeDTO) {
		Employee emp = new Employee(employeeDTO);
		emp = employeeRepository.save(emp);
		return emp;
	}
	@Override
	public Employee getEmployeeById(Long id) throws EmployeeException {
		return employeeRepository.findById(id).orElseThrow(()->new EmployeeException("Invalid User id"));
	}
	@Override
	public void updateEmployeeById(Long id, EmployeePayrollDTO employeeDTO) throws EmployeeException {
		Employee emp = getEmployeeById(id);
		if(employeeDTO.name != null) {
			emp.setName(employeeDTO.name);
		}
		if(employeeDTO.salary != 0.0) {
			emp.setSalary(employeeDTO.salary);
		}
		employeeRepository.save(emp);
	}
	@Override
	@Transactional
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}

}
