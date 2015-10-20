package com.pfe.elearning.models;

import com.pfe.elearning.entities.Chapitres;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;

public class ModelChapitre {
	
	private Formation formation;
	private Module module;
	
	public ModelChapitre() {
		// TODO Auto-generated constructor stub
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	
	
	

}
