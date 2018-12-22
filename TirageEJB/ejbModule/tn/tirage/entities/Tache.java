package tn.tirage.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tache
 *
 */
@Entity(name = "tache")

public class Tache implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nomFichier")
	private String nomFichier;
	@Column(name = "nombreCopies")
	private int nombreCopies;
	@Column(name = "dateTirage")
	private Date dateTirage;
	@ManyToOne
	@JoinColumn(name = "enseignant_id", referencedColumnName = "id_enseignant")
	private Enseignant enseignant;
	@ManyToOne
	@JoinColumn(name = "matiere_id", referencedColumnName = "id_matiere")
	private Matiere matiere;

	public Tache() {
		super();
	}



	public Tache(String nomFichier, int nombreCopies, Date dateTirage, Enseignant enseignant, Matiere matiere) {
		super();
		this.nomFichier = nomFichier;
		this.nombreCopies = nombreCopies;
		this.dateTirage = dateTirage;
		this.enseignant = enseignant;
		this.matiere = matiere;
	}



	public Long getId() {
		return id;
	}

	public int getNombreCopies() {
		return nombreCopies;
	}

	public Date getDateTirage() {
		return dateTirage;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombreCopies(int nombreCopies) {
		this.nombreCopies = nombreCopies;
	}

	public void setDateTirage(Date dateTirage) {
		this.dateTirage = dateTirage;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	

	public String getNomFichier() {
		return nomFichier;
	}

	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}



	@Override
	public String toString() {
		return "Tache [id=" + id + ", nomFichier=" + nomFichier + ", nombreCopies=" + nombreCopies + ", dateTirage="
				+ dateTirage + ", enseignant=" + enseignant + ", matiere=" + matiere + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTirage == null) ? 0 : dateTirage.hashCode());
		result = prime * result + ((enseignant == null) ? 0 : enseignant.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((matiere == null) ? 0 : matiere.hashCode());
		result = prime * result + ((nomFichier == null) ? 0 : nomFichier.hashCode());
		result = prime * result + nombreCopies;
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
		Tache other = (Tache) obj;
		if (dateTirage == null) {
			if (other.dateTirage != null)
				return false;
		} else if (!dateTirage.equals(other.dateTirage))
			return false;
		if (enseignant == null) {
			if (other.enseignant != null)
				return false;
		} else if (!enseignant.equals(other.enseignant))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (matiere == null) {
			if (other.matiere != null)
				return false;
		} else if (!matiere.equals(other.matiere))
			return false;
		if (nomFichier == null) {
			if (other.nomFichier != null)
				return false;
		} else if (!nomFichier.equals(other.nomFichier))
			return false;
		if (nombreCopies != other.nombreCopies)
			return false;
		return true;
	}

	
}
