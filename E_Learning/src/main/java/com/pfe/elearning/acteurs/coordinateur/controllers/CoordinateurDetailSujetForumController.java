package com.pfe.elearning.acteurs.coordinateur.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfe.elearning.entities.SujetForum;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.metier.messagesForum.IMetierMessagesForum;
import com.pfe.elearning.metier.sujetForum.IMetierSujetForum;
import com.pfe.elearning.metier.utilisateur.IMetierUtilisateur;

@Controller
@RequestMapping(value="/coordinateur/detailSujet")
public class CoordinateurDetailSujetForumController {
	
	@Autowired
	IMetierUtilisateur metierUtilisateur;
	
	@Autowired
	IMetierSujetForum metierSujetForum;
	
	@Autowired
	IMetierMessagesForum metierMessageForum;
	
	
	@RequestMapping(value="/sujet")
	public String detail(Model model, HttpServletRequest request, Long idSujet) {
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		model.addAttribute("nbrMails", metierUtilisateur.listDesEmailsRecuNonLu(user.getIdUtilisateur()).size());
		
		SujetForum sujet = metierSujetForum.findById(idSujet);
		sujet.setMessagesForums(metierSujetForum.getListMessageForum(idSujet));
		
		model.addAttribute("sujet", sujet);
		model.addAttribute("messages", metierSujetForum.getListMessageForum(idSujet));
		
		
		return "/coordinateur/detailSujetForum";
	}

}
