package entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity @Table(name="reservation")
@NamedQuery(name="ReservationEntity.findAll", query="SELECT r FROM ReservationEntity r")
public class ReservationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reservation")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_heur_deb")
	private Date dateHeurDeb;

	@Temporal(TemporalType.DATE)
	@Column(name="date_heur_fin")
	private Date dateHeurFin;

	private String raison;

	//uni-directional many-to-one association to Poste
	@ManyToOne
	@JoinColumn(name="id_poste")
	private PosteEntity poste;

	//uni-directional many-to-one association to TypeReservation
	@ManyToOne
	@JoinColumn(name="id_type_reservation")
	private TypeReservationEntity typeReservationEntity;

	//uni-directional many-to-one association to Usager
	@ManyToOne
	@JoinColumn(name="id_usager")
	private UsagerEntity usagerEntity;

	//uni-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="id_user")
	private UtilisateurEntity utilisateur;

	public ReservationEntity() {
	}

	public Integer getIdReservation() {
		return this.id;
	}

	public void setIdReservation(Integer idReservation) {
		this.id = idReservation;
	}

	public Date getDateHeurDeb() {
		return this.dateHeurDeb;
	}

	public void setDateHeurDeb(Date dateHeurDeb) {
		this.dateHeurDeb = dateHeurDeb;
	}

	public Date getDateHeurFin() {
		return this.dateHeurFin;
	}

	public void setDateHeurFin(Date dateHeurFin) {
		this.dateHeurFin = dateHeurFin;
	}

	public String getRaison() {
		return this.raison;
	}

	public void setRaison(String raison) {
		this.raison = raison;
	}

	public PosteEntity getPoste() {
		return this.poste;
	}

	public void setPoste(PosteEntity poste) {
		this.poste = poste;
	}

	public TypeReservationEntity getTypeReservation() {
		return this.typeReservationEntity;
	}

	public void setTypeReservation(TypeReservationEntity typeReservationEntity) {
		this.typeReservationEntity = typeReservationEntity;
	}

	public UsagerEntity getUsagerEntity() {
		return this.usagerEntity;
	}

	public void setUsagerEntity(UsagerEntity usagerEntity) {
		this.usagerEntity = usagerEntity;
	}

	public UtilisateurEntity getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(UtilisateurEntity utilisateur) {
		this.utilisateur = utilisateur;
	}

}