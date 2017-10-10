package sef.domain;

import java.util.List;

public class EmployeeProjectDetail {

	private Project project;
	private List<ProjectRole> projectRoles;

	public List<ProjectRole> getProjectRoles() {
		return projectRoles;
	}

	public void setProjectRoles(List<ProjectRole> projectRoles) {
		this.projectRoles = projectRoles;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
