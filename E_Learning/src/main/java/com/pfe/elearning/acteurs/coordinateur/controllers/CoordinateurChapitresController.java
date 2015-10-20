package com.pfe.elearning.acteurs.coordinateur.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.Coordinateur;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.metier.ContenuChapitre.IMetierContenuChapitre;
import com.pfe.elearning.metier.chapitres.IMetierChapitres;
import com.pfe.elearning.metier.formation.IMetierFormation;
import com.pfe.elearning.metier.module.IMetierModule;
import com.pfe.elearning.metier.utilisateur.IMetierUtilisateur;
import com.pfe.elearning.models.ModelChapitre;

@Controller
@RequestMapping(value="/coordinateur/chapitres")
public class CoordinateurChapitresController {
	
	@Autowired
	IMetierChapitres metierChapitre;
	
	@Autowired
	IMetierModule metierModule;
	
	@Autowired
	IMetierFormation metierFormation;
	
	@Autowired
	IMetierContenuChapitre metierContenuChapitres;
	
	@Autowired
	IMetierUtilisateur metierUtilisateur;
	
	@RequestMapping(value="/")
	public String indexChapitres(Model model, HttpServletRequest request) {
		Coordinateur user = (Coordinateur)request.getSession().getAttribute("user");
		model.addAttribute("nbrMails", metierUtilisateur.listDesEmailsRecuNonLu(user.getIdUtilisateur()).size());
		List<Module> modules = metierModule.listeModuleParCoordinateur(user.getIdUtilisateur());
		
		ModelChapitre modelChapitre = new ModelChapitre();
		
		Formation f = new Formation();
		f.setNomFormation("Selectionnez une formation");
		List<Formation> lst = metierFormation.selectAll();
		lst.add(0, f);
		model.addAttribute("formations", lst);
		model.addAttribute("formation", new Formation());
		model.addAttribute("modules", modules);
		model.addAttribute("listChapitres", metierChapitre.selectAll());
		model.addAttribute("modelChapitre", modelChapitre);
		
		model.addAttribute("module", new Module());
		
		model.addAttribute("collapse", "collapse");
		model.addAttribute("chapitre", new Chapitres());
		return "/coordinateur/chapitres";
	}
	
	@RequestMapping(value="/chapitre")
	public String detailChapitre(Model model, Long idChapitre) {
		Chapitres chapitre = metierChapitre.findById(idChapitre);
		List<ContenuChapitre> contenu = metierChapitre.listeContenuChapitre(idChapitre);
		for(ContenuChapitre c:contenu) {
			c.setRessources(metierContenuChapitres.listeRessourcesParContenuChapitre(c.getIdContenu()));
		}
		chapitre.setContenuChapitres(contenu);
		return "/coordinateur/detailsChapitre";
	}
	
	@RequestMapping(value="/enregistrerChapitre")
	public String enregistrerChapitre(@Valid Chapitres chapitre, Model model, HttpServletRequest request, BindingResult result) {
		if(result.hasErrors()) {
			return "/coordinateur/chapitres";
		}
		
		if(chapitre.getIdChapitre() == null) {
			chapitre.setDateCreation(new Date());
			metierChapitre.inserer(chapitre);
		}
		Coordinateur user = (Coordinateur)request.getSession().getAttribute("user");
		
		model.addAttribute("chapitre", new Chapitres());
		model.addAttribute("modules", metierModule.listeModuleParCoordinateur(user.getIdUtilisateur()));
		model.addAttribute("module", new Module());
		
		return "redirect:/coordinateur/chapitres/";
	}
	
	@RequestMapping(value = "/listModuleParFormation", method = RequestMethod.GET)
	public @ResponseBody List<Module> listModules(@RequestParam Long idCoordinateur) {
		List<Module> lst = metierModule.listeModuleParCoordinateur(idCoordinateur);
		return lst;
	}

	@RequestMapping(value = "/listChapitreParModule", method = RequestMethod.GET)
	public @ResponseBody List<Chapitres> listChapitres(@RequestParam Long idModule) {
		List<Chapitres> lst = metierModule.listeChapitresParModule(idModule);
		return lst;
	}


}
