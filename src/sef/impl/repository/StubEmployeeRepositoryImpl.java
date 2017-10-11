package sef.impl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import sef.domain.Employee;
import sef.interfaces.repository.EmployeeRepository;

import org.apache.log4j.Logger;

public class StubEmployeeRepositoryImpl implements EmployeeRepository {


	//DataSource class encapsulates the driver, database url, username and 
	//password information.  The dataSource object is automatically created by 
	//the Spring framework and passed to the constructor therefore there's no need 
	//to instantiate the dataSource variable. A connection can be acquired by 
	//accessing the getConnection method of dataSource. 
	//
	//Tip: create member variables in this class that will contain the objects 
	//passed by the Spring framework so that other methods can access the objects.

	private static Logger log = Logger.getLogger(StubEmployeeRepositoryImpl.class);
	private DataSource dataSource;
		
	public StubEmployeeRepositoryImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Employee> findEmployeesByName(String firstName, String lastName) {
		List<Employee> list = new ArrayList<Employee>();
		Employee employee = null;
		try {
			Connection conn = dataSource.getConnection();
			String sql = "select * from employee where first_name like ? and last_name like ? or first_name = ? or last_name = ? ";
			
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, firstName+"%");
			preparedStatement.setString(2, lastName+"%");
			preparedStatement.setString(3, firstName+"%");
			preparedStatement.setString(4, lastName+"%");
			
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				employee = new Employee();
				employee.setID((long)rs.getInt(1));
				employee.setFirstName(rs.getString(2));
				employee.setLastName(rs.getString(3));
				employee.setMiddleInitial(rs.getString(4));
				employee.setLevel(rs.getString(5));
				employee.setWorkForce(rs.getString(6));
				employee.setEnterpriseID(rs.getString(7));
				list.add(employee);
			}
			conn.close();
			preparedStatement.close();
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Employee findEmployeeByID(long employeeID) {
		
		Employee employee = null;
		try {
			Connection conn = dataSource.getConnection();
			String sql = "select * from employee where id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setLong(1, employeeID);
			
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				employee = new Employee();
				employee.setID((long)rs.getInt(1));
				employee.setFirstName(rs.getString(2));
				employee.setLastName(rs.getString(3));
				employee.setMiddleInitial(rs.getString(4));
				employee.setLevel(rs.getString(5));
				employee.setWorkForce(rs.getString(6));
				employee.setEnterpriseID(rs.getString(7));
			}
			conn.close();
			preparedStatement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> findEmployeesByProject(long projectID) {
		
		List<Employee> list = new ArrayList<Employee>();
		Employee employee = null;
		try {
			Connection conn = dataSource.getConnection();
			String sql = "select distinct employee_id from employee_project_map where project_id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setLong(1, projectID);
			
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				employee = findEmployeeByID(Long.valueOf(rs.getString(1)));
				list.add(employee);
			}
			
			conn.close();
			preparedStatement.close();
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
