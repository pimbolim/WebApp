package org.nuno.database;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class UserDetails {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_EMAIL")
	private String email;

	@Column(name = "USER_NAME")
	private String Nome;

	@Column(name = "USER_COUNTRY")
	private String Nacionalidade;
	
	@Column(name = "USER_PASSWORD")
	private String Password;

	@Column(name = "Images")
	@OneToMany(mappedBy = "user")
	private Collection<Images> images = new ArrayList<Images>();

	@Column(name = "Projects")
	@ManyToMany(mappedBy = "Users", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Collection<Project> projects = new ArrayList<Project>();

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNacionalidade() {
		return Nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		Nacionalidade = nacionalidade;
	}

	public Collection<Project> getProjects() {
		return projects;
	}

	public void setProjects(Collection<Project> projects) {
		this.projects = projects;
	}

	public Collection<Images> getImages() {
		return images;
	}

	public void setImages(Collection<Images> images) {
		this.images = images;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	

}
