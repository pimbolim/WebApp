package org.nuno.interfaces;

import java.io.InputStream;

import org.nuno.database.Images;
import org.nuno.utils.ImagesWrapper;
import org.nuno.utils.ResponseMessage;

public interface ImagesServiceInterface {

	public ResponseMessage uploadImage(InputStream uploadedInputStream,
			String uploadedFileLocation, String name);
	
	public ResponseMessage insertImage(Images img);
	
	public ImagesWrapper getAllImages();
	
}
