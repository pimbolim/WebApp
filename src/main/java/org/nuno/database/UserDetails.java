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
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="USER_EMAIL")
	private String email;
	
	@Column(name ="USER_NAME")
	private String Nome;
	
	@Column(name ="USER_COUNTRY")
	private String Nacionalidade;
	/*
	@OneToMany(mappedBy=("USER"))
	@Column(name ="USER_COMMENTS")
	@JoinTable(joinColumns=@JoinColumn(name="USER_EMAIL"),
			 	inverseJoinColumns=@JoinColumn(name="ID_COMMENT")
	)
	private Collection<Comments> Comments;*/
	@OneToMany(mappedBy="user")
/*	@JoinTable(name ="USER_IMAGES", joinColumns=@JoinColumn(name="USER_EMAIL"),
 	inverseJoinColumns=@JoinColumn(name="IMAGE_ID")
)*/
	private Collection<Images> imagens = new ArrayList<Images>();
	
	
	@Column(name ="Projects")
	@ManyToMany(mappedBy="Users",cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	private Collection<Project> projects =new ArrayList<Project>();
	
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
	public Collection<Images> getImagens() {
		return imagens;
	}
	public void setImagens(Collection<Images> imagens) {
		this.imagens = imagens;
	}
	
}
