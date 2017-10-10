package sef.domain;

import java.util.List;

public class EmployeeDetail {

	private Employee employee;
	private List<EmployeeProjectDetail> projectList;
	private List<EmployeeSkill> skillList;
	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<EmployeeProjectDetail> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<EmployeeProjectDetail> projectList) {
		this.projectList = projectList;
	}

	public List<EmployeeSkill> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<EmployeeSkill> skillList) {
		this.skillList = skillList;
	}

	
	
	
	
	

}
