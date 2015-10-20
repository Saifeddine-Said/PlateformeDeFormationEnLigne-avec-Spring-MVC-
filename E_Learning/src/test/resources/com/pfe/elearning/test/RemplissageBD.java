package com.pfe.elearning.test;

import java.util.Date;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pfe.elearning.entities.Coordinateur;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.metier.coordinateur.IMetierCoordinateur;
import com.pfe.elearning.metier.formation.IMetierFormation;
import com.pfe.elearning.metier.module.IMetierModule;

public class RemplissageBD {
	
	ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});

	@Test
	public void test() {
		IMetierCoordinateur coor = (IMetierCoordinateur) context.getBean("metierCoordinateur");
		
		IMetierModule mod = (IMetierModule) context.getBean("metierModule");
		
		IMetierFormation form = (IMetierFormation) context.getBean("metierFormation");
		
		for (int i = 0; i < 6; i++) {
			coor.inserer(new Coordinateur("BOUALI"+i, "Ali"+i, "bouali.pro@gmail.com"+i, new Date(), "TUNISIE", "Kasserine", new Date(), null, "alipassw"+i, true, true, "about user", "HOMME", "COOR"));
		}
		
		for (int i = 0; i < 6; i++) {
			Formation f = new Formation("Formation "+i, "description formation "+i, new Date(), new Date(), null);
			f.setCoordinateur(coor.findById(i+1L));
			form.inserer(f);
		}
		
		for (int i = 0; i < 6; i++) {
			Module m = new Module("Module "+i, "description module "+i, ""+i, new Date(), new Date(), null);
			m.setFormation(form.findById(i+1L));
			m.setCoordinateur(coor.findById(i+1L));
			mod.inserer(m);
		}
		
	}

}
