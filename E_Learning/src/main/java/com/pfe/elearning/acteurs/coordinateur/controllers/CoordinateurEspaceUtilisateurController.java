package com.pfe.elearning.acteurs.coordinateur.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pfe.elearning.entities.EspaceUtilisateur;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.metier.espaceUtilisateur.IMetierEspaceUtilisateur;
import com.pfe.elearning.metier.utilisateur.IMetierUtilisateur;

@Controller
@RequestMapping(value = "/coordinateur/espace")
public class CoordinateurEspaceUtilisateurController {

	@Autowired
	IMetierUtilisateur metierUtilisateur;

	@Autowired
	IMetierEspaceUtilisateur metierEspace;

	@RequestMapping(value = "/")
	public String indexEspace(Model model, HttpServletRequest request) {
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		model.addAttribute("nbrMails", metierUtilisateur.listDesEmailsRecuNonLu(user.getIdUtilisateur()).size());
		Long idEspace = metierUtilisateur.espaceUtilisateur(user.getIdUtilisateur()).getIdEspace();
		model.addAttribute("espacesUtilisateur", metierEspace.getListSousEspace(idEspace));
		model.addAttribute("fichierEspace", metierEspace.getListFichiers(idEspace));

		return "/coordinateur/espace";
	}

	@RequestMapping(value = "/sousEspaces", method = RequestMethod.GET)
	public @ResponseBody List<EspaceUtilisateur> getListSousEspace(@RequestParam Long idEspaceParent) {
		return metierEspace.getListSousEspace(idEspaceParent);
	}

}
