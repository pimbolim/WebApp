package org.nuno.utils;

import java.util.ArrayList;
import java.util.List;

import org.nuno.database.Images;

public class ImagesWrapper {

	private List<Images> images;

	public ImagesWrapper() {
		images = new ArrayList<Images>();
	}

	public List<Images> getImages() {
		return images;
	}

	public void setImages(List<Images> images) {
		this.images = images;
	}

}
