package org.nuno.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.nuno.database.HibernateUtil;
import org.nuno.database.Project;
import org.nuno.interfaces.ProjectServiceInterface;
import org.nuno.utils.ProjectWrapper;
import org.nuno.utils.ResponseMessage;

public class ProjectService implements ProjectServiceInterface {

	// @POST Insert new project
	public ResponseMessage insertProject(Project project) {

		ResponseMessage resp = new ResponseMessage();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		try {
			session.save(project);
			session.getTransaction().commit();

		} catch (JDBCException ex) {

			resp = resp.setInsertFail("Project " + project.getProjectName());
			return resp;
		} finally {
			session.close();
		}

		resp = resp.setInsertOK("Project " + project.getProjectName());
		return resp;

	}

	// @GET ALL PROJECTS IN DATABASE
	public ProjectWrapper getAllProjects() {
		List<Project> projects = new ArrayList<Project>();
		ProjectWrapper proWrap = new ProjectWrapper();

		Session session = HibernateUtil.getSessionFactory().openSession();

		projects = session.createCriteria(Project.class).list();

		session.close();

		proWrap.setProjects(projects);
		return proWrap;
	}

	// @DELETE Apagar utilizador x
	public ResponseMessage deleteProject(long id) {
		ResponseMessage resp = new ResponseMessage();
		Project pro = new Project();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		pro = session.get(Project.class, id);

		try {
			session.delete(pro);
			session.getTransaction().commit();

		} catch (JDBCException ex) {

			resp = resp.setUserDeleteFail("Project " + pro.getProjectName());
			return resp;
		} finally {
			session.close();
		}

		resp = resp.setDeleteOK("Project " + pro.getProjectName());
		return resp;
	}

}
