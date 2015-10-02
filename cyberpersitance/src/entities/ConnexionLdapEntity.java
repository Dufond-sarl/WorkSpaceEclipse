package entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the connexion_ldap database table.
 * 
 */
@Entity
@Table(name="connexion_ldap")

@NamedQueries({
	@NamedQuery(name="ConnexionLdapEntity.findAll", query="SELECT c FROM ConnexionLdapEntity c"),
	@NamedQuery(name="ConnexionLdapEntity.findByPoste",
            query="SELECT c FROM ConnexionLdapEntity c WHERE c.posteEntity = :posteEntity" ),               
    @NamedQuery(name="ConnexionLdapEntity.findByUsager",
            query="SELECT c FROM ConnexionLdapEntity c WHERE c.usagerEntity = :usagerEntity" ),               
})
public class ConnexionLdapEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_connexion_ldap")
	private Integer idConnexionLdap;

	@Temporal(TemporalType.DATE)
	@Column(name="date_heur_debut")
	private Date dateHeurDebut;

	@Temporal(TemporalType.DATE)
	@Column(name="date_heur_fin")
	private Date dateHeurFin;

	@Column(name="ip_connexion")
	private String ipConnexion;

	//bi-directional many-to-one association to Poste
	@ManyToOne
	@JoinColumn(name="id_poste")
	private PosteEntity posteEntity;

	//bi-directional many-to-one association to Usager
	@ManyToOne
	@JoinColumn(name="id_usager")
	private UsagerEntity usagerEntity;

	public ConnexionLdapEntity() {
	}

	public Integer getIdConnexionLdap() {
		return this.idConnexionLdap;
	}

	public void setIdConnexionLdap(Integer idConnexionLdap) {
		this.idConnexionLdap = idConnexionLdap;
	}

	public Date getDateHeurDebut() {
		return this.dateHeurDebut;
	}

	public void setDateHeurDebut(Date dateHeurDebut) {
		this.dateHeurDebut = dateHeurDebut;
	}

	public Date getDateHeurFin() {
		return this.dateHeurFin;
	}

	public void setDateHeurFin(Date dateHeurFin) {
		this.dateHeurFin = dateHeurFin;
	}

	public String getIpConnexion() {
		return this.ipConnexion;
	}

	public void setIpConnexion(String ipConnexion) {
		this.ipConnexion = ipConnexion;
	}

	public PosteEntity getPosteEntity() {
		return posteEntity;
	}

	public void setPosteEntity(PosteEntity posteEntity) {
		this.posteEntity = posteEntity;
	}

	public UsagerEntity getUsagerEntity() {
		return usagerEntity;
	}

	public void setUsagerEntity(UsagerEntity usagerEntity) {
		this.usagerEntity = usagerEntity;
	}



}