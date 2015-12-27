package org.nuno.interfaces;

import org.nuno.database.Project;
import org.nuno.utils.ProjectWrapper;
import org.nuno.utils.ResponseMessage;

public interface ProjectServiceInterface {

	public ResponseMessage insertProject(Project project);// @POST Insert new
	
	public ProjectWrapper getAllProjects(); // @GET ALL PROJECTS IN DATABASE
	
	public ResponseMessage deleteProject(long id); // @DELETE Apagar utilizador x
	
}
