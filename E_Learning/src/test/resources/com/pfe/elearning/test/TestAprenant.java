package com.pfe.elearning.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pfe.elearning.metier.module.IMetierModule;

public class TestAprenant {
	
	ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});

	@Test
	public void test() {
		IMetierModule metier = (IMetierModule) context.getBean("metierModule");
	
		
		
//		metier.inserer(new Apprenant("bouali", "ali", "kjkjj", new Date(), "kjkjkjkj", "sousse", new Date(), null, "poiuytr", false, true));
		
//		List<GroupeFormation> list = metier.listeDesGroupeFormationParApprenant(3L);
//		
//		for(GroupeFormation g : list) {
//			System.out.println("nom : "+g.getNomGroupe());
//			List<Module> m = (List<Module>) g.getModules();
//			for(Module m1 : m) {
//				System.out.println("nom module : "+m1.getNomModule());
//			}
//		}
		
		//List<Module> l = metier.lis
		
		
		assertTrue(true);
	}

}
