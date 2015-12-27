package org.nuno.utils;

import java.util.ArrayList;
import java.util.List;

import org.nuno.database.Project;

public class ProjectWrapper {

	private List<Project> projects;
	
	public ProjectWrapper() {
		projects = new ArrayList<Project>();
	}
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> project) {
	
		this.projects = project;
	}

}
