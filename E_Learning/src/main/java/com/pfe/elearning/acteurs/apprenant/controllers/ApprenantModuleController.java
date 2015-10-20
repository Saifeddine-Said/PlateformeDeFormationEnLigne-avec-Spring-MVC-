package com.pfe.elearning.acteurs.apprenant.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pfe.elearning.entities.Module;
import com.pfe.elearning.metier.apprenant.IMetierApprenant;
import com.pfe.elearning.metier.formation.IMetierFormation;
import com.pfe.elearning.metier.module.IMetierModule;

@Controller
@RequestMapping(value="/apprenant/modules")
public class ApprenantModuleController {
	
	@Autowired
	IMetierModule metierModule;
	
	@Autowired
	IMetierApprenant metierApprenant;
	
	@Autowired
	IMetierFormation metierFormation;
	
	@RequestMapping(value="/chapitres")
	public String chapitresParModules(Long id,Long app,Model model)
	{
		model.addAttribute("listChapiters",metierModule.listeChapitresParModule(id));
		return"/apprenant/chapiters";
	}
	
//	@RequestMapping(value="/modules/")
//	public String listModulesParUtilisateur(Long idUtilisateur)
//	{
//		return "";
//	}
	
	@RequestMapping(value="photoModule", produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoModule(Long idModule) throws IOException {
		Module module = metierModule.findById(idModule);
		return IOUtils.toByteArray(new ByteArrayInputStream(module.getPhoto()));
	}

}
