package sef.impl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import sef.domain.Project;
import sef.domain.EmployeeProjectDetail;
import sef.domain.ProjectRole;
import sef.interfaces.repository.ProjectRepository;

import org.apache.log4j.Logger;

import com.sun.org.apache.regexp.internal.recompile;

public class StubProjectRepositoryImpl implements ProjectRepository {

	private DataSource dataSource;
	// DataSource class encapsulates the driver, database url, username and
	// password information. The dataSource object is automatically created by
	// the Spring framework and passed to the constructor therefore there's no
	// need
	// to instantiate the dataSource variable. A connection can be acquired by
	// accessing the getConnection method of dataSource.
	//
	// Tip: create member variables in this class that will contain the objects
	// passed by the Spring framework so that other methods can access the
	// objects.

	private static Logger log = Logger
			.getLogger(StubProjectRepositoryImpl.class);

	public StubProjectRepositoryImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Override
	public List<Project> listAllProjects() {

		List<Project> list = new ArrayList<Project>();
		Project project = null;
		String sql = "select * from projects";
		try(Connection conn = dataSource.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(sql);) {
			
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				project = new Project();
				project.setID((long) rs.getInt(1));
				project.setName(rs.getString(2));
				project.setDescription(rs.getString(3));
				project.setClient(rs.getString(4));
				list.add(project);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Project selectProjectsById(long projectID) {

		Project project = null;
		String sql = "select * from projects where id = ?";
		try(Connection conn = dataSource.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(sql);) {
			
			preparedStatement.setLong(1, projectID);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				System.out.println("running select ProjecsByid");
				project = new Project();
				project.setID((long) rs.getInt(1));
				project.setName(rs.getString(2));
				project.setDescription(rs.getString(3));
				project.setClient(rs.getString(4));
			}
			return project;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return project;
	}

	@Override
	public List<EmployeeProjectDetail> getEmployeeProjectHistory(long employeeID) {

		List<EmployeeProjectDetail> detailList = new ArrayList<EmployeeProjectDetail>();
		List<ProjectRole> projectRolesList = null;
		EmployeeProjectDetail employeeProjectDetail = null;
		
		List<Project> listProjects = getEmployeeProjects(employeeID);
		for (Project project2 : listProjects) {
			projectRolesList = getEmployeeProjectRoles(employeeID, project2.getID());
			employeeProjectDetail = new EmployeeProjectDetail();
			employeeProjectDetail.setProject(project2);
			employeeProjectDetail.setProjectRoles(projectRolesList);
			detailList.add(employeeProjectDetail);
		}
		
		return detailList;
	}
		/*List<EmployeeProjectDetail> detailList = new ArrayList<EmployeeProjectDetail>();
		List<ProjectRole> projectRolesList;
		Project project = null;
		ProjectRole projectRole = null;
		EmployeeProjectDetail employeeProjectDetail = null;
		String sql = "select * from employee_project_map where employee_id = ?";
		project = new Project();
		try (Connection conn = dataSource.getConnection();
				PreparedStatement preparedStatement = conn
						.prepareStatement(sql);) {

			preparedStatement.setLong(1, employeeID);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				projectRole = new ProjectRole();
				projectRolesList = new ArrayList<ProjectRole>();
				employeeProjectDetail = new EmployeeProjectDetail();

				project = selectProjectsById(Long.valueOf(rs.getString(3)));

				projectRole.setID(Long.valueOf(rs.getString(2)));
				projectRole.setRole(rs.getString(4));
				projectRole.setStartDate(rs.getDate(5));
				projectRole.setEndDate(rs.getDate(6));
				projectRolesList.add(projectRole);

				employeeProjectDetail.setProject(project);
				employeeProjectDetail.setProjectRoles(projectRolesList);
				
				detailList.add(employeeProjectDetail);
			}
			
			for (EmployeeProjectDetail projectDetail : detailList) {
				System.out.println(projectDetail.getProject().getName());
				System.out.println(projectDetail.getProjectRoles().toString());
			}
			System.out.println(detailList.toString());
			return detailList;
			
			 * String str = rs.getString(3); PreparedStatement preparedProject =
			 * conn.prepareStatement(sqlProject); preparedProject.setLong(1,
			 * Long.valueOf(str)); ResultSet rs1 =
			 * preparedStatement.executeQuery(); while(rs1.next()){
			 * project.setID(rs.getLong(1)); project.setName(rs1.getString(2));
			 * project.setDescription(rs1.getString(3));
			 * project.setClient(rs1.getString(4)); } List<ProjectRole>
			 * projectRolesListOther = new ArrayList<ProjectRole>(); for (int i
			 * = 0; i < projectRolesList.size()-1; i++) { project =
			 * selectProjectsById(projectRolesList.get(i).getID());
			 * projectRolesListOther.add(projectRolesList.get(i));
			 * 
			 * employeeProjectDetail.setProject(project);
			 * employeeProjectDetail.setProjectRoles(projectRolesList); } for
			 * (ProjectRole projectRole2 : projectRolesList) { project =
			 * selectProjectsById(projectRole2.getID());
			 * 
			 * //error!!! employeeProjectDetail.setProject(project);
			 * employeeProjectDetail.setProjectRoles(projectRolesList);
			 * detailList.add(employeeProjectDetail); }
			 
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return detailList;*/
	

	@Override
	public List<ProjectRole> getEmployeeProjectRoles(long employeeID,
			long projectID) {

		List<ProjectRole> list = new ArrayList<ProjectRole>();
		ProjectRole projectRole = null;
		String sql = "select * from employee_project_map where employee_id = ? and project_id = ?";
		try(Connection conn = dataSource.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(sql);) {
			
			preparedStatement.setLong(1, employeeID);
			preparedStatement.setLong(2, projectID);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				projectRole = new ProjectRole();
				projectRole.setID(Long.valueOf(rs.getString(2)));
				projectRole.setRole(rs.getString(4));
				projectRole.setStartDate(rs.getDate(5));
				projectRole.setEndDate(rs.getDate(6));
				list.add(projectRole);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Project> getEmployeeProjects(long employeeID) {

		List<Project> list = new ArrayList<Project>();
		Project project = null;
		String sql = "select distinct project_id from employee_project_map where employee_id = ?";
		try(Connection conn = dataSource.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(sql);) {
			
			preparedStatement.setLong(1, employeeID);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				project = selectProjectsById(Long.valueOf(rs.getString(1)));
				list.add(project);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
