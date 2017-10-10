package sef.domain;

public class Project {
	private long ID;
	private String name;
	private String description;
	private String client;

	public long getID() {
		return ID;
	}

	public void setID(long id) {
		ID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

}
