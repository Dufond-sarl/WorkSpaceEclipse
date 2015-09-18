package cyberapi;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cyberservice.UsagerService;
import entities.UsagerEntity;

@RequestScoped
@Path("/usager")
public class Usager {
	@EJB UsagerService usagerService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsagerEntity> list(){
		List<UsagerEntity> Entities = usagerService.findAll();
		return Entities;
	}
	
	@POST	
	@Produces(MediaType.APPLICATION_JSON)
	public UsagerEntity create(UsagerEntity usagerEntityToCreate){
		UsagerEntity Entity = usagerService.create(usagerEntityToCreate);
		return Entity;
	}
	
}
