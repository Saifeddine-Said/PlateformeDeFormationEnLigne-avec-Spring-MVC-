package com.pfe.elearning.acteurs.coordinateur.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.Coordinateur;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.metier.ContenuChapitre.IMetierContenuChapitre;
import com.pfe.elearning.metier.chapitres.IMetierChapitres;
import com.pfe.elearning.metier.coordinateur.IMetierCoordinateur;
import com.pfe.elearning.metier.formation.IMetierFormation;
import com.pfe.elearning.metier.module.IMetierModule;
import com.pfe.elearning.metier.utilisateur.IMetierUtilisateur;

@Controller
@RequestMapping(value = "/coordinateur/contenus")
public class CoordinateurContenuChapitreController {

	@Autowired
	IMetierFormation metierFormation;

	@Autowired
	IMetierModule metierModule;

	@Autowired
	IMetierChapitres metierChapitre;

	@Autowired
	IMetierContenuChapitre metierContenu;

	@Autowired
	IMetierUtilisateur metierUtilisateur;
	
	@Autowired
	IMetierCoordinateur metierCoordinateur;

	@RequestMapping(value = "/")
	public String index(Model model, HttpServletRequest request) {
		
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");

//		Coordinateur coordinateur = (Coordinateur) request.getSession().getAttribute("user");
//		model.addAttribute("nbrMails", metierUtilisateur.listDesEmailsRecuNonLu(user.getIdUtilisateur()).size());
		model.addAttribute("formation", new Formation());
		model.addAttribute("module", new Module());
		model.addAttribute("chapitre", new Chapitres());
		model.addAttribute("contenuChapitre", new ContenuChapitre());
		
		model.addAttribute("listFormations", metierFormation.selectAll());
		
		model.addAttribute("listContenuCoordinteur",metierCoordinateur.getListContenu(user.getIdUtilisateur()));
		
		
		return "/coordinateur/contenu";
	}
	@RequestMapping(value="/ajouterContenu")
	public String ajouterContenu(Model model, @ModelAttribute ContenuChapitre contenuChapitre ,@RequestParam Long idChapitre,@RequestParam String contenu,HttpServletRequest request)
	{
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		Chapitres chapitre = metierChapitre.findById(idChapitre);
		
		contenuChapitre.setDateDerinerModification(new Date());
		contenuChapitre.setChapitre(chapitre);
		contenuChapitre.setContenu(contenu);
		
		if(contenuChapitre.getIdContenu()!= null){
				metierContenu.modifier(contenuChapitre);
		}
		else
		{
			metierContenu.inserer(contenuChapitre);
		}
				
		model.addAttribute("formation", new Formation());
		model.addAttribute("module", new Module());
		model.addAttribute("module1", new Module());
		model.addAttribute("chapitre", new Chapitres());
		model.addAttribute("contenuChapitre", new ContenuChapitre());

		model.addAttribute("listFormations", metierFormation.selectAll());
		
		return "/coordinateur/contenu";
	}
	@RequestMapping(value = "/listModuleParFormation", method = RequestMethod.GET)
	public @ResponseBody List<Module> listModules(@RequestParam Long idFormation,HttpServletRequest request) {
		
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		
		return metierCoordinateur.getListModulesCoordinateurParFormation(user.getIdUtilisateur(),idFormation);
	}

	@RequestMapping(value = "/listChapitreParModule", method = RequestMethod.GET)
	public @ResponseBody List<Chapitres> listChapitre(@RequestParam Long idModule) {
		return metierModule.listeChapitresParModule(idModule);
	}

	@RequestMapping(value = "/listContenuParChapitre", method = RequestMethod.GET)
	public @ResponseBody List<ContenuChapitre> listContenu(@RequestParam Long idChapitre) {
		return metierChapitre.listeContenuChapitre(idChapitre);
	}
	//listContenuChapitreParModule
	@RequestMapping(value = "/listContenuChapitreParModule", method = RequestMethod.GET)
	public @ResponseBody List<ContenuChapitre> listContenuParModule(@RequestParam Long idModule) {
		return metierChapitre.listeContenuChapitre(idModule);
	}

	@RequestMapping(value = "/loadContenuChpitre", method = RequestMethod.GET)
	public @ResponseBody ContenuChapitre contenuChapitre(@RequestParam Long idContenu) {
		return metierContenu.findById(idContenu);
	}
	
	@RequestMapping(value = "/enregistrerModule")
	public String enregistrerFormation(HttpServletRequest request, @ModelAttribute Module module,Long idFormation,  Model model) throws IOException {
		Coordinateur coor = (Coordinateur) request.getSession().getAttribute("user");

		Formation formation=metierFormation.findById(idFormation);
		module.setFormation(formation);
//		if (!file.isEmpty()) {
//			// BufferedImage bi = ImageIO.read(file.getInputStream());
//			module.setPhoto(file.getBytes());
//		}

			module.setDateCreation(new Date());
			module.setCoordinateur(coor);
			
			metierModule.inserer(module);

		return "redirect:/coordinateur/contenus/";
	}
	@RequestMapping(value="/enregistrerChapitre")
	public String enregistrerChapitre(@ModelAttribute Chapitres chapitre,Long idModule, Model model, HttpServletRequest request) {
		
		if(chapitre.getIdChapitre() == null) {
			Module module=metierModule.findById(idModule);
			chapitre.setModule(module);
			chapitre.setDateCreation(new Date());
			metierChapitre.inserer(chapitre);
		}
		Coordinateur user = (Coordinateur)request.getSession().getAttribute("user");
		
		//model.addAttribute("modules", metierModule.listeModuleParCoordinateur(user.getIdUtilisateur()));
		
//		model.addAttribute("formation", new Formation());
//		model.addAttribute("module", new Module());
//		model.addAttribute("module1", new Module());
//		model.addAttribute("chapitre", new Chapitres());
//		model.addAttribute("contenuChapitre", new ContenuChapitre());
		
		
		return "redirect:/coordinateur/contenus/";
	}
}
