package com.pfe.elearning.models;

import java.util.ArrayList;

import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.Examen;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.Questions;
import com.pfe.elearning.entities.Reponses;

public class ExamenModel {

	private String typeExamen;
	private String typeQuestion;

	private Examen examen;
	private Questions questions;
	private ArrayList<Reponses> reponses;// = new ArrayList<Reponses>();

	private Formation formation;

	private Module module;

	private Chapitres chapitres;

	public ExamenModel() {
		examen = new Examen();
		questions = new Questions();
		formation = new Formation();
		module = new Module();
		chapitres = new Chapitres();
		reponses = new ArrayList<Reponses>();
		reponses.add(new Reponses());
		reponses.add(new Reponses());
		reponses.add(new Reponses());
		reponses.add(new Reponses());
		reponses.add(new Reponses());
		reponses.add(new Reponses());
		reponses.add(new Reponses());
	}

	public ExamenModel(int x) {
		examen = new Examen();
		questions = new Questions();
		reponses = new ArrayList<Reponses>();
		formation = new Formation();
		module = new Module();
		chapitres = new Chapitres();
	}

	public String getTypeQuestion() {
		return typeQuestion;
	}

	public void setTypeQuestion(String typeQuestion) {
		this.typeQuestion = typeQuestion;
	}

	public String getTypeExamen() {
		return typeExamen;
	}

	public void setTypeExamen(String typeExamen) {
		this.typeExamen = typeExamen;
	}

	public Chapitres getChapitres() {
		return chapitres;
	}

	public void setChapitres(Chapitres chapitres) {
		this.chapitres = chapitres;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public ArrayList<Reponses> getReponses() {
		return reponses;
	}

	public void setReponses(ArrayList<Reponses> reponses) {
		this.reponses = reponses;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

}
