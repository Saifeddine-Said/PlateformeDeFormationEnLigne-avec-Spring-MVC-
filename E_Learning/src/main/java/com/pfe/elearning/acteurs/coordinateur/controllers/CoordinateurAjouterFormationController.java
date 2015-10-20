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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.pfe.elearning.entities.Coordinateur;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.metier.formation.IMetierFormation;
import com.pfe.elearning.metier.utilisateur.IMetierUtilisateur;

@Controller
@RequestMapping(value = "/coordinateur/formations/ajouter")
@SessionAttributes("editedForm")
public class CoordinateurAjouterFormationController {

	@Autowired
	IMetierFormation metierFormation;
	
	@Autowired
	IMetierUtilisateur metierUtilisateur;

	@RequestMapping(value = "/")
	public String indexAjouterFormation(Model model, HttpServletRequest request) {
		model.addAttribute("formation", new Formation());
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		model.addAttribute("nbrMails", metierUtilisateur.listDesEmailsRecuNonLu(user.getIdUtilisateur()).size());
		return "/coordinateur/ajouterFormation";
	}

	@RequestMapping(value = "/enregistrerFormation")
	public String enregistrerFormation(HttpServletRequest request, @Valid Formation formation, BindingResult binding, MultipartFile file, Model model) throws IOException {
		Coordinateur coor = (Coordinateur) request.getSession().getAttribute("user");
		
		if (binding.hasErrors()) {
			model.addAttribute("formation", new Formation());
			return "/coordinateur/ajouterFormation";
		}

		if (!file.isEmpty()) {
			// BufferedImage bi = ImageIO.read(file.getInputStream());
			formation.setPhoto(file.getBytes());
		}
		
		if(formation.getIdFormation() !=null) {
			if(model.asMap().get("editedForm") != null) {
				if(file.isEmpty()) {
					Formation f = (Formation) model.asMap().get("editedForm");
					if(f.getPhoto() != null)
						formation.setPhoto(f.getPhoto());
				}
			}
			formation.setCoordinateur(coor);
			formation.setDateDerinerModification(new Date());
			metierFormation.modifier(formation);
			
			
		}else {
			formation.setDateCreation(new Date());
			formation.setCoordinateur(coor);

			metierFormation.inserer(formation);

		}
		
		
		List<Formation> form = metierFormation.selectAll();
		
		for (Formation f : form) {
			f.setModules(metierFormation.getListModules(f.getIdFormation()));
		}

		model.addAttribute("listFormation", form);
		model.addAttribute("formation", new Formation());

		return "redirect:/coordinateur/formations/";
	}
	
	@RequestMapping(value="/modifierFormation")
	public String modifierFormation(Model model, Long idFormation) {
		Formation formation = metierFormation.findById(idFormation);
		model.addAttribute("editedForm", formation);
		model.addAttribute("formation", formation);
		return "/coordinateur/ajouterFormation";
	}
}
