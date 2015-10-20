package com.pfe.elearning.acteurs.coordinateur.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pfe.elearning.entities.Coordinateur;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.metier.coordinateur.IMetierCoordinateur;
import com.pfe.elearning.metier.formation.IMetierFormation;
import com.pfe.elearning.metier.module.IMetierModule;
import com.pfe.elearning.metier.utilisateur.IMetierUtilisateur;

@Controller
@RequestMapping(value = "/coordinateur")
public class CoordinateurIndexController {

	@Autowired
	IMetierCoordinateur metier;

	@Autowired
	IMetierUtilisateur metierUtilisateur;

	@Autowired
	IMetierFormation metierFormation;

	@Autowired
	IMetierModule metierModules;
	

	@RequestMapping(value = "/")
	public String indexCoordinateur(Model model, HttpServletRequest request) {
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");

		model.addAttribute("nbrMails", metierUtilisateur.listDesEmailsRecuNonLu(user.getIdUtilisateur()).size());

		model.addAttribute("utilisateur", user);

		model.addAttribute("modules", metierModules.listeModuleParCoordinateur(user.getIdUtilisateur()));

		model.addAttribute("formations", metierFormation.listeFormationsParCoordinateur(user.getIdUtilisateur()));

		List<Formation> f = metierFormation.listeFormationsAutresCoordinateurs(user.getIdUtilisateur());
		model.addAttribute("formsAutres", f);

		model.addAttribute("modsAutres", metierModules.listeModuleParAUtresCoordinateurs(user.getIdUtilisateur()));
		
		model.addAttribute("coordinateurs", metier.listeCoordinateurs(user.getIdUtilisateur()));
		return "/coordinateur/index";
	}

	@RequestMapping(value = "photoUser", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCat(Long idUser) throws IOException {
		Coordinateur user = metier.findById(idUser);
		return IOUtils.toByteArray(new ByteArrayInputStream(user.getPhoto()));
	}

}
