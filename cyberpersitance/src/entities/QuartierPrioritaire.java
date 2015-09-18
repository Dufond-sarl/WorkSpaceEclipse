package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the quartier_prioritaire database table.
 * 
 */
@Entity
@Table(name="quartier_prioritaire")
@NamedQuery(name="QuartierPrioritaire.findAll", query="SELECT q FROM QuartierPrioritaire q")
public class QuartierPrioritaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_quartier")
	private Integer idQuartier;

	private String nom;

	public QuartierPrioritaire() {
	}

	public Integer getIdQuartier() {
		return this.idQuartier;
	}

	public void setIdQuartier(Integer idQuartier) {
		this.idQuartier = idQuartier;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}