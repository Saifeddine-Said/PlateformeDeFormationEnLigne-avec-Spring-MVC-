package com.pfe.elearning.dao.acteurs.concepteur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pfe.elearning.dao.acteurs.tuteur.ActeurTuteurDaoImpl;
import com.pfe.elearning.dao.chapitres.ChapitresDaoImpl;
import com.pfe.elearning.dao.contenuChapitre.ContenuChapitreDaoImpl;
import com.pfe.elearning.dao.examen.ExamenDaoImpl;
import com.pfe.elearning.dao.faq.FaqDaoImpl;
import com.pfe.elearning.dao.module.ModuleDaoImpl;
import com.pfe.elearning.dao.questions.QuestionsDaoImpl;
import com.pfe.elearning.dao.reponses.ReponsesDaoImpl;
import com.pfe.elearning.dao.ressources.RessourcesDaoImpl;
import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.Examen;
import com.pfe.elearning.entities.FAQ;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.Questions;
import com.pfe.elearning.entities.Reponses;
import com.pfe.elearning.entities.Ressources;
import com.pfe.elearning.metier.module.IMetierModule;

public class ActeurConcepteurDaoImpl extends ActeurTuteurDaoImpl implements
		IActeurConcepteurDao {

	@Autowired
	private IMetierModule daoModule;
	private ChapitresDaoImpl daoChapitres;
	private ContenuChapitreDaoImpl daoContenu;
	private RessourcesDaoImpl daoRessources;
	private ExamenDaoImpl daoExamen;
	private QuestionsDaoImpl daoQuestions;
	private ReponsesDaoImpl daoReponses;
	private FaqDaoImpl daoFaq;

	@Override
	public Module insererModule(Module entity) {
		return daoModule.inserer(entity);
	}

	@Override
	public Module modifierModule(Module entity) {
		return daoModule.modifier(entity);
	}

	@Override
	public void supprimerModule(Long id) {
		daoModule.supprimer(id);
	}

	@Override
	public List<Module> selectAllModules() {
		return daoModule.selectAll();
	}

	@Override
	public Module findModuleById(Long id) {
		return daoModule.findById(id);
	}

	@Override
	public List<Chapitres> listeChapitresParModule(Long idModule) {
		return daoModule.listeChapitresParModule(idModule);
	}

	@Override
	public List<Module> listeModuleParConcepteur(Long idUser) {
		return daoModule.listeModuleParConcepteur(idUser);
	}

	@Override
	public List<Module> listeModuleParCoordinateur(Long idUser) {
		return daoModule.listeModuleParCoordinateur(idUser);
	}

	@Override
	public Chapitres insererChapitre(Chapitres entity) {
		return daoChapitres.inserer(entity);
	}

	@Override
	public Chapitres modifierChapitre(Chapitres entity) {
		return daoChapitres.modifier(entity);
	}

	@Override
	public void supprimerChapitre(Long id) {
		daoChapitres.supprimer(id);
	}

	@Override
	public List<Chapitres> selectAllChapitres() {
		return daoChapitres.selectAll();
	}

	@Override
	public Chapitres findChapitreById(Long id) {
		return daoChapitres.findById(id);
	}

	@Override
	public List<ContenuChapitre> listeContenuChapitre(Long idChapitre) {
		return daoChapitres.listeContenuChapitre(idChapitre);
	}

	@Override
	public List<FAQ> listFaqParChapitre(Long idChapitre) {
		return daoChapitres.listFaqParChapitre(idChapitre);
	}

	@Override
	public ContenuChapitre insererContenuChapitre(ContenuChapitre entity) {
		return daoContenu.inserer(entity);
	}

	@Override
	public ContenuChapitre modifierContenuChapitre(ContenuChapitre entity) {
		return daoContenu.modifier(entity);
	}

	@Override
	public void supprimerContenuChapitre(Long id) {
		daoContenu.supprimer(id);
	}

	@Override
	public List<ContenuChapitre> selectAllContenuChapitre() {
		return daoContenu.selectAll();
	}

	@Override
	public ContenuChapitre findContenuChapitreById(Long id) {
		return daoContenu.findById(id);
	}

	@Override
	public List<Ressources> listeRessourcesParContenuChapitre(Long idContenu) {
		return daoContenu.listeRessourcesParContenuChapitre(idContenu);
	}

	@Override
	public Ressources insererRessource(Ressources entity) {
		return daoRessources.inserer(entity);
	}

	@Override
	public Ressources modifierRessource(Ressources entity) {
		return daoRessources.modifier(entity);
	}

	@Override
	public void supprimerRessource(Long id) {
		daoRessources.supprimer(id);
	}

	@Override
	public List<Ressources> selectAllRessources() {
		return daoRessources.selectAll();
	}

	@Override
	public Ressources findRessourceById(Long id) {
		return daoRessources.findById(id);
	}

	@Override
	public Examen insererExamen(Examen entity) {
		return daoExamen.inserer(entity);
	}

	@Override
	public Examen modifierExamen(Examen entity) {
		return daoExamen.modifier(entity);
	}

	@Override
	public void supprimerExamen(Long id) {
		daoExamen.supprimer(id);
	}

	@Override
	public List<Examen> selectAllExamens() {
		return daoExamen.selectAll();
	}

	@Override
	public Examen findExamenById(Long id) {
		return daoExamen.findById(id);
	}

	@Override
	public List<Questions> getListQuestions(Long idExamen) {
		return daoExamen.getListQuestions(idExamen);
	}

	@Override
	public Questions insererQuestion(Questions entity) {
		return daoQuestions.inserer(entity);
	}

	@Override
	public Questions modifierQuestion(Questions entity) {
		return daoQuestions.modifier(entity);
	}

	@Override
	public void supprimerQuestion(Long id) {
		daoQuestions.supprimer(id);
	}

	@Override
	public List<Questions> selectAllQuestions() {
		return daoQuestions.selectAll();
	}

	@Override
	public Questions findQuestionById(Long id) {
		return daoQuestions.findById(id);
	}

	@Override
	public List<Reponses> getListReponses(Long idQuestion) {
		return daoQuestions.getListReponses(idQuestion);
	}

	@Override
	public Reponses insererReponse(Reponses entity) {
		return daoReponses.inserer(entity);
	}

	@Override
	public Reponses modifierReponse(Reponses entity) {
		return daoReponses.modifier(entity);
	}

	@Override
	public void supprimerReponse(Long id) {
		daoReponses.supprimer(id);
	}

	@Override
	public List<Reponses> selectAllReponses() {
		return daoReponses.selectAll();
	}

	@Override
	public Reponses findReponseById(Long id) {
		return daoReponses.findById(id);
	}

	@Override
	public FAQ insererFAQ(FAQ entity) {
		return daoFaq.inserer(entity);
	}

	@Override
	public FAQ modifierFAQ(FAQ entity) {
		return daoFaq.modifier(entity);
	}

	@Override
	public void supprimerFAQ(Long id) {
		daoFaq.supprimer(id);
	}

	@Override
	public List<FAQ> selectAllFAQs() {
		return daoFaq.selectAll();
	}

	@Override
	public FAQ findFAQById(Long id) {
		return daoFaq.findById(id);
	}

	public void setDaoModule(IMetierModule daoModule) {
		this.daoModule = daoModule;
	}

	public void setDaoChapitres(ChapitresDaoImpl daoChapitres) {
		this.daoChapitres = daoChapitres;
	}

	public void setDaoContenu(ContenuChapitreDaoImpl daoContenu) {
		this.daoContenu = daoContenu;
	}

	public void setDaoRessources(RessourcesDaoImpl daoRessources) {
		this.daoRessources = daoRessources;
	}

	public void setDaoExamen(ExamenDaoImpl daoExamen) {
		this.daoExamen = daoExamen;
	}

	public void setDaoQuestions(QuestionsDaoImpl daoQuestions) {
		this.daoQuestions = daoQuestions;
	}

	public void setDaoReponses(ReponsesDaoImpl daoReponses) {
		this.daoReponses = daoReponses;
	}

	public void setDaoFaq(FaqDaoImpl daoFaq) {
		this.daoFaq = daoFaq;
	}

}
