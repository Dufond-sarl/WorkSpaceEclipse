package entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity @Table(name="utilisateur")
@NamedQuery(name="UtilisateurEntity.findAll", query="SELECT u FROM UtilisateurEntity u")
@PrimaryKeyJoinColumn(name="id_personne")
public class UtilisateurEntity extends PersonneEntity implements Serializable {
	private static final long serialVersionUID = 1L;
/*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private Integer idUser; */

	@Column(name="est_adm")
	private Boolean estAdm;

	private String login;

	@Column(name="m_d_p")
	private String mDP;
/*
	//uni-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumn(name="id_personne")
	private PersonneEntity personne;
*/
	//uni-directional many-to-one association to Site
	@ManyToOne
	@JoinColumn(name="id_site")
	private Site site;

	public UtilisateurEntity() {
	}
/*
	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
*/
	public Boolean getEstAdm() {
		return this.estAdm;
	}

	public void setEstAdm(Boolean estAdm) {
		this.estAdm = estAdm;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMDP() {
		return this.mDP;
	}

	public void setMDP(String mDP) {
		this.mDP = mDP;
	}
/*
	public PersonneEntity getPersonne() {
		return this.personne;
	}

	public void setPersonne(PersonneEntity personne) {
		this.personne = personne;
	}
*/
	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}