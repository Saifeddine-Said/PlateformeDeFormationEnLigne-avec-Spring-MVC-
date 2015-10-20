package com.pfe.elearning.dao.acteurs.concepteur;

import java.util.List;

import com.pfe.elearning.dao.acteurs.tuteur.IActeurTuteurDao;
import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.ContenuChapitre;
import com.pfe.elearning.entities.Examen;
import com.pfe.elearning.entities.FAQ;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.Questions;
import com.pfe.elearning.entities.Reponses;
import com.pfe.elearning.entities.Ressources;

public interface IActeurConcepteurDao extends IActeurTuteurDao {

	/**
	 * Gestion des modules
	 */

	public Module insererModule(Module entity);

	public Module modifierModule(Module entity);

	public void supprimerModule(Long id);

	public List<Module> selectAllModules();

	public Module findModuleById(Long id);

	public List<Chapitres> listeChapitresParModule(Long idModule);

	public List<Module> listeModuleParConcepteur(Long idUser);

	public List<Module> listeModuleParCoordinateur(Long idUser);

	/**
	 * Gestion des chapitres
	 */

	public Chapitres insererChapitre(Chapitres entity);

	public Chapitres modifierChapitre(Chapitres entity);

	public void supprimerChapitre(Long id);

	public List<Chapitres> selectAllChapitres();

	public Chapitres findChapitreById(Long id);

	public List<ContenuChapitre> listeContenuChapitre(Long idChapitre);

	public List<FAQ> listFaqParChapitre(Long idChapitre);

	/**
	 * Gestion des contenues chapitres
	 */

	public ContenuChapitre insererContenuChapitre(ContenuChapitre entity);

	public ContenuChapitre modifierContenuChapitre(ContenuChapitre entity);

	public void supprimerContenuChapitre(Long id);

	public List<ContenuChapitre> selectAllContenuChapitre();

	public ContenuChapitre findContenuChapitreById(Long id);

	public List<Ressources> listeRessourcesParContenuChapitre(Long idContenu);

	/**
	 * Gestion des ressources des contenues chapitres
	 */

	public Ressources insererRessource(Ressources entity);

	public Ressources modifierRessource(Ressources entity);

	public void supprimerRessource(Long id);

	public List<Ressources> selectAllRessources();

	public Ressources findRessourceById(Long id);

	/**
	 * Gesion des FAQ
	 */

	public FAQ insererFAQ(FAQ entity);

	public FAQ modifierFAQ(FAQ entity);

	public void supprimerFAQ(Long id);

	public List<FAQ> selectAllFAQs();

	public FAQ findFAQById(Long id);

	/**
	 * Gestion des examens
	 */

	public Examen insererExamen(Examen entity);

	public Examen modifierExamen(Examen entity);

	public void supprimerExamen(Long id);

	public List<Examen> selectAllExamens();

	public Examen findExamenById(Long id);

	public List<Questions> getListQuestions(Long idExamen);

	/**
	 * Gestion des questions des examens
	 */

	public Questions insererQuestion(Questions entity);

	public Questions modifierQuestion(Questions entity);

	public void supprimerQuestion(Long id);

	public List<Questions> selectAllQuestions();

	public Questions findQuestionById(Long id);

	public List<Reponses> getListReponses(Long idQuestion);

	/**
	 * Gestion des reponses des examens
	 */

	public Reponses insererReponse(Reponses entity);

	public Reponses modifierReponse(Reponses entity);

	public void supprimerReponse(Long id);

	public List<Reponses> selectAllReponses();

	public Reponses findReponseById(Long id);
}
