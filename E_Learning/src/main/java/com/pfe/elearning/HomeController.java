package com.pfe.elearning;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.metier.formation.IMetierFormation;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	IMetierFormation metierFormation;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		/**
		 * il faut juste passer 6 formations
		 */
		List<Formation> formations = metierFormation.selectAll();
		model.addAttribute("formations", formations);
		return "/visiteur/index";
	}
}
