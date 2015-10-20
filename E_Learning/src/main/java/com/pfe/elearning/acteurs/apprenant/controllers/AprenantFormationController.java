package com.pfe.elearning.acteurs.apprenant.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pfe.elearning.entities.Apprenant;
import com.pfe.elearning.entities.Examen;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.metier.ContenuChapitre.IMetierContenuChapitre;
import com.pfe.elearning.metier.apprenant.IMetierApprenant;
import com.pfe.elearning.metier.chapitres.IMetierChapitres;
import com.pfe.elearning.metier.examen.IMetierExamen;
import com.pfe.elearning.metier.formation.IMetierFormation;
import com.pfe.elearning.metier.module.IMetierModule;

@Controller
@RequestMapping(value = "/apprenant/formations")
public class AprenantFormationController {

	@Autowired
	IMetierFormation metierFormation;

	@Autowired
	IMetierApprenant metierApprenant;

	@Autowired
	IMetierModule metierModule;

	@Autowired
	IMetierChapitres metierChapitres;

	@Autowired
	IMetierExamen metierExamen;

	@Autowired
	IMetierContenuChapitre metierContenuChapitre;

	@RequestMapping(value = "/")
	public String formation(Model model, HttpSession session) {

		model.addAttribute("listFormations", metierFormation.selectAll());
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		session.setAttribute("nbrCours", metierApprenant.listeDesModuleParApprenant(user.getIdUtilisateur()).size());
		return "/apprenant/formation";
	}

	@RequestMapping(value = "/modules")
	public String modulesParFormation(HttpSession session, Model model, HttpServletRequest request) {

		String id = request.getParameter("id");
		Formation formation = metierFormation.findById(Long.parseLong(id));
		session.setAttribute("formation", formation);
		Utilisateur user = (Utilisateur) session.getAttribute("user");

		model.addAttribute("listInscriptionApp", metierApprenant.listeDesModuleParApprenant(user.getIdUtilisateur()));
		model.addAttribute("listModules", metierFormation.getListModules(Long.parseLong(id)));
		return "/apprenant/modules";
	}

	@RequestMapping(value = "/chapitres")
	public String chapitresParModules(Long idMod, Model model, HttpSession session) {
		Boolean inscrit = false;
		session.setAttribute("idModule", idMod);
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		List<Examen> listExamenApprenant = metierApprenant.listExamenParApprenant(user.getIdUtilisateur());

		model.addAttribute("listChapiters", metierModule.listeChapitresParModule(idMod));
		model.addAttribute("listExamen", metierExamen.selectAll());
		model.addAttribute("listExamenApprenant", listExamenApprenant);
		model.addAttribute("IdModule", idMod);

		for (Module module : metierApprenant.listeDesModuleParApprenant(user.getIdUtilisateur())) {

			if (module.getIdModule().equals(idMod))
				inscrit = true;
		}
		session.setAttribute("inscrit", inscrit);

		return "/apprenant/chapitres";
	}

	@RequestMapping(value = "/inscription")
	public String inscription(HttpSession session, Model model) {

		Long idModule = (Long) session.getAttribute("idModule");
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		Boolean inscrit = (Boolean) session.getAttribute("inscrit");

		if (inscrit) {
			metierApprenant.annulerInscription(idModule, user.getIdUtilisateur());
			session.setAttribute("inscrit", false);
		} else {
			metierApprenant.ajouterInscription(idModule, user.getIdUtilisateur());
			session.setAttribute("inscrit", true);
		}
		session.setAttribute("nbrCours", metierApprenant.listeDesModuleParApprenant(user.getIdUtilisateur()).size());
		model.addAttribute("listChapiters", metierModule.listeChapitresParModule(idModule));
		return "apprenant/chapitres";
	}

	@RequestMapping(value = "/MesCours")
	public String inscriptionApprenant(Model model, HttpSession session) {
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		model.addAttribute("listModules", metierApprenant.listeDesModuleParApprenant(user.getIdUtilisateur()));
		model.addAttribute("listModulesApp", metierApprenant.listeDesModuleParApprenant(user.getIdUtilisateur()));
		return "/apprenant/modules";
	}

	@RequestMapping(value = "/contenuChapitre")
	public String contenuChapitreApprenant(Model model, HttpSession session, HttpServletRequest request) {

		Utilisateur user = (Utilisateur) session.getAttribute("user");
		String idChapitre = request.getParameter("idChap");
		String idModule = request.getParameter("idMod");
		String idContenu = request.getParameter("idContenu");

		model.addAttribute("contenuChapitre", metierContenuChapitre.findById(Long.parseLong(idContenu)));
		// model.addAttribute("contenuChapitre",metierChapitres.(Long.parseLong(idChapitre)));
		model.addAttribute("listChapitre", metierModule.listeChapitresParModule(Long.parseLong(idModule)));
		model.addAttribute("Chapitre", metierChapitres.findById(Long.parseLong(idChapitre)));

		return "/apprenant/contenu";
	}

	/*
	 * 
	 * Photo
	 */
	@RequestMapping(value = "photoUser", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoUser(Long idUser) throws IOException {
		Apprenant apprenant = metierApprenant.findById(idUser);
		return IOUtils.toByteArray(new ByteArrayInputStream(apprenant.getPhoto()));
	}

	@RequestMapping(value = "photoFormation", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoFormation(Long idFormation) throws IOException {
		Formation formation = metierFormation.findById(idFormation);
		return IOUtils.toByteArray(new ByteArrayInputStream(formation.getPhoto()));
	}

	@RequestMapping(value = "photoModule", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoModule(Long idModule) throws IOException {
		Module module = metierModule.findById(idModule);
		return IOUtils.toByteArray(new ByteArrayInputStream(module.getPhoto()));
	}

}
