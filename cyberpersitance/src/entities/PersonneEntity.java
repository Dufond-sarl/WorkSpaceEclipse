package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the personne database table.
 * 
 */
@Entity
@Table(name="personne")
@NamedQuery(name="PersonneEntity.findAll", query="SELECT p FROM PersonneEntity p")
@Inheritance(strategy=InheritanceType.JOINED)

public class PersonneEntity implements Serializable {
	private static final long serialVersionUID = 1L;

/*	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_personne")
	private Integer id;
*/
	private String civilite;

	private String nom;

	private String prenom;

	public PersonneEntity() {
	}
/*
	public Integer getIdPersonne() {
		return this.id;
	}

	public void setIdPersonne(Integer idPersonne) {
		this.id = idPersonne;
	}
*/
	public String getCivilite() {
		return this.civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}