package com.pfe.elearning.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pfe.elearning.entities.EspaceUtilisateur;
import com.pfe.elearning.metier.espaceUtilisateur.IMetierEspaceUtilisateur;
import com.pfe.elearning.metier.utilisateur.IMetierUtilisateur;

public class TestEspaceUtilisateur
{
	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	IMetierEspaceUtilisateur metier=(IMetierEspaceUtilisateur) context.getBean("metierEspaceUtilisateur");
	IMetierUtilisateur metieru=(IMetierUtilisateur) context.getBean("metierUtilisateur");
	
	@Test
	public void test() {
		
		EspaceUtilisateur parent = new EspaceUtilisateur("Mon_Esp", "descriptionEspace", new Date(), false);
		parent.setProprietaire(metieru.findById(1L));
		metier.inserer(parent);

//		List<EspaceUtilisateur>list1=metier.getListSousEspace(1L);
		
		EspaceUtilisateur sousEspace= new EspaceUtilisateur("Sous_Esp1", "Sous esp de Mon_Esp", new Date(), false);
		EspaceUtilisateur sousEspace2=new EspaceUtilisateur("Sous_Esp2", "Sous esp de Mon_Esp", new Date(), true);
//
		sousEspace.setEspaceParent(metier.findById(1L));
		sousEspace2.setEspaceParent(metier.findById(1L));
		
		metier.inserer(sousEspace);
		metier.inserer(sousEspace2);
//		
//		List<EspaceUtilisateur>list2=metier.getListSousEspace(1L);
//
//		assertTrue(list1.size()+2 ==list2.size());
			
		System.out.println("Nbr sous esp: "+metier.getListSousEspace(1L).size());
		for(EspaceUtilisateur e : metier.getListSousEspace(1L))
			System.out.println(e.getIdEspace());
		
		System.out.println(metier.getListFichiers(1L).get(0).getDateDepot());
		
	}

}
