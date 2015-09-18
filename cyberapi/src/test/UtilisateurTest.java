package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cyberapi.Utilisateur;
import entities.UtilisateurEntity;

public class UtilisateurTest {
	Utilisateur utilisateur = new Utilisateur();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testList() {
		List<UtilisateurEntity> listeUtilisateurEntities = utilisateur.list();
		assertNotNull(listeUtilisateurEntities.toString());
		
	}

}
