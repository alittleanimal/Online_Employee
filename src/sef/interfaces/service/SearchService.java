package sef.interfaces.service;

import java.util.List;

import sef.domain.Employee;
import sef.domain.Project;

public interface SearchService {
	
	/**
	 * Searches for all employees in the database given the project id.
	 * 
	 * @param projectID numeric data representing the ID of the project.
	 * @return the list of employees 
	 */
	public List<Employee> findEmployeesByProject(long projectID);
	
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
	 * Retrieves all projects from the database.  
	 * Used to populate the search drop down filters.
	 * 
	 * @return list of projects from the database
	 */
	public List<Project> listAllProjects();
	
}
