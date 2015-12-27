package org.nuno.webapp;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nuno.service.ProjectService;
import org.nuno.database.Project;
import org.nuno.utils.ProjectWrapper;
import org.nuno.utils.ResponseMessage;

@Path("/projects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProjectsResource {
	private ProjectService projectService = new ProjectService();
	
	@POST
	public ResponseMessage insertProject(Project project){
		return projectService.insertProject(project);
	}
	
	@GET
	public ProjectWrapper getAllProjects(){
		return projectService.getAllProjects();
	}
	
	@DELETE
	@Path("/{id}")
	public ResponseMessage deleteProject(@PathParam("id")long id){
		return projectService.deleteProject(id);
	}
	
}
