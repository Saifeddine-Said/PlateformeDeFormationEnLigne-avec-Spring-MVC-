package com.pfe.elearning.acteurs.internaute.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.metier.acteurs.internaute.IMetierActeurInternaute;

@Controller
@RequestMapping(value = "/userLogin")
public class LoginController {

	@Autowired
	IMetierActeurInternaute metier;

	@RequestMapping(value = "/")
	public String login() {
		return "/visiteur/login";
	}

	@RequestMapping(value = "/checkUser")
	public String checkLogin(HttpServletRequest request, Model model, HttpSession session) {
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		Utilisateur user = metier.checkUserLogin(mail, password);
		if (user != null) {
			if (user.getType().equals("COOR")) {
				session.setAttribute("user", user);
				return "redirect:/coordinateur/";
			}
			if (user.getType().equals("CONC")) {
				session.setAttribute("user", user);
				return "redirect:/concepteur/";
			}
			if (user.getType().equals("TUTE")) {
				session.setAttribute("user", user);
				return "redirect:/tuteur/";
			}
			if (user.getType().equals("APPR")) {
				session.setAttribute("user", user);
				return "redirect:/apprenant/";
			}
		}
		model.addAttribute("valid", false);
		return "/visiteur/login";
	}

}
