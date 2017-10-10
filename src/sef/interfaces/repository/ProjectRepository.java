package sef.interfaces.repository;

import java.util.List;

import sef.domain.Project;
import sef.domain.EmployeeProjectDetail;
import sef.domain.ProjectRole;

public interface ProjectRepository {

	/**
	 * Retrieves all projects from the database
	 * 
	 * @return list of projects from the database
	 */
	public List<Project> listAllProjects();
	
	/**
	 * Retrieves all projects where an employee is part of.  
	 * 
	 * @param employeeID the id of the employee
	 * @return list of projects 
	 */
	public List<Project> getEmployeeProjects(long employeeID);
	
	/**
	 * Retrieves the roles of an employee for a specific project.
	 * 
	 * @param employeeID the id of the employee
	 * @param projectID the id of the project
	 * @return list of roles 
	 */	
	public List<ProjectRole> getEmployeeProjectRoles(long employeeID, long projectID);

	/**
	 * Retrieves all the employee's projects with the employee's corresponding 
	 * roles in a project. 
	 * 
	 * @param employeeID the id of the employee
	 * @return list of projects with corresponding roles 
	 */	
	public List<EmployeeProjectDetail> getEmployeeProjectHistory(long employeeID);
}
