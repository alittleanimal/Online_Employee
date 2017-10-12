package sef.impl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import sef.domain.EmployeeSkill;
import sef.domain.Project;
import sef.interfaces.repository.SkillRepository;

import org.apache.log4j.Logger;

public class StubSkillRepositoryImpl implements SkillRepository{

	//DataSource class encapsulates the driver, database url, username and 
	//password information.  The dataSource object is automatically created by 
	//the Spring framework and passed to the constructor therefore there's no need 
	//to instantiate the dataSource variable. A connection can be acquired by 
	//accessing the getConnection method of dataSource. 
	//
	//Tip: create member variables in this class that will contain the objects 
	//passed by the Spring framework so that other methods can access the objects.
		
	private static Logger log = Logger.getLogger(StubSkillRepositoryImpl.class);
	private DataSource dataSource;

	public StubSkillRepositoryImpl(DataSource dataSource){
		this.dataSource = dataSource;
	}

	@Override
	public List<EmployeeSkill> findEmployeeSkills(long employeeID) {

		List<EmployeeSkill> list = new ArrayList<EmployeeSkill>();
		EmployeeSkill employeeSkill = null;
		String sql = "select employee_id, name, description, rating from employee_skill_map map, skill where employee_id = ? and map.skill_id = skill.id ";
		try(Connection conn = dataSource.getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(sql);) {
			
			preparedStatement.setLong(1, employeeID);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				employeeSkill = new EmployeeSkill();
				employeeSkill.setID(Long.valueOf(rs.getString(1)));
				employeeSkill.setName(rs.getString(2));
				employeeSkill.setDescription(rs.getString(3));
				employeeSkill.setRating(rs.getInt(4));
				list.add(employeeSkill);
			}
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
