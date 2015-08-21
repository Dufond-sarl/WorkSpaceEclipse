package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the site database table.
 * 
 */
@Entity
@NamedQuery(name="Site.findAll", query="SELECT s FROM Site s")
public class Site implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_site")
	private Integer idSite;

	@Column(name="h_fermeture")
	private Time hFermeture;

	@Column(name="h_ouverture")
	private Time hOuverture;

	private String nom;

	//uni-directional many-to-one association to Adresse
	@ManyToOne
	@JoinColumn(name="id_adresse")
	private AdresseEntity adresse;

	public Site() {
	}

	public Integer getIdSite() {
		return this.idSite;
	}

	public void setIdSite(Integer idSite) {
		this.idSite = idSite;
	}

	public Time getHFermeture() {
		return this.hFermeture;
	}

	public void setHFermeture(Time hFermeture) {
		this.hFermeture = hFermeture;
	}

	public Time getHOuverture() {
		return this.hOuverture;
	}

	public void setHOuverture(Time hOuverture) {
		this.hOuverture = hOuverture;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public AdresseEntity getAdresse() {
		return this.adresse;
	}

	public void setAdresse(AdresseEntity adresse) {
		this.adresse = adresse;
	}

}