package com.pfe.elearning.metier.acteurs.concepteur;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pfe.elearning.dao.acteurs.concepteur.ActeurConcepteurDaoImpl;
import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.Examen;
import com.pfe.elearning.entities.FAQ;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.Questions;
import com.pfe.elearning.entities.Reponses;
import com.pfe.elearning.entities.Ressources;

@Transactional
public class MetierActeurConcepteurImpl implements IMetierActeurConcepteur {

	private ActeurConcepteurDaoImpl dao;

	public void setDao(ActeurConcepteurDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public Module insererModule(Module entity) {
		return dao.insererModule(entity);
	}

	@Override
	public Module modifierModule(Module entity) {
		return dao.modifierModule(entity);
	}

	@Override
	public void supprimerModule(Long id) {
		dao.supprimerModule(id);
	}

	@Override
	public List<Module> selectAllModules() {
		return dao.selectAllModules();
	}

	@Override
	public Module findModuleById(Long id) {
		return dao.findModuleById(id);
	}

	@Override
	public List<Chapitres> listeChapitresParModule(Long idModule) {
		return dao.listeChapitresParModule(idModule);
	}
	
	

	@Override
	public Chapitres insererChapitre(Chapitres entity) {
		return dao.insererChapitre(entity);
	}

	@Override
	public Chapitres modifierChapitre(Chapitres entity) {
		return dao.modifierChapitre(entity);
	}

	@Override
	public void supprimerChapitre(Long id) {
		dao.supprimerChapitre(id);
	}

	@Override
	public List<Chapitres> selectAllChapitres() {
		return dao.selectAllChapitres();
	}

	@Override
	public Chapitres findChapitreById(Long id) {
		return dao.findChapitreById(id);
	}

	@Override
	public List<ContenuChapitre> listeContenuChapitre(Long idChapitre) {
		return dao.listeContenuChapitre(idChapitre);
	}

	@Override
	public List<FAQ> listFaqParChapitre(Long idChapitre) {
		return dao.listFaqParChapitre(idChapitre);
	}

	@Override
	public ContenuChapitre insererContenuChapitre(ContenuChapitre entity) {
		return dao.insererContenuChapitre(entity);
	}

	@Override
	public ContenuChapitre modifierContenuChapitre(ContenuChapitre entity) {
		return dao.modifierContenuChapitre(entity);
	}

	@Override
	public void supprimerContenuChapitre(Long id) {
		dao.supprimerContenuChapitre(id);
	}

	@Override
	public List<ContenuChapitre> selectAllContenuChapitre() {
		return dao.selectAllContenuChapitre();
	}

	@Override
	public ContenuChapitre findContenuChapitreById(Long id) {
		return dao.findContenuChapitreById(id);
	}

	@Override
	public List<Ressources> listeRessourcesParContenuChapitre(Long idContenu) {
		return dao.listeRessourcesParContenuChapitre(idContenu);
	}

	@Override
	public Ressources insererRessource(Ressources entity) {
		return dao.insererRessource(entity);
	}

	@Override
	public Ressources modifierRessource(Ressources entity) {
		return dao.modifierRessource(entity);
	}

	@Override
	public void supprimerRessource(Long id) {
		dao.supprimerRessource(id);
	}

	@Override
	public List<Ressources> selectAllRessources() {
		return dao.selectAllRessources();
	}

	@Override
	public Ressources findRessourceById(Long id) {
		return dao.findRessourceById(id);
	}

	@Override
	public FAQ insererFAQ(FAQ entity) {
		return dao.insererFAQ(entity);
	}

	@Override
	public FAQ modifierFAQ(FAQ entity) {
		return dao.modifierFAQ(entity);
	}

	@Override
	public void supprimerFAQ(Long id) {
		dao.supprimerFAQ(id);
	}

	@Override
	public List<FAQ> selectAllFAQs() {
		return dao.selectAllFAQs();
	}

	@Override
	public FAQ findFAQById(Long id) {
		return dao.findFAQById(id);
	}

	@Override
	public Examen insererExamen(Examen entity) {
		return dao.insererExamen(entity);
	}

	@Override
	public Examen modifierExamen(Examen entity) {
		return dao.modifierExamen(entity);
	}

	@Override
	public void supprimerExamen(Long id) {
		dao.supprimerExamen(id);
	}

	@Override
	public List<Examen> selectAllExamens() {
		return dao.selectAllExamens();
	}

	@Override
	public Examen findExamenById(Long id) {
		return dao.findExamenById(id);
	}

	@Override
	public List<Questions> getListQuestions(Long idExamen) {
		return dao.getListQuestions(idExamen);
	}

	@Override
	public Questions insererQuestion(Questions entity) {
		return dao.insererQuestion(entity);
	}

	@Override
	public Questions modifierQuestion(Questions entity) {
		return dao.modifierQuestion(entity);
	}

	@Override
	public void supprimerQuestion(Long id) {
		dao.supprimerQuestion(id);
	}

	@Override
	public List<Questions> selectAllQuestions() {
		return dao.selectAllQuestions();
	}

	@Override
	public Questions findQuestionById(Long id) {
		return dao.findQuestionById(id);
	}

	@Override
	public List<Reponses> getListReponses(Long idQuestion) {
		return dao.getListReponses(idQuestion);
	}

	@Override
	public Reponses insererReponse(Reponses entity) {
		return dao.insererReponse(entity);
	}

	@Override
	public Reponses modifierReponse(Reponses entity) {
		return dao.modifierReponse(entity);
	}

	@Override
	public void supprimerReponse(Long id) {
		dao.supprimerReponse(id);
	}

	@Override
	public List<Reponses> selectAllReponses() {
		return dao.selectAllReponses();
	}

	@Override
	public Reponses findReponseById(Long id) {
		return dao.findReponseById(id);
	}

	@Override
	public List<Module> listeModuleParCoordinateur(Long idUser) {
		return dao.listeModuleParCoordinateur(idUser);
	}

	@Override
	public List<Module> listeModuleParConcepteur(Long idUser) {
		return dao.listeModuleParConcepteur(idUser);
	}

	

}
