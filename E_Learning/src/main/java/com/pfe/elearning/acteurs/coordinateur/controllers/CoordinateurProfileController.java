package com.pfe.elearning.acteurs.coordinateur.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.metier.coordinateur.IMetierCoordinateur;
import com.pfe.elearning.metier.formation.IMetierFormation;
import com.pfe.elearning.metier.module.IMetierModule;
import com.pfe.elearning.metier.utilisateur.IMetierUtilisateur;

@Controller
@RequestMapping(value = "/coordinateur/profile")
public class CoordinateurProfileController {

	@Autowired
	private IMetierCoordinateur metier;

	@Autowired
	private IMetierModule module;

	@Autowired
	private IMetierFormation formation;
	
	@Autowired
	IMetierUtilisateur metierUtilisateur;

	@RequestMapping(value = "/")
	public String profile(Model model, HttpServletRequest request) {
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		
		model.addAttribute("nbrMails", metierUtilisateur.listDesEmailsRecuNonLu(user.getIdUtilisateur()).size());
		
		model.addAttribute("utilisateur", user);

		model.addAttribute("modules", module.listeModuleParCoordinateur(user.getIdUtilisateur()));

		model.addAttribute("formations", formation.listeFormationsParCoordinateur(user.getIdUtilisateur()));
		
		return "/coordinateur/profile";
	}

}
