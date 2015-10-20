package com.pfe.elearning.acteurs.apprenant.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pfe.elearning.entities.Apprenant;
import com.pfe.elearning.entities.Email;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.metier.email.IMetierEmail;
import com.pfe.elearning.metier.utilisateur.IMetierUtilisateur;

@Controller
@RequestMapping(value="/apprenant/email")
public class ApprenantEmailController {
	@Autowired
	IMetierUtilisateur metierUtilisateur;

	@Autowired
	IMetierEmail metierEmail;

	@RequestMapping(value = "/")
	public String indexMail(Model model, HttpServletRequest request) {
		Apprenant user = (Apprenant) request.getSession().getAttribute("user");
		model.addAttribute("nbrMails", metierUtilisateur.listDesEmailsRecuNonLu(user.getIdUtilisateur()).size());
		model.addAttribute("listEmail", metierUtilisateur.listDesEmailsRecus(user.getIdUtilisateur()));
		model.addAttribute("listEmailNonLu", metierUtilisateur.listDesEmailsRecuNonLu(user.getIdUtilisateur()));
		model.addAttribute("listEmailEnv", metierUtilisateur.listDesEmailsEnvoyes(user.getIdUtilisateur()));
		model.addAttribute("listUsers", metierUtilisateur.selectAll());
		model.addAttribute("br", true);
		model.addAttribute("sendmail", new Email());
		return "/apprenant/email";
	}

	@RequestMapping(value = "/send")
	public String sendMail(Model model, HttpServletRequest request) {
		Apprenant user = (Apprenant) request.getSession().getAttribute("user");
		model.addAttribute("listEmail", metierUtilisateur.listDesEmailsEnvoyes(user.getIdUtilisateur()));
		model.addAttribute("listEmailNonLu", metierUtilisateur.listDesEmailsRecuNonLu(user.getIdUtilisateur()));
		model.addAttribute("listEmailEnv", metierUtilisateur.listDesEmailsEnvoyes(user.getIdUtilisateur()));
		model.addAttribute("listUsers", metierUtilisateur.selectAll());
		model.addAttribute("br", false);
		model.addAttribute("sendmail", new Email());

		return "/apprenant/email";
	}

	@RequestMapping(value = "/detailMail")
	public String detailMail(Model model, HttpServletRequest request, Long idEmail, boolean lu) {
		Apprenant user = (Apprenant) request.getSession().getAttribute("user");
		Email mail = metierEmail.findById(idEmail);
		if (lu) {
			mail.setLu(true);
			metierEmail.modifier(mail);
		}
		model.addAttribute("email", mail);
		model.addAttribute("listEmail", metierUtilisateur.listDesEmailsRecus(user.getIdUtilisateur()));
		model.addAttribute("listEmailNonLu", metierUtilisateur.listDesEmailsRecuNonLu(user.getIdUtilisateur()));
		model.addAttribute("listEmailEnv", metierUtilisateur.listDesEmailsEnvoyes(user.getIdUtilisateur()));
		model.addAttribute("pieceJointe", metierEmail.listePiecejointeParEmail(idEmail));
		model.addAttribute("listUsers", metierUtilisateur.selectAll());
		model.addAttribute("br", false);
		model.addAttribute("sendmail", new Email());
		return "/apprenant/detailMail";
	}

	@RequestMapping(value = "/envoyerEmail")
	public String envoyerMail(Email sendmail, Model model, HttpServletRequest request, BindingResult result) {
		if (result.hasErrors())
			return "/apprenant/email";
		Apprenant expediteur = (Apprenant) request.getSession().getAttribute("user");
		sendmail.setUtilisateurExpeditreur(expediteur);

		String m = request.getParameter("mailAdr");

		Utilisateur destinataire = metierUtilisateur.getUtilisateurParEmail(m);
		
		sendmail.setUtilisateurDestinataire(destinataire);
		sendmail.setDateEnvoi(new Date());
		sendmail.setLu(false);
		metierEmail.inserer(sendmail);
		model.addAttribute("listEmail", metierUtilisateur.listDesEmailsRecus(expediteur.getIdUtilisateur()));
		model.addAttribute("listEmailNonLu", metierUtilisateur.listDesEmailsRecuNonLu(expediteur.getIdUtilisateur()));
		model.addAttribute("listEmailEnv", metierUtilisateur.listDesEmailsEnvoyes(expediteur.getIdUtilisateur()));
		model.addAttribute("listUsers", metierUtilisateur.selectAll());
		model.addAttribute("br", true);
		model.addAttribute("sendmail", new Email());
		return "redirect:/apprenant/email/";
	}

	@RequestMapping(value = "/supprimerMails")
	public String supprimerEmails(String[] mailIds) {
		for (int i = 0; i < mailIds.length; i++) {
			Long id = Long.parseLong(mailIds[i]);
			metierEmail.supprimer(id);
		}
		return "/apprenant/email";
	}

	@RequestMapping(value = "/supprimerMail")
	public String supprimerEmails(@RequestParam(value="idMail") String idMail) {
		Long id = Long.parseLong(idMail);
		metierEmail.supprimer(id);
		return "redirect:/apprenant/email/";
	}
}
