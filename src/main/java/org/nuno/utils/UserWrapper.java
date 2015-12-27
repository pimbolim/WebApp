package org.nuno.utils;


import java.util.ArrayList;
import java.util.List;


import org.nuno.database.UserDetails;

public class UserWrapper {

	private List<UserDetails> users;

	public UserWrapper() {
		users = new ArrayList<UserDetails>();
	}
	public List<UserDetails> getUsers() {
		return users;
	}

	public void setUsers(List<UserDetails> user) {
		this.users = user;
	}
	
}
