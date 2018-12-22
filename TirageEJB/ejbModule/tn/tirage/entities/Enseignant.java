package tn.tirage.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Entity implementation class for Entity: Enseignant
 *
 */
@Entity(name = "enseignant")
public class Enseignant implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_enseignant")
	private Long id_enseignant;

	@Column(name = "nomComplet")
	private String nomComplet;

	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },fetch=FetchType.EAGER)
	@JoinTable(name = "enseignement", joinColumns = @JoinColumn(name = "id_enseignant"), inverseJoinColumns = @JoinColumn(name = "id_matiere"))
	private Set<Matiere> matieres = new HashSet<>();

	public Enseignant() {
		super();
	}

	public Enseignant(String nomComplet, String login, String password) {

		this.nomComplet = nomComplet;
		this.login = login;
		this.password = password;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId_enseignant() {
		return id_enseignant;
	}

	public void setId_enseignant(Long id_enseignant) {
		this.id_enseignant = id_enseignant;
	}

	public Set<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}

	@Override
	public String toString() {
		return "Enseignant [id=" + id_enseignant + ", nomComplet=" + nomComplet + ", login=" + login + ", password="
				+ password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_enseignant == null) ? 0 : id_enseignant.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nomComplet == null) ? 0 : nomComplet.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enseignant other = (Enseignant) obj;
		if (id_enseignant == null) {
			if (other.id_enseignant != null)
				return false;
		} else if (!id_enseignant.equals(other.id_enseignant))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nomComplet == null) {
			if (other.nomComplet != null)
				return false;
		} else if (!nomComplet.equals(other.nomComplet))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}
