package com.pfe.elearning.acteurs.apprenant.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.metier.apprenant.IMetierApprenant;
import com.pfe.elearning.metier.formation.IMetierFormation;
import com.pfe.elearning.metier.module.IMetierModule;

@Controller
@RequestMapping(value = "/apprenant")
public class ApprenantIndexcontroller {
	@Autowired
	IMetierApprenant metier;

	@Autowired
	IMetierFormation metierFormation;

	@Autowired
	IMetierModule metierModules;

	@RequestMapping(value = "/")
	public String index(HttpSession session, Model model) {
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		session.setAttribute("nbrCours", metier.listeDesModuleParApprenant(user.getIdUtilisateur()).size());
		List<Formation> formations = metierFormation.selectAll();
		
		System.err.println("ssssssssss ::     "+formations.size());

		model.addAttribute("modules", formations);

		model.addAttribute("formations", metierFormation.selectAll());

		return "/apprenant/index";
	}

}
