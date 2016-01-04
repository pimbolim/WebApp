package org.nuno.database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Images {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_IMAGE")
	private long idImage;

	@Column(name = "IMAGE_DESCRIPTION")
	private String imageDescription;

	@Column(name = "DATE_CREATION")
	private Date dateCreation;

	@Column(name = "IMAGE_URL")
	private String imageUrl;

	@Column(name = "IMAGE_AVAILABLE")
	private Boolean available;
	
	@ManyToOne
	@JoinColumn(name="USER_EMAIL")//USERDETAILS
	private UserDetails user;
	
	@ManyToOne
	@JoinColumn(name="ID_PROJECT")//Project
	private Project project;
	
	@Column(name = "COMMENTS")
	@OneToMany(mappedBy = "imagem")
	private Collection<Comments> comments = new ArrayList<Comments>();

	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public long getIdImage() {
		return idImage;
	}

	public void setIdImage(long idImage) {
		this.idImage = idImage;
	}

	public String getImageDescription() {
		return imageDescription;
	}

	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}
}
