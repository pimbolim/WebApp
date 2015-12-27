package org.nuno.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.nuno.database.HibernateUtil;
import org.nuno.database.UserDetails;
import org.nuno.interfaces.UserServiceInterface;
import org.nuno.utils.UserWrapper;
import org.nuno.utils.ResponseMessage;

public class UserService implements UserServiceInterface {

	// @POST Inserir User
	public ResponseMessage insertUser(UserDetails user) {

		ResponseMessage resp = new ResponseMessage();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		try {
			session.save(user);
			session.getTransaction().commit();

		} catch (JDBCException ex) {

			resp = resp.setUserInsertFail(user.getEmail());
			return resp;
		} finally {
			session.close();
		}

		resp = resp.setUserInsertOK(user.getEmail());
		return resp;

	}

	// @GET User (Email user)
	public UserDetails getUser(String userEmail) {

		UserDetails user = new UserDetails();

		Session session = HibernateUtil.getSessionFactory().openSession();
		user = session.get(UserDetails.class, userEmail);
		session.close();

		return user;

	}

	// @GET Ver Todos os utilizadores
	public UserWrapper getAllUsers() {
		List<UserDetails> users = new ArrayList<UserDetails>();
		UserWrapper userW = new UserWrapper();

		Session session = HibernateUtil.getSessionFactory().openSession();
		users = session.createCriteria(UserDetails.class).list();
		session.close();

		userW.setUsers(users);
		return userW;
	}

	// @DELETE Apagar utilizador x
	public ResponseMessage deleteUser(String userEmail) {
		ResponseMessage resp = new ResponseMessage();
		UserDetails user = new UserDetails();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		user = session.get(UserDetails.class, userEmail);

		try {
			session.delete(user);
			session.getTransaction().commit();

		} catch (JDBCException ex) {

			resp = resp.setUserDeleteFail(user.getEmail());
			return resp;
		} finally {
			session.close();
		}

		resp = resp.setUserDeleteOK(user.getEmail());
		return resp;
	}

}
