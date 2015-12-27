package org.nuno.webapp;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nuno.database.Images;
import org.nuno.service.ImagesService;
import org.nuno.utils.ImagesWrapper;
import org.nuno.utils.ResponseMessage;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/images")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ImagesResource {
	ImagesService imgserv = new ImagesService();

	// UPLOAD IMAGE
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public ResponseMessage uploadImage(
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {
		ResponseMessage resp = new ResponseMessage();
		String uploadedFileLocation = "/home/nuno/Documentos/";
		if (uploadedInputStream.equals(null))
			System.out.println("NULL OBJECT FOUNDD");
		resp = imgserv.uploadImage(uploadedInputStream, uploadedFileLocation,
				fileDetail.getFileName());

		// return Response.status(200).entity(output).build();
		return resp;
	}

	@POST
	public ResponseMessage insertImage(Images img) {

		return imgserv.insertImage(img);// Devia retornar id da image para depois ser inserido
	}
	
	@GET
	public ImagesWrapper allImage() {

		return imgserv.getAllImages();
	}
	

}
