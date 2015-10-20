package com.pfe.elearning.acteurs.apprenant.controllers;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pfe.elearning.entities.Examen;
import com.pfe.elearning.entities.Questions;
import com.pfe.elearning.metier.examen.IMetierExamen;

@Controller
@RequestMapping(value="/apprenant/examen")
public class AprenantExamenController {
	
	@Autowired
	IMetierExamen metierExamen;
	
	@RequestMapping(value="/")
	public String index(Model model,HttpServletRequest request)
	{
		String idModule=request.getParameter("idMod");
		String idChapitre=request.getParameter("idChap");
		Examen examen=metierExamen.getExamenParModuleEtChapitre(Long.parseLong(idModule),Long.parseLong(idChapitre));
		List<Questions>ListQuestion=metierExamen.getListQuestions(examen.getIdExamen());
		
		for(Questions q:examen.getQuestions()){
			
			System.out.println(q.getTitreQuestion());
		}
		
		/**
		long seed = System.nanoTime();
		Collections.shuffle(listexam, new Random(seed));
		 **/
		Collections.shuffle(ListQuestion);
		model.addAttribute("examen",examen);
		model.addAttribute("ListQuestion", ListQuestion);
		return"/apprenant/examen";
	}

}
