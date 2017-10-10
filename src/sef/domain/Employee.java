package sef.domain;

public class Employee {

	private long ID;
	private String firstName;
	private String lastName;
	private String middleInitial;
	private String level;
	private String workForce;
	private String enterpriseID;

	public long getID() {
		return ID;
	}

	public void setID(long id) {
		ID = id;
	}

	public String getEnterpriseID() {
		return enterpriseID;
	}

	public void setEnterpriseID(String enterpriseID) {
		this.enterpriseID = enterpriseID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getWorkForce() {
		return workForce;
	}

	public void setWorkForce(String workForce) {
		this.workForce = workForce;
	}

}
