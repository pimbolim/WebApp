package org.nuno.interfaces;

import org.nuno.database.UserDetails;
import org.nuno.utils.ResponseMessage;
import org.nuno.utils.UserWrapper;

public interface UserServiceInterface {

	public ResponseMessage insertUser(UserDetails user);// @POST Inserir User

	public UserDetails getUser(String userEmail);// @GET User (Email user)
	
	public UserWrapper getAllUsers(); // @GET Ver Todos os utilizadores
	
	public ResponseMessage deleteUser(String userEmail);// @DELETE Apagar utilizador x

}
