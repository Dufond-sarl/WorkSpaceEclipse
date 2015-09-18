package entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the usager database table.
 * 
 */
@Entity @Table(name="usager")
@NamedQuery(name="UsagerEntity.findAll", query="SELECT u FROM UsagerEntity u")
@PrimaryKeyJoinColumn(name="id_personne")
public class UsagerEntity extends PersonneEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usager")
	private Integer idUsager;

	@Column(name="accompagne_mission_locale")
	private Boolean accompagneMissionLocale;

	@Column(name="categorie_sp")
	private String categorieSp;

	@Temporal(TemporalType.DATE)
	@Column(name="date_de_naissance")
	private Date dateDeNaissance;

	@Column(name="exclu_service")
	private Boolean excluService;

	@Column(name="niveau_de_formation")
	private String niveauDeFormation;

	//uni-directional many-to-one association to Adresse
	@ManyToOne
	@JoinColumn(name="id_adresse")
	private AdresseEntity adresse;

	//uni-directional many-to-one association to QuartierPrioritaire
	@ManyToOne
	@JoinColumn(name="id_quartier")
	private QuartierPrioritaireEntity quartierPrioritaire;

	//uni-directional many-to-one association to Site
	@ManyToOne
	@JoinColumn(name="id_site")
	private SiteEntity siteEntity;

	//uni-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="id_user")
	private UtilisateurEntity utilisateur;

	public UsagerEntity() {
	}

	public Integer getIdUsager() {
		return this.idUsager;
	}

	public void setIdUsager(Integer idUsager) {
		this.idUsager = idUsager;
	}

	public Boolean getAccompagneMissionLocale() {
		return this.accompagneMissionLocale;
	}

	public void setAccompagneMissionLocale(Boolean accompagneMissionLocale) {
		this.accompagneMissionLocale = accompagneMissionLocale;
	}

	public String getCategorieSp() {
		return this.categorieSp;
	}

	public void setCategorieSp(String categorieSp) {
		this.categorieSp = categorieSp;
	}

	public Date getDateDeNaissance() {
		return this.dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Boolean getExcluService() {
		return this.excluService;
	}

	public void setExcluService(Boolean excluService) {
		this.excluService = excluService;
	}

	public String getNiveauDeFormation() {
		return this.niveauDeFormation;
	}

	public void setNiveauDeFormation(String niveauDeFormation) {
		this.niveauDeFormation = niveauDeFormation;
	}

	public AdresseEntity getAdresse() {
		return this.adresse;
	}

	public void setAdresse(AdresseEntity adresse) {
		this.adresse = adresse;
	}

	public QuartierPrioritaireEntity getQuartierPrioritaire() {
		return this.quartierPrioritaire;
	}

	public void setQuartierPrioritaire(QuartierPrioritaireEntity quartierPrioritaire) {
		this.quartierPrioritaire = quartierPrioritaire;
	}

	public SiteEntity getSite() {
		return this.siteEntity;
	}

	public void setSite(SiteEntity siteEntity) {
		this.siteEntity = siteEntity;
	}

	public UtilisateurEntity getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(UtilisateurEntity utilisateur) {
		this.utilisateur = utilisateur;
	}

}