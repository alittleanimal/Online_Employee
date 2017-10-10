package sef.interfaces.service;

import sef.domain.EmployeeDetail;

public interface EmployeeDetailsService {
	
	/**
	 * Searches for an employee in the database given the employee id.
	 * 
	 * @param employeeID numeric data representing the employee id.
	 * @return <code>EmployeeDetail</code> object containing the employee 
	 * details  
	 */
	public EmployeeDetail getEmployeeDetails(long employeeID);
}
