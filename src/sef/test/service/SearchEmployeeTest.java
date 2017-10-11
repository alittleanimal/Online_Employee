package sef.test.service;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sef.domain.EmployeeDetail;
import sef.interfaces.repository.SkillRepository;
import sef.interfaces.service.EmployeeDetailsService;
import sef.interfaces.service.SearchService;

public class SearchEmployeeTest extends TestCase {

	private EmployeeDetailsService emDetailsService;
	private SearchService service;

	public void setUp() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:repository-config.xml");
		service = (SearchService) context.getBean("searchService");
		emDetailsService = (EmployeeDetailsService) context
				.getBean("detailsService");
	}

	 public void testListemployees1(){
	 EmployeeDetail result = emDetailsService.getEmployeeDetails(1);
	 assertNotNull(result);
	 //assertEquals(1, 1);
	 assertTrue(result.getEmployee().getID()== 1);
	 }
	 public void testListemployees9(){
	 EmployeeDetail result = emDetailsService.getEmployeeDetails(3);
	 assertNotNull(result);
	 assertTrue(result.getProjectList().size()> 0);
	 }

	public void testListemployees2() {
		List result = service.findEmployeesByName("Eugene", "Lozada");
		assertNotNull(result);
		assertTrue(result.size() > 0);
	}

	public void testListemployees3() {
		List result = service.findEmployeesByName("Mike", "Gil");
		assertNotNull(result);
		assertTrue(result.size() > 0);
	}

	public void testListemployees4() {
		List result = service.findEmployeesByProject(4);
		assertNotNull(result);
		assertTrue(result.size() > 0);
	}

	public void testListemployees5() {
		List result = service.findEmployeesByProject(2);
		assertNotNull(result);
		assertTrue(result.size() > 0);
	}

	public void testListemployees6() {
		List result = service.listAllProjects();
		assertNotNull(result);
		assertTrue(result.size() > 0);
	}


}