package cyberservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.UsagerEntity;

@Stateless 
public class UsagerService {
	@PersistenceContext
	EntityManager entityManager;
	
	public List<UsagerEntity> findAll(){
		List<UsagerEntity> usagerEntities=entityManager.createNamedQuery("UsagerEntity.findAll",UsagerEntity.class).getResultList(); 
		return usagerEntities;
	}
	
	public UsagerEntity create(UsagerEntity usagerEntity) {
		entityManager.persist(usagerEntity);
		return usagerEntity;
	}
}