package org.nuno.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.nuno.database.HibernateUtil;
import org.nuno.database.Images;
import org.nuno.interfaces.ImagesServiceInterface;
import org.nuno.utils.ImagesWrapper;
import org.nuno.utils.ResponseMessage;

public class ImagesService implements ImagesServiceInterface {

	@Override
	public ResponseMessage uploadImage(InputStream uploadedInputStream,
			String uploadedFileLocation, String name) {
		ResponseMessage resp = new ResponseMessage();
		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation + name));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation + name));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			System.out.println("ERRO " + e);
			return resp.setUploadFail(name);
		}
		return resp.setUploadOK(name);
	}

	@Override
	public ResponseMessage insertImage(Images img) {
		long id = 0;
		ResponseMessage resp = new ResponseMessage();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		try {
			session.save(img);
			id= img.getIdImage();// GETS THE ID OF THE OBJECT
			session.getTransaction().commit();

		} catch (JDBCException ex) {

			resp = resp.setInsertFail("Image id " + img.getIdImage());
			return resp;
		} finally {
			//GET THE ID
			session.close();
		}

		resp = resp.setInsertOK("Image id " + img.getIdImage());
		resp.setId(id);
		return resp;
	}

	// GET ALL IMAGES IN DATABASE
	@Override
	public ImagesWrapper getAllImages() {
		List<Images> images = new ArrayList<Images>();
		ImagesWrapper imWrap = new ImagesWrapper();

		Session session = HibernateUtil.getSessionFactory().openSession();

		images = session.createCriteria(Images.class).list();

		session.close();

		imWrap.setImages(images);
		return imWrap;

	}

}
