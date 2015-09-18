package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the type_reservation database table.
 * 		(Table de paramétrage)
 */
@Entity
@Table(name="type_reservation")
@NamedQuery(name="TypeReservationEntity.findAll", query="SELECT t FROM TypeReservationEntity t")
public class TypeReservationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_type_reservation")
	private Integer idTypeReservation;

	private String nom;

	public TypeReservationEntity() {
	}

	public Integer getIdTypeReservation() {
		return this.idTypeReservation;
	}

	public void setIdTypeReservation(Integer idTypeReservation) {
		this.idTypeReservation = idTypeReservation;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}