package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the quartier_prioritaire database table.
 * 
 */
@Entity
@Table(name="quartier_prioritaire")
@NamedQuery(name="QuartierPrioritaireEntity.findAll", query="SELECT q FROM QuartierPrioritaireEntity q")
public class QuartierPrioritaireEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_quartier")
	private Integer id;

	private String nom;

	public QuartierPrioritaireEntity() {
	}

	public Integer getIdQuartier() {
		return this.id;
	}

	public void setIdQuartier(Integer idQuartier) {
		this.id = idQuartier;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}