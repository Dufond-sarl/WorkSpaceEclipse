package cyberapi;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cyberservice.UtilisateurService;
import entities.UtilisateurEntity;

@RequestScoped
@Path("/utilisateur")
public class Utilisateur {
	@EJB UtilisateurService utilisateurService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UtilisateurEntity> list(){
		List<UtilisateurEntity> Entities = utilisateurService.findAll();
		return Entities;
	}
}
