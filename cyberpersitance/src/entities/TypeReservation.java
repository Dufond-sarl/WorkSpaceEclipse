package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the type_reservation database table.
 * 
 */
@Entity
@Table(name="type_reservation")
@NamedQuery(name="TypeReservation.findAll", query="SELECT t FROM TypeReservation t")
public class TypeReservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_type_reservation")
	private Integer idTypeReservation;

	private String nom;

	public TypeReservation() {
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