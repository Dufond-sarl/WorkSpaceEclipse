package entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the adresse database table.
 * 
 */
@Entity
@Table(name="adresse")
@NamedQuery(name="AdresseEntity.findAll", query="SELECT a FROM AdresseEntity a")
public class AdresseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_adresse")
	private Integer id;

	@Column(name="code_postal")
	private String codePostal;

	@Column(name="complement_adresse")
	private String complementAdresse;

	@Column(name="numero_rue")
	private String numeroRue;

	private String ville;

	public AdresseEntity() {
	}

	public Integer getIdAdresse() {
		return this.id;
	}

	public void setIdAdresse(Integer idAdresse) {
		this.id = idAdresse;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getComplementAdresse() {
		return this.complementAdresse;
	}

	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}

	public String getNumeroRue() {
		return this.numeroRue;
	}

	public void setNumeroRue(String numeroRue) {
		this.numeroRue = numeroRue;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}