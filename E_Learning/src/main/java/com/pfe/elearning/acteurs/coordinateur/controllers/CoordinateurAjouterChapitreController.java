package com.pfe.elearning.acteurs.coordinateur.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.Coordinateur;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.metier.chapitres.IMetierChapitres;
import com.pfe.elearning.metier.module.IMetierModule;
import com.pfe.elearning.metier.utilisateur.IMetierUtilisateur;

@Controller
@RequestMapping(value="/coordinateur/chapitres/ajouter")
public class CoordinateurAjouterChapitreController {
	
	@Autowired
	IMetierChapitres metierChapitre;
	
	@Autowired
	IMetierModule metierModule;
	@Autowired
	IMetierUtilisateur metierUtilisateur;
	@RequestMapping(value="/")
	public String indexAjouterChapitre(Model model, HttpServletRequest request) {
		Coordinateur user = (Coordinateur)request.getSession().getAttribute("user");
		
		model.addAttribute("nbrMails", metierUtilisateur.listDesEmailsRecuNonLu(user.getIdUtilisateur()).size());
		model.addAttribute("chapitre", new Chapitres());
		model.addAttribute("modules", metierModule.listeModuleParCoordinateur(user.getIdUtilisateur()));
		model.addAttribute("module", new Module());
		
		return "/coordinateur/ajouterChapitre";
	}
	
	@RequestMapping(value="/enregistrerChapitre")
	public String enregistrerChapitre(@Valid Chapitres chapitre, Model model, HttpServletRequest request, BindingResult result) {
		if(result.hasErrors()) {
			return "/coordinateur/ajouterChapitre";
		}
		
		if(chapitre.getIdChapitre() == null) {
			chapitre.setDateCreation(new Date());
			metierChapitre.inserer(chapitre);
		}
		Coordinateur user = (Coordinateur)request.getSession().getAttribute("user");
		
		model.addAttribute("chapitre", new Chapitres());
		model.addAttribute("modules", metierModule.listeModuleParCoordinateur(user.getIdUtilisateur()));
		model.addAttribute("module", new Module());
		
		return "redirect:/coordinateur/chapitres";
	}

}
