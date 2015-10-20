package com.pfe.elearning.acteurs.apprenant.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.pfe.elearning.entities.Apprenant;
import com.pfe.elearning.metier.apprenant.IMetierApprenant;
import com.pfe.elearning.metier.evenement.IMetierEvenement;
import com.pfe.elearning.metier.module.IMetierModule;

@Controller
@RequestMapping(value = "/apprenant/profile")
@SessionAttributes("editedUser")
public class ApprenantProfileController {

	@Autowired
	IMetierApprenant metierApprenant;

	@Autowired
	IMetierModule metierModule;

	@Autowired
	IMetierEvenement meiterEvenement;

	@RequestMapping(value = "/")
	public String profile(Model model, HttpServletRequest request) {
		Apprenant user = (Apprenant) request.getSession().getAttribute("user");
		model.addAttribute("utilisateur", user);
		model.addAttribute("editedUser", user);
		return "apprenant/profile";
	}

	@RequestMapping(value = "/saveEtape1")
	public String modifierProfile(Model model, HttpServletRequest request, MultipartFile file, Apprenant utilisateur, BindingResult result) throws IOException {
		Apprenant user = metierApprenant.findById(utilisateur.getIdUtilisateur());
		if (result.hasErrors()) {
			System.out.println(result.getFieldError().getField());
			model.addAttribute("utilisateur", utilisateur);
			return "redirect:/apprenant/profile/";
		}

		if (file != null) {
			if (!file.isEmpty()) {
				utilisateur.setPhoto(file.getBytes());
			}
		}
		if (utilisateur.getIdUtilisateur() != null) {
			if (model.asMap().get("editedUser") != null) {
				if (file != null) {
					if (file.isEmpty()) {
						Apprenant u = (Apprenant) model.asMap().get("editedUser");
						utilisateur.setPhoto(u.getPhoto());
					}
				}
			}
			utilisateur.setMotDePasse(user.getMotDePasse());
			utilisateur.setEmail(user.getEmail());
			utilisateur.setSexe(user.getSexe());
			utilisateur.setDateInscription(user.getDateInscription());
			utilisateur.setType(user.getType());
			utilisateur.setSexe(user.getSexe());
			utilisateur.setEtat(user.isEtat());
			utilisateur.setValide(user.isValide());
			utilisateur.setVille(user.getVille());
			utilisateur.setPays(user.getPays());
			metierApprenant.modifier(utilisateur);
		}
		model.addAttribute("utilisateur", utilisateur);
		return "redirect:/apprenant/profile/";
	}
}
