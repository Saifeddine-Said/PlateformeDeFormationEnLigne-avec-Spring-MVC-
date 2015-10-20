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
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.metier.formation.IMetierFormation;
import com.pfe.elearning.metier.module.IMetierModule;
import com.pfe.elearning.metier.utilisateur.IMetierUtilisateur;

@Controller
@RequestMapping(value = "/coordinateur/modules/ajouter")
@SessionAttributes("editedMod")
public class CoordinateurAjouterModuleController {

	@Autowired
	IMetierModule metierModule;
	
	@Autowired
	IMetierFormation metierFormation;
	
	@Autowired
	IMetierUtilisateur metierUtilisateur;

	@RequestMapping(value = "/")
	public String indexAjouterModule(Model model, HttpServletRequest request) {
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		model.addAttribute("nbrMails", metierUtilisateur.listDesEmailsRecuNonLu(user.getIdUtilisateur()).size());
		model.addAttribute("module", new Module());
		model.addAttribute("formations", metierFormation.selectAll());
		model.addAttribute("formation", new Formation());
		return "/coordinateur/ajouterModule";
	}

	@RequestMapping(value = "/enregistrerModule")
	public String enregistrerFormation(HttpServletRequest request, @Valid Module module, BindingResult binding, MultipartFile file, Model model) throws IOException {
		Coordinateur coor = (Coordinateur) request.getSession().getAttribute("user");

		if (binding.hasErrors()) {
			model.addAttribute("module", new Module());
			model.addAttribute("formations", metierFormation.selectAll());
			model.addAttribute("formation", new Formation());
			return "/coordinateur/ajouterModule";
		}

		if (!file.isEmpty()) {
			// BufferedImage bi = ImageIO.read(file.getInputStream());
			module.setPhoto(file.getBytes());
		}

		if (module.getIdModule() != null) {
			if (model.asMap().get("editedMod") != null) {
				if (file.isEmpty()) {
					Module m = (Module) model.asMap().get("editedMod");
					if (m.getPhoto() != null)
						module.setPhoto(m.getPhoto());
				}
			}
			module.setCoordinateur(coor);
			module.setDateDerinerModification(new Date());
			metierModule.modifier(module);

		} else {
			module.setDateCreation(new Date());
			module.setCoordinateur(coor);
			
			Formation f = module.getFormation();
			System.out.println("fffffffffffffffffffffffffffffffffffffffffffffffffffff                 "+f.getNomFormation());

			metierModule.inserer(module);

		}

		List<Module> mod = metierModule.selectAll();

		model.addAttribute("listModule", mod);
		model.addAttribute("module", new Module());

		return "redirect:/coordinateur/modules/";
	}

	@RequestMapping(value = "/modifierModule")
	public String modifierFormation(Model model, Long idModule) {
		Module module = metierModule.findById(idModule);
		model.addAttribute("editedMod", module);
		model.addAttribute("module", module);
		model.addAttribute("formations", metierFormation.selectAll());
		model.addAttribute("formation", new Formation());
		return "/coordinateur/ajouterModule";
	}

}
