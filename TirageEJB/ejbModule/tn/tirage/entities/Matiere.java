package tn.tirage.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Matiere
 *
 */
@Entity(name = "matiere")

public class Matiere implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_matiere")
	private Long id_matiere;

	@Column(name = "nomMatiere")
	private String nomMatiere;

	public Matiere() {
		super();
	}

	public Matiere(String nomMatiere) {
		super();
		this.nomMatiere = nomMatiere;
	}

	public Long getId_matiere() {
		return id_matiere;
	}

	public String getNomMatiere() {
		return nomMatiere;
	}

	public void setId_matiere(Long id_matiere) {
		this.id_matiere = id_matiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}
	
	@Override
	public String toString() {
		return "Matiere [id_matiere=" + id_matiere + ", nomMatiere=" + nomMatiere + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_matiere == null) ? 0 : id_matiere.hashCode());
		result = prime * result + ((nomMatiere == null) ? 0 : nomMatiere.hashCode());
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
		Matiere other = (Matiere) obj;
		if (id_matiere == null) {
			if (other.id_matiere != null)
				return false;
		} else if (!id_matiere.equals(other.id_matiere))
			return false;
		if (nomMatiere == null) {
			if (other.nomMatiere != null)
				return false;
		} else if (!nomMatiere.equals(other.nomMatiere))
			return false;
		return true;
	}

}
