package sef.impl.service;

import java.util.ArrayList;
import java.util.List;

import sef.domain.Employee;
import sef.domain.Project;
import sef.interfaces.repository.EmployeeRepository;
import sef.interfaces.repository.ProjectRepository;
import sef.interfaces.service.SearchService;

import org.apache.log4j.Logger;

public class StubSearchServiceImpl implements SearchService {

	//Tip: create member variables in this class that will contain the objects 
	//passed by the Spring framework so that other methods can access the objects.

	private static Logger log = Logger.getLogger(StubSearchServiceImpl.class);
	private EmployeeRepository employeeRep;
	private ProjectRepository projectRep;

	public StubSearchServiceImpl(EmployeeRepository empDAO,
			ProjectRepository projectDAO) {
		this.employeeRep = empDAO;
		this.projectRep = projectDAO;
	}

	@Override
	public List<Employee> findEmployeesByName(String firstName, String lastName) {
		//employeeRep.findEmployeesByName(firstName, lastName);
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList = employeeRep.findEmployeesByName(firstName, lastName);
		return employeeList;
	}

	@Override
	public List<Employee> findEmployeesByProject(long projectID) {
		//employeeRep.findEmployeesByProject(projectID);
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList = employeeRep.findEmployeesByProject(projectID);
		return employeeList;
	}

	@Override
	public List<Project> listAllProjects() {
		//projectRep.listAllProjects();
		List<Project> projectList = new ArrayList<Project>();
		projectList = projectRep.listAllProjects();
		return projectList;
	}

	public EmployeeRepository getEmployeeRep() {
		return employeeRep;
	}

	public void setEmployeeRep(EmployeeRepository employeeRep) {
		this.employeeRep = employeeRep;
	}

	public ProjectRepository getProjectRep() {
		return projectRep;
	}

	public void setProjectRep(ProjectRepository projectRep) {
		this.projectRep = projectRep;
	}






}
