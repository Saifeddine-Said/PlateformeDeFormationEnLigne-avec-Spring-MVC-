package com.pfe.elearning.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pfe.elearning.entities.Email;
import com.pfe.elearning.entities.EspaceUtilisateur;
import com.pfe.elearning.entities.Evenement;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.metier.utilisateur.IMetierUtilisateur;

public class TestUtilisateur {
	
	ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});

	@Test
	public void test() {
		IMetierUtilisateur metier = (IMetierUtilisateur) context.getBean("metierUtilisateur");
	
		//ArrayList<Utilisateur> users1 = (ArrayList<Utilisateur>) metier.selectAll();
		
		
//		metier.inserer(new Utilisateur("ssss", "ssss", "ssss", new Date(), "ss", "sss", new Date(), null, "aaaaa", false, false));
//		metier.inserer(new Utilisateur("ssss2", "ssss", "ssss", new Date(), "ss", "sss", new Date(), null, "aaaaa", false, false));
//		metier.inserer(new Utilisateur("ssss3", "ssss", "ssss", new Date(), "ss", "sss", new Date(), null, "aaaaa", false, false));
		
//		Utilisateur user = new Utilisateur("User", "User", "ssss", new Date(), "ss", "sss", new Date(), null, "aaaaa", false, false);
//		user.setIdUtilisateur(5L);
		
		
		//metier.supprimer(5L);
		
		//ArrayList<Utilisateur> users2 = (ArrayList<Utilisateur>) metier.selectAll();
		
		List<Evenement> evt = metier.listDesEvenenementsParticpe(2L);
		for(Evenement e : evt) {
			System.out.println(e.getDescriptionEvenement());
			System.out.println("id createur :    "+e.getUtilisateurCreateur().getIdUtilisateur());
		}
		
//		List<Email> mr = metier.listDesEmailsEnvoyes(1L);
//		for(Email m : mr) {
//			System.out.println("Exp : "+m.getUtilisateurExpeditreur().getIdUtilisateur());
//			System.out.println("Des : "+m.getUtilisateurDestinataire().getIdUtilisateur());
//		}
		
//		EspaceUtilisateur e = metier.espaceUtilisateur(1L);
//		System.out.println(e.getNomEspace());
		
		
		assertTrue(true);
	}

}
