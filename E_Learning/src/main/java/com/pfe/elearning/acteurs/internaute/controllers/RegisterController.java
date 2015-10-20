package com.pfe.elearning.acteurs.internaute.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfe.elearning.entities.Apprenant;
import com.pfe.elearning.entities.EspaceUtilisateur;
import com.pfe.elearning.metier.apprenant.IMetierApprenant;
import com.pfe.elearning.metier.espaceUtilisateur.IMetierEspaceUtilisateur;
import com.pfe.elearning.metier.utilisateur.IMetierUtilisateur;

@Controller
@RequestMapping(value="/register")
public class RegisterController {

	@Autowired
	IMetierUtilisateur metierUtilisateur;
	
	@Autowired
	IMetierApprenant metierApprenant;
	
	@Autowired
	IMetierEspaceUtilisateur metierEspace;
	
	@RequestMapping(value="/")
	public String register(Model model, HttpServletRequest request) {
		model.addAttribute("user", new Apprenant());
		return "/visiteur/register";
	}
	
	@RequestMapping(value="/saveUser")
	public String Saveregister(Model model, Apprenant user, HttpSession session) {
		user.setValide(false);
		user.setDateInscription(new Date());
		user.setType("APPR");
		metierApprenant.inserer(user);
		System.out.println("idUser   :    "+user.getIdUtilisateur());
		EspaceUtilisateur espaceUtilisateur = new EspaceUtilisateur("Mon espace", "Mon espace de fichiers", new Date(), false);
		espaceUtilisateur.setProprietaire(user);
		metierEspace.inserer(espaceUtilisateur);
		session.setAttribute("user", user);
		return "redirect:/apprenant/profile/";
	}
}