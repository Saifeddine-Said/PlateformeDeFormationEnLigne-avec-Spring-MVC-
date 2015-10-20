package com.pfe.elearning.acteurs.coordinateur.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.Examen;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.Questions;
import com.pfe.elearning.entities.Reponses;
import com.pfe.elearning.entities.Utilisateur;
import com.pfe.elearning.metier.chapitres.IMetierChapitres;
import com.pfe.elearning.metier.examen.IMetierExamen;
import com.pfe.elearning.metier.formation.IMetierFormation;
import com.pfe.elearning.metier.module.IMetierModule;
import com.pfe.elearning.metier.questions.IMetierQuestions;
import com.pfe.elearning.metier.reponses.IMetierReponses;
import com.pfe.elearning.metier.utilisateur.IMetierUtilisateur;
import com.pfe.elearning.models.ExamenModel;

@Controller
@RequestMapping(value = "/coordinateur/examens")
public class CoordinateurExamenController {

	@Autowired
	IMetierExamen metierExamen;

	@Autowired
	IMetierFormation metierFormation;

	@Autowired
	IMetierModule metierModule;

	@Autowired
	IMetierChapitres metierChapitre;

	@Autowired
	IMetierQuestions metierQuestion;

	@Autowired
	IMetierReponses metierReponse;

	@Autowired
	IMetierUtilisateur metierUtilisateur;

	private ExamenModel examen = new ExamenModel();

	@RequestMapping(value = "/")
	public String indexExamen(Model model, HttpServletRequest request) {

		Utilisateur user = (Utilisateur) request.getSession().getAttribute("user");
		model.addAttribute("nbrMails", metierUtilisateur.listDesEmailsRecuNonLu(user.getIdUtilisateur()).size());

		model.addAttribute("activeTab", 1);

		model.addAttribute("examen", new ExamenModel());

		List<Formation> lst = metierFormation.selectAll();
		Formation f = new Formation();
		f.setNomFormation("Selectionner une formation");
		lst.add(0, f);
		model.addAttribute("listFormations", lst);
		model.addAttribute("formation", new Formation());

		model.addAttribute("listModules", metierModule.selectAll());
		model.addAttribute("module", new Module());

		List<Chapitres> chaps = metierChapitre.selectAll();
		Chapitres c = new Chapitres();
		c.setTitreChapitre("Selectionner un chapitre");
		chaps.add(0, c);
		model.addAttribute("listChapitres", chaps);
		model.addAttribute("chapitre", new Chapitres());
		return "/coordinateur/examens";
	}

	@RequestMapping(value = "/etapes")
	public String etape1(@RequestParam int numEtape, Model model, @ModelAttribute ExamenModel modelexamen, HttpServletRequest request) {
		Examen ex = null;
		switch (numEtape) {
		case 1: {
			examen.setTypeExamen(modelexamen.getTypeExamen());
			examen.getFormation().setIdFormation(modelexamen.getFormation().getIdFormation());
			examen.getModule().setIdModule(modelexamen.getModule().getIdModule());
			examen.getChapitres().setIdChapitre(modelexamen.getChapitres().getIdChapitre());
			break;
		}
		case 2: {
			examen.getExamen().setTitreExamen(modelexamen.getExamen().getTitreExamen());
			examen.getExamen().setDescriptionExamen(modelexamen.getExamen().getDescriptionExamen());
			examen.getExamen().setScoreMini(modelexamen.getExamen().getScoreMini());
			break;
		}
		case 3: {
			examen.setTypeQuestion(modelexamen.getTypeQuestion());
			examen.getExamen().setModule(examen.getModule());
			examen.getExamen().setChapitres(examen.getChapitres());
			examen.getExamen().setTypeExamen(examen.getTypeExamen());
			examen.getQuestions().setTitreQuestion(modelexamen.getQuestions().getTitreQuestion());
			examen.getQuestions().setTypeQuestion(modelexamen.getQuestions().getTypeQuestion());
			examen.getQuestions().setNumQuestion("1");

			if (examen.getExamen().getIdExamen() == null) {
				ex = new Examen();
				ex.setTypeExamen(examen.getTypeExamen());
				ex.setTitreExamen(examen.getExamen().getTitreExamen());
				ex.setDescriptionExamen(examen.getExamen().getDescriptionExamen());
				ex.setScoreMini(examen.getExamen().getScoreMini());
				if (examen.getChapitres().getIdChapitre() == null) {
					Module m = metierModule.findById(examen.getModule().getIdModule());
					System.out.println("module                               " + m.getIdModule());
					ex.setModule(m);
				} else {
					Chapitres c = metierChapitre.findById(examen.getChapitres().getIdChapitre());
					ex.setChapitres(c);
				}
				ex = metierExamen.inserer(ex);
				examen.getExamen().setIdExamen(ex.getIdExamen());
			} else {
				ex = metierExamen.findById(examen.getExamen().getIdExamen());
			}

			Questions questions = new Questions();
			questions.setNumQuestion(request.getParameter(""));
			questions.setTitreQuestion(modelexamen.getQuestions().getTitreQuestion());
			questions.setTypeQuestion(examen.getTypeQuestion());
			questions.setExamen(ex);

			metierQuestion.inserer(questions);

			int nbrParams = Integer.parseInt(request.getParameter("nbrReps"));
			for (int i = 0; i < nbrParams; i++) {
				if (!request.getParameter("reponse" + (i + 1)).isEmpty() && !request.getParameter("feedBack" + (i + 1)).isEmpty() && !request.getParameter("poids" + (i + 1)).isEmpty()) {
					Reponses reponses = new Reponses();
					reponses.setReponse(request.getParameter("reponse" + (i + 1)));
					reponses.setFeedBack(request.getParameter("feedBack" + (i + 1)));
					reponses.setPoids(Double.parseDouble(request.getParameter("poids" + (i + 1))));
					if (request.getParameter("reponseCorrecte" + (i + 1)) != null) {
						reponses.setReponseCorrecte(request.getParameter("reponseCorrecte" + (i + 1)).equals("on") ? true : false);
					}
					reponses.setQuestions(questions);
					metierReponse.inserer(reponses);
				}
			}
			break;
		}
		}
		model.addAttribute("examen", examen);
		model.addAttribute("activeTab", 2);
		return "/coordinateur/examens";
	}

//	@RequestMapping(value = "/etape2")
//	public String etape2(Model model, ExamenModel modelexamen) {
//		model.addAttribute("examen", examen);
//		model.addAttribute("activeTab", 3);
//
//		examen.getExamen().setTitreExamen(modelexamen.getExamen().getTitreExamen());
//		examen.getExamen().setDescriptionExamen(modelexamen.getExamen().getDescriptionExamen());
//		examen.getExamen().setScoreMini(modelexamen.getExamen().getScoreMini());
//
//		List<Formation> lst = metierFormation.selectAll();
//		Formation f = new Formation();
//		f.setNomFormation("Selectionner une formation");
//		lst.add(0, f);
//		model.addAttribute("listFormations", lst);
//		model.addAttribute("formation", new Formation());
//
//		model.addAttribute("listModules", metierModule.selectAll());
//		model.addAttribute("module", new Module());
//
//		List<Chapitres> chaps = metierChapitre.selectAll();
//		Chapitres c = new Chapitres();
//		c.setTitreChapitre("Selectionner un chapitre");
//		chaps.add(0, c);
//		model.addAttribute("listChapitres", chaps);
//		model.addAttribute("chapitre", new Chapitres());
//
//		return "/coordinateur/examens";
//	}
//
//	@RequestMapping(value = "/saveExam")
//	public String enregistrer(Model model, ExamenModel modelExamen) {
//
//		System.out.println("heeeeeeeeeeeeeeeeeeeeeeeeeeeeeeerrreeeeeeeee");
//
//		Examen exam = examen.getExamen();
//		exam.setTypeExamen(examen.getTypeExamen());
//		if (examen.getTypeExamen().equals("EF")) {
//			System.out.println("module   :    " + examen.getModule().getIdModule());
//			// examen.getModule().setIdModule(examen.getModule().getIdModule());
//		} else {
//			// exam.getChapitres().setIdChapitre(examen.getChapitres().getIdChapitre());
//		}
//
//		metierExamen.inserer(examen.getExamen());
//
//		Questions question = modelExamen.getQuestions();
//		question.setExamen(examen.getExamen());
//		question.setTypeQuestion(modelExamen.getTypeQuestion());
//
//		metierQuestion.inserer(question);
//
//		for (Reponses r : examen.getReponses()) {
//			if (r.getReponse().length() > 0) {
//				r.setQuestions(question);
//				System.out.println("reponse  :   " + r.getReponse());
//				metierReponse.inserer(r);
//			}
//		}
//
//		return "/coordinateur/examens";
//	}

	@RequestMapping(value = "/listModuleParFormation", method = RequestMethod.GET)
	public @ResponseBody List<Module> listModules(@RequestParam Long idFormation) {
		List<Module> lst = metierFormation.getListModules(idFormation);
		return lst;
	}

	@RequestMapping(value = "/listChapitreParModule", method = RequestMethod.GET)
	public @ResponseBody List<Chapitres> listChapitres(@RequestParam Long idModule) {
		List<Chapitres> lst = metierModule.listeChapitresParModule(idModule);
		return lst;
	}

}
