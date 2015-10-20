package com.pfe.elearning.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pfe.elearning.entities.Apprenant;
import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.Concepteur;
import com.pfe.elearning.entities.Coordinateur;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.Tuteur;
import com.pfe.elearning.metier.ContenuChapitre.IMetierContenuChapitre;
import com.pfe.elearning.metier.apprenant.IMetierApprenant;
import com.pfe.elearning.metier.chapitres.IMetierChapitres;
import com.pfe.elearning.metier.concepteur.IMetierConcepteur;
import com.pfe.elearning.metier.coordinateur.IMetierCoordinateur;
import com.pfe.elearning.metier.email.IMetierEmail;
import com.pfe.elearning.metier.formation.IMetierFormation;
import com.pfe.elearning.metier.module.IMetierModule;
import com.pfe.elearning.metier.tuteur.IMetierTuteur;

public class RemplissageDB2 {
	
	ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	@Test
	public void test() {
		
		//Acteurs
		IMetierApprenant apprenant=(IMetierApprenant) context.getBean("metierApprenant");
		IMetierTuteur tuteur =(IMetierTuteur)context.getBean("metierTuteur");
		IMetierConcepteur concepteur=(IMetierConcepteur)context.getBean("metierConcepteur");
		IMetierCoordinateur coordinateur = (IMetierCoordinateur) context.getBean("metierCoordinateur");
		
		//Module
		IMetierModule module = (IMetierModule) context.getBean("metierModule");
		//Formation
		IMetierFormation formation = (IMetierFormation) context.getBean("metierFormation");
		//Chapitres
		IMetierChapitres chapitres=(IMetierChapitres)context.getBean("metierChapitres");
		//EspaceUtilisateur
		//IMetierEspaceUtilisateur espaceUtilisateur =(IMetierEspaceUtilisateur)context.getBean("metierEsapceUtilisateur");
		//Email
		IMetierEmail email=(IMetierEmail)context.getBean("metierEmail");
		
		IMetierContenuChapitre contenuChapitre=(IMetierContenuChapitre)context.getBean("metierContenuChapitre");
		
		
		//insertion dans la BD		
			
		
		/**
		 * 
		 * Les acteurs
		 */
			//Apprenat
			apprenant.inserer(new Apprenant("BOUALI", "Ali", "bouali.pro@gmail.apprenant", new Date(), "TUNISIE", "Kasserine", new Date(), null, "admin", true, true, "about user", "HOMME", "APPR"));
			apprenant.inserer(new Apprenant("SAID", "Saifeddine", "saifeddineSaid@gmail.apprenant", new Date(), "TUNISIE", "Sousse", new Date(), null, "admin", true, true, "about user", "HOMME", "APPR"));
			//Coordinateur
			coordinateur.inserer(new Coordinateur("BOUALI", "Ali", "bouali.pro@gmail.coordinateur", new Date(), "TUNISIE", "Kasserine", new Date(), null, "admin", true, true, "about user", "HOMME", "COOR"));
			coordinateur.inserer(new Coordinateur("SAID", "Saifeddine", "saifeddineSaid@gmail.coordinateur", new Date(), "TUNISIE", "Sousse", new Date(), null, "admin", true, true, "about user", "HOMME", "COOR"));
			//tuteur
			tuteur.inserer(new Tuteur("BOUALI", "Ali", "bouali.pro@gmail.tuteur", new Date(), "TUNISIE", "Kasserine", new Date(), null, "admin", true, true, "about user", "HOMME", "TUTE"));
			tuteur.inserer(new Tuteur("SAID", "Saifeddine", "saifeddineSaid@gmail.tuteur", new Date(), "TUNISIE", "Sousse", new Date(), null, "admin", true, true, "about user", "HOMME", "TUTE"));
			//concepteur
			concepteur.inserer(new Concepteur("BOUALI", "Ali", "bouali.pro@gmail.concepteur", new Date(), "TUNISIE", "Kasserine", new Date(), null, "admin", true, true, "about user", "HOMME", "CONC"));
			concepteur.inserer(new Concepteur("SAID", "Saifeddine", "saifeddineSaid@gmail.concepteur", new Date(), "TUNISIE", "Sousse", new Date(), null, "admin", true, true, "about user", "HOMME", "CONC"));
			
		

		
			/**
			 * 
			 * Formation
			 */
			Formation f = new Formation("Formation Web", "Vous avez un talent pour les technologies numériques, la communication ou la création ? Cette formation est une offre unique qui a pour ambition de rendre les participants opérationnels de la création à la gestion d'un site ou d’une application web. ", new Date(), new Date(), null);
			Formation f1 = new Formation("Formation Reseaux", "L’objectif de la formation réseaux : les fondamentaux est de permettre au stagiaire de préparer la certification CISCO CCNA 1er module, notions de base sur les réseaux. ", new Date(), new Date(), null);
			Formation f2 = new Formation("Formation Base de donnee", "description formation ", new Date(), new Date(), null);
			Formation f3 = new Formation("Formation programmation", "description formation ", new Date(), new Date(), null);
			Formation f4 = new Formation("Formation desgin", "description formation ", new Date(), new Date(), null);
			Formation f5 = new Formation("Formation Programation Mobile", "description formation ", new Date(), new Date(), null);
			
			f.setCoordinateur(coordinateur.findById(1L));
			f1.setCoordinateur(coordinateur.findById(2L));
			f2.setCoordinateur(coordinateur.findById(3L));
			f3.setCoordinateur(coordinateur.findById(1L));
			f4.setCoordinateur(coordinateur.findById(2L));
			
			 formation.inserer(f);
			 formation.inserer(f1);
			 formation.inserer(f2);
			 formation.inserer(f3);
			 formation.inserer(f4);
			 
				/**
				 * 
				 * Les modules
				 */

				Module m = new Module("Module HTML5 ", "description module html5", "1", new Date(), new Date(), null);
				Module m1 = new Module("Module CSS3 ", "description module css3", "2", new Date(), new Date(), null);
				Module m2 = new Module("Module PHP5", "description module PHP5", "3", new Date(), new Date(), null);
				Module m3 = new Module("Module JavaScript", "description module javaScript", "4", new Date(), new Date(), null);
				Module m4 = new Module("Module JQuery", "description module JQuery", "5", new Date(), new Date(), null);

				m.setFormation(formation.findById(1L));
				m.setCoordinateur(coordinateur.findById(1L));
				
				m1.setFormation(formation.findById(1L));
				m1.setCoordinateur(coordinateur.findById(1L));
				
				m2.setFormation(formation.findById(1L));
				m2.setCoordinateur(coordinateur.findById(1L));
				
				m3.setFormation(formation.findById(1L));
				m3.setCoordinateur(coordinateur.findById(1L));
				
				m4.setFormation(formation.findById(1L));
				m4.setCoordinateur(coordinateur.findById(1L));
				
				module.inserer(m);
				module.inserer(m1);
				module.inserer(m2);
				module.inserer(m3);
				module.inserer(m4);
				
			 
			/**
			 * 
			 * Chapitres
			 */
				
				Chapitres c = new Chapitres("Introduction", "discription Chapitre1", "1", new Date(), new Date());
				Chapitres c1 = new Chapitres("chapitres2", "discription Chapitre2", "1", new Date(), new Date());
				Chapitres c2 = new Chapitres("chapitres 3", "discription Chapitre3", "1", new Date(), new Date());
				Chapitres c3 = new Chapitres("chapitres 4", "discription Chapitre4", "1", new Date(), new Date());
				
				c1.setModule(module.findById(1L));
				c2.setModule(module.findById(1L));
				c3.setModule(module.findById(1L));
				c.setModule(module.findById(1L));
				
				
				chapitres.inserer(c);
				chapitres.inserer(c1);
				chapitres.inserer(c2);
				chapitres.inserer(c3);
				
				/***
				 * 
				 * ContenuChapitre
				 * 
				 */
			
			/**
			 * 
			 * Espace utilisateur
			 */
				
				
			/**
			 * email
			 * 
			 */
					
	}
}
