package entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the poste database table.
 * 
 */
@Entity @Table(name="poste")
// requetes JPQL
@NamedQueries({
	@NamedQuery(name="PosteEntity.findAll", query="SELECT p FROM PosteEntity p"),
	@NamedQuery(name="PosteEntity.findBySalle",
            query="SELECT p FROM PosteEntity p WHERE p.salle = :salle" ),               
}) 


public class PosteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_poste")
	private Integer id;

	@Column(name="actif__")
	private Boolean actif;

	@Column(name="libre_service__")
	private Boolean libreService;

	private String nom;

	//uni-directional many-to-one association to Salle
	@ManyToOne
	@JoinColumn(name="id_salle", nullable=false)
	private SalleEntity salleEntity;

	public PosteEntity() {
	}

	public Integer getIdPoste() {
		return this.id;
	}

	public void setIdPoste(Integer idPoste) {
		this.id = idPoste;
	}

	public Boolean getActif() {
		return this.actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public Boolean getLibreService() {
		return this.libreService;
	}

	public void setLibreService(Boolean libreService) {
		this.libreService = libreService;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public SalleEntity getSalleEntity() {
		return this.salleEntity ;
	}

	public void setSalleEntity (SalleEntity salleEntity) {
		this.salleEntity = salleEntity;
	}

}