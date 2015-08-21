package entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the salle database table.
 * 
 */
@Entity  @Table(name="salle")
@NamedQuery(name="SalleEntity.findAll", query="SELECT s FROM SalleEntity s")
public class SalleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_salle")
	private Integer id;

	private String nom;

	//uni-directional many-to-one association to Site
	@ManyToOne
	@JoinColumn(name="id_site")
	private Site site;

	public SalleEntity() {
	}

	public Integer getIdSalle() {
		return this.id;
	}

	public void setIdSalle(Integer idSalle) {
		this.id = idSalle;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}