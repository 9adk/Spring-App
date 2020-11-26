package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.employeedto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeException;
import com.bridgelabz.employeepayrollapp.model.Employee;

public interface IEmployeeService {
	public Employee addEmployee(EmployeePayrollDTO employeeDTO);
	public Employee getEmployeeById(Long id) throws EmployeeException;
	public void updateEmployeeById(Long id, EmployeePayrollDTO employeeDTO) throws EmployeeException;
	public void deleteEmployeeById(Long id);
}
