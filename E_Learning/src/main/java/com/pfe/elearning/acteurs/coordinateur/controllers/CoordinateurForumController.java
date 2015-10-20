package com.pfe.elearning.acteurs.coordinateur.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.SujetForum;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.metier.formation.IMetierFormation;
import com.pfe.elearning.metier.module.IMetierModule;
import com.pfe.elearning.metier.sujetForum.IMetierSujetForum;
import com.pfe.elearning.metier.utilisateur.IMetierUtilisateur;

@Controller
@RequestMapping(value = "/coordinateur/forum")
public class CoordinateurForumController {

	@Autowired
	IMetierFormation metierFormation;

	@Autowired
	IMetierModule metierModule;

	@Autowired
	IMetierUtilisateur metierUtilisateur;

	@Autowired
	IMetierSujetForum metierForum;

	@RequestMapping(value = "/")
	public String index(Model model, HttpServletRequest request) {
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		model.addAttribute("nbrMails", metierUtilisateur.listDesEmailsRecuNonLu(user.getIdUtilisateur()).size());
		ArrayList<Formation> formations = (ArrayList<Formation>) metierFormation.selectAll();
		for (Formation f : formations) {
			List<Module> m = metierFormation.getListModules(f.getIdFormation());
			if (m.size() > 0) {
				f.setModules(m);
			}
			for (Module mm : m) {
				mm.setSujetForums(metierModule.listeSujetForum(mm.getIdModule()));
			}

		}
		model.addAttribute("index", true);
		model.addAttribute("formations", formations);
		return "/coordinateur/forum";
	}

	@RequestMapping(value = "/modules")
	public String modulesFormation(Model model, Long idFormation) {
		List<Module> modules = metierFormation.getListModules(idFormation);
		for (Module m : modules) {
			List<SujetForum> sujets = metierModule.listeSujetForum(m.getIdModule());
			for (SujetForum sf : sujets) {
				sf.setMessagesForums(metierForum.getListMessageForum(sf.getIdSujet()));
			}
			m.setSujetForums(sujets);

		}
		model.addAttribute("modules", modules);
		model.addAttribute("index", false);
		return "/coordinateur/forum";
	}

}
