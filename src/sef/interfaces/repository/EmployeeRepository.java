package sef.interfaces.repository;

import java.util.List;

import javax.sql.DataSource;

import sef.domain.Employee;

public interface EmployeeRepository {
	
	/**
	 * Searches for all employees in the database containing 
	 * the first name and/or last name specified.
	 * 
	 * @param firstName String representing the first name of the employee
	 * @param lastName String representing the last name of the employee
	 * @return the list of employees 
	 */
	public List<Employee> findEmployeesByName(String firstName, String lastName);

	/**
	 * Searches for all employees in the database given the project id.
	 * 
	 * @param projectID numeric data representing the ID of the project.
	 * @return the list of employees 
	 */
	public List<Employee> findEmployeesByProject(long projectID);

	/**
	 * Searches for an employee in the database given the employee id.
	 * 
	 * @param employeeID numeric data representing the employee id.
	 * @return <code>Employee</code> object containing the employee 
	 * details  
	 */
	public Employee findEmployeeByID(long employeeID);
	
}
