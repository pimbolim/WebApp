package org.nuno.webapp;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import org.nuno.database.UserDetails;
import org.nuno.service.UserService;
import org.nuno.utils.UserWrapper;
import org.nuno.utils.ResponseMessage;


@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfilesResource {
	private UserService userService = new UserService();
	
	@GET
	public UserWrapper getAllUsers(){
		return userService.getAllUsers();	
	}
	
	@GET
	@Path("/{email}")
	public UserDetails getUser(@PathParam("email")String email){
		return userService.getUser(email);	
	}
	
	@POST
	public ResponseMessage insertUser(UserDetails user){
		return userService.insertUser(user);
	}
	
	@DELETE
	@Path("/{email}")
	public ResponseMessage deleteUser(@PathParam("email")String email){
		return userService.deleteUser(email);
	}
	
	
			
}
