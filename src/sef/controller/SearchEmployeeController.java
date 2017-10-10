package sef.controller;

import java.util.List;

import sef.domain.Employee;
import sef.domain.EmployeeDetail;
import sef.domain.Project;
import sef.interfaces.service.EmployeeDetailsService;
import sef.interfaces.service.SearchService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/find/*.htm")
public class SearchEmployeeController {
		
	private static Logger log = Logger.getLogger(SearchEmployeeController.class);
	private SearchService searchService;
	private EmployeeDetailsService detailsService;
	
	public SearchEmployeeController(SearchService searchService, EmployeeDetailsService detailsService){
		this.searchService = searchService;
		this.detailsService = detailsService;
	}
	
	@RequestMapping("viewEmployeeDetails.htm")
	public ModelAndView onViewEmployeeDetails(
			@RequestParam("employeeID") long employeeID) throws Exception {
		
		log.info("Getting details for employee ID " + employeeID);
		
		EmployeeDetail employee = detailsService.getEmployeeDetails(employeeID);
		ModelAndView mav = new ModelAndView();
		mav.addObject("employee", employee.getEmployee());
		mav.addObject("projectList", employee.getProjectList());
		mav.addObject("skillList", employee.getSkillList());
		mav.setViewName("find/employeeDetails");
		return mav;
	}
	
	@RequestMapping(value="findEmployees.htm", params="!searchType")
	public ModelAndView onInitialSearchFormState()
	{
		List<Project> projectList = searchService.listAllProjects();
		log.info("Entering search form in its initial state");
		ModelAndView mav = new ModelAndView();
		mav.addObject("projectList", projectList);
		mav.setViewName("find/employeeSearchForm");
		return mav;
	}
	
	@RequestMapping(value="findEmployees.htm", params="searchType=findByName")
	public ModelAndView onSubmitSearchByName(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("projectID") long projectID){
		
		
		log.info("Searching by first name: " + firstName + " last name: " + lastName);
		
		List<Employee> employeeList  = searchService.findEmployeesByName(firstName, lastName);
		List<Project> projectList = searchService.listAllProjects();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("projectList", projectList);
		mav.addObject("employeeList", employeeList);
		mav.setViewName("find/employeeSearchForm");
		return mav;
	}
	
	@RequestMapping(value="findEmployees.htm", params="searchType=findByProject")
	public ModelAndView onSubmitSearchByProject(
			@RequestParam("projectID") long projectID){
		
		
		log.info("Finding by project ID: " + projectID);
		List<Project> projectList = searchService.listAllProjects();
		List<Employee> employeeList = searchService.findEmployeesByProject(projectID);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("projectList", projectList);
		mav.addObject("employeeList", employeeList);
		mav.setViewName("find/employeeSearchForm");
		return mav;
	}
	
	
	
	
	
}
