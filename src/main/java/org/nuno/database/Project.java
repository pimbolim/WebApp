package org.nuno.database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Project")
	private long idProject;

	@Column(name = "PROJECT_NAME")
	private String projectName;

	@Column(name = "PROJECT_TYPE")
	private String type;

	@Column(name = "DATE_CREATION")
	private String dateCreation;

	@Column(name = "PROJECT_USERS")
	
	@ManyToMany(cascade= CascadeType.PERSIST,fetch=FetchType.EAGER)
	
	private Collection<UserDetails> Users = new ArrayList<UserDetails>();

	public Project() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		dateCreation = dateFormat.format(new Date());
	}

	public long getIdProject() {
		return idProject;
	}

	public void setIdProject(long idProject) {
		this.idProject = idProject;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Collection<UserDetails> getUsers() {
		return Users;
	}

	public void setUsers(Collection<UserDetails> users) {
		Users = users;
	}


}
