package cyberservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.UtilisateurEntity;

@Stateless
public class UtilisateurService {
	@PersistenceContext
	EntityManager entityManager;
	
	public List<UtilisateurEntity> findAll(){
		List<UtilisateurEntity> Entities=entityManager.createNamedQuery("UtilisateurEntity.findAll",UtilisateurEntity.class).getResultList(); 
		return Entities;
	}
	

}
