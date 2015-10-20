package com.pfe.elearning.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.metier.acteurs.coordinateur.IMetierActeurCoordinateur;
import com.pfe.elearning.metier.coordinateur.IMetierCoordinateur;
import com.pfe.elearning.metier.module.IMetierModule;

public class TestCoordinateur {
	ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});

	@Test
	public void test() {
		//IMetierActeurCoordinateur m = (IMetierActeurCoordinateur) context.getBean("metierActeurCoordinateur");
		IMetierCoordinateur m = (IMetierCoordinateur) context.getBean("metierCoordinateur");
		IMetierModule module = (IMetierModule) context.getBean("metierModule");
		
		List<ContenuChapitre> l = m.getListContenu(3L);
		
		System.out.println(l.size());
		
		assertTrue(true);
	}

}
