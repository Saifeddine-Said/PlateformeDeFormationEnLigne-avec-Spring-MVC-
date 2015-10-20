package com.pfe.elearning.acteurs.coordinateur.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.metier.utilisateur.IMetierUtilisateur;

@Controller
@RequestMapping(value="/coordinateur/examens/ajouter")
public class CoordinateurAjouterExamenController {

	@Autowired
	IMetierUtilisateur metierUtilisateur;
	
	@RequestMapping(value="/")
	public String indexAjouterExamen(Model model, HttpServletRequest request) {
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		model.addAttribute("nbrMails", metierUtilisateur.listDesEmailsRecuNonLu(user.getIdUtilisateur()).size());
		return "/coordinateur/ajouterExamen";
	}
}
