package sef.interfaces.repository;

import java.util.List;


import sef.domain.EmployeeSkill;

public interface SkillRepository {
	
	/**
	 * Retrieves all the skills of an employee.
	 * 
	 * @param employeeID the id of the employee
	 * @return list of skills of an employee
	 */	
	public List<EmployeeSkill> findEmployeeSkills(long employeeID);
}
