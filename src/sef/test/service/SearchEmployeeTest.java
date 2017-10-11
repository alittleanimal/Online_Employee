package sef.test.service;

import java.util.List;

import sef.domain.Employee;
import sef.domain.EmployeeDetail;
import sef.domain.Project;
import sef.domain.ProjectRole;
import sef.interfaces.service.EmployeeDetailsService;
import sef.interfaces.service.SearchService;
import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SearchEmployeeTest extends TestCase {

	private SearchService service;
	private EmployeeDetailsService detailsservice;

	public void setUp() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:repository-config.xml");
		service = (SearchService) context.getBean("searchService");
		detailsservice = (EmployeeDetailsService) context
				.getBean("detailsService");
	}

	public void testfindEmployees1() {
		List<Employee> result = service.findEmployeesByName("J", "Doe");
		assertNotNull(result);
		assertTrue(result.size() == 2);
		assertEquals("Jane", result.get(0).getFirstName());
	}

	public void testfindEmployees2() {
		List<Employee> result = service.findEmployeesByName("Mike", "Gil");
		// assertNotNull(result);
		assertEquals(0, result.size());
	}

	public void testfindEmployees3() {
		List<Employee> result = service.findEmployeesByName("J", null);
		// assertNotNull(result);
		assertEquals(0, result.size());
	}

	public void testfindEmployees4() {
		List<Employee> result = service.findEmployeesByName(null, "D");
		// assertNotNull(result);
		assertEquals(0, result.size());
	}

	public void testfindEmployees5() {
		List<Employee> result = service.findEmployeesByName(null, null);
		// assertNotNull(result);
		assertEquals(0, result.size());
	}

	public void testfindEmployees6() {
		List<Employee> result = service.findEmployeesByProject(4);
		assertNotNull(result);
		assertTrue(result.size() == 2);
		// assertEquals(1, result.get(2).getEnterpriseID());
	}

	public void testfindEmployees7() {
		List<Employee> result = service.findEmployeesByProject(2);
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	public void testfindEmployees8() {
		List<Project> result = service.listAllProjects();
		assertNotNull(result);
		assertTrue(result.size() == 3);

	}

	public void testfindEmployees9() {
		EmployeeDetail result = detailsservice.getEmployeeDetails(1);
		assertNotNull(result);
		assertTrue(result.getProjectList().size() > 0);

	}

	public void testfindEmployees10() {
		EmployeeDetail result = detailsservice.getEmployeeDetails(3);
		assertNotNull(result);
		assertEquals(0, result.getProjectList().size());

	}

	public void testfindEmployees11() {
		EmployeeDetail result = detailsservice.getEmployeeDetails(1);
		assertNotNull(result);
		assertTrue(result.getProjectList().get(0).getProjectRoles().size() > 0);
		assertEquals((long) 3, result.getProjectList().get(1).getProject()
				.getID());
	}

	public void testfindEmployees12() {
		EmployeeDetail result2 = detailsservice.getEmployeeDetails(2);
		EmployeeDetail result1 = detailsservice.getEmployeeDetails(1);
		EmployeeDetail result4 = detailsservice.getEmployeeDetails(4);

		assertEquals(0, result2.getProjectList().size());
		assertNotSame((long) 2, result1.getProjectList().get(1).getProject()
				.getID());
		assertNotSame((long) 3, result4.getProjectList().get(0).getProject()
				.getID());

	}

	public void testfindEmployees13() {
		EmployeeDetail result = detailsservice.getEmployeeDetails(4);
		assertNotNull(result);
		assertTrue(result.getProjectList().size() > 0);
		// assertEquals(4, result.getProjectList());
	}

	public void testfindEmployees14() {
		EmployeeDetail result = detailsservice.getEmployeeDetails(3);
		assertNotNull(result);
		assertEquals(0, result.getProjectList().size());
	}

	public void testfindEmployees15() {
		EmployeeDetail result = detailsservice.getEmployeeDetails(1);
		assertNotNull(result);
		assertTrue(result.getSkillList().size() > 0);

	}

	public void testfindEmployees16() {
		EmployeeDetail result = detailsservice.getEmployeeDetails(100);
		assertNotNull(result);
		assertEquals(0, result.getSkillList().size());
	}

}
