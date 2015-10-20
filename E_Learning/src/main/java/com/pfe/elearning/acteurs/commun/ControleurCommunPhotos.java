package com.pfe.elearning.acteurs.commun;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pfe.elearning.entities.Apprenant;
import com.pfe.elearning.entities.Coordinateur;
import com.pfe.elearning.entities.Formation;
import com.pfe.elearning.entities.Module;
import com.pfe.elearning.entities.PieceJointeEmail;
import com.pfe.elearning.metier.apprenant.IMetierApprenant;
import com.pfe.elearning.metier.coordinateur.IMetierCoordinateur;
import com.pfe.elearning.metier.formation.IMetierFormation;
import com.pfe.elearning.metier.module.IMetierModule;
import com.pfe.elearning.metier.pieceJointeEmail.IMetierPieceJointeEmail;

@Controller
@RequestMapping(value = "/photos")
public class ControleurCommunPhotos {

	@Autowired
	IMetierCoordinateur metier;

	@Autowired
	IMetierApprenant metierApp;

	@Autowired
	IMetierModule module;

	@Autowired
	IMetierFormation formation;

	@Autowired
	IMetierPieceJointeEmail pieceJointe;
	

	private byte[] getStaticImage(String fileName, HttpServletRequest request) throws Exception {
		File file = new File(request.getSession().getServletContext().getRealPath("/resources/img/" + fileName));
		BufferedImage img = ImageIO.read(file);
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		ImageIO.write(img, "png", arrayOutputStream);
		arrayOutputStream.flush();
		return arrayOutputStream.toByteArray();
	}


	@RequestMapping(value = "photoUser", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCat(Long idUser, HttpServletRequest request) {
		Coordinateur user = metier.findById(idUser);
		try {
			if (user.getPhoto() == null) {
				return IOUtils.toByteArray(new ByteArrayInputStream(getStaticImage("avatar.png", request)));
			}
			return IOUtils.toByteArray(new ByteArrayInputStream(user.getPhoto()));
		} catch (Exception e) {
			try {
				return photoApp(idUser, request);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	@RequestMapping(value = "photoUserA", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoApp(Long idUser, HttpServletRequest request) throws Exception {
		Apprenant user = metierApp.findById(idUser);
		if (user.getPhoto() == null) {
			return IOUtils.toByteArray(new ByteArrayInputStream(getStaticImage("avatar.png", request)));
		}
		return IOUtils.toByteArray(new ByteArrayInputStream(user.getPhoto()));
	}

	@RequestMapping(value = "photoModule", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoModule(Long idModule, HttpServletRequest request) throws Exception {
		Module mod = module.findById(idModule);
		if (mod.getPhoto() == null) {
			return IOUtils.toByteArray(new ByteArrayInputStream(getStaticImage("modules.jpg", request)));
		}
		return IOUtils.toByteArray(new ByteArrayInputStream(mod.getPhoto()));
	}

	@RequestMapping(value = "photoFormation", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoFormation(Long idFormation, HttpServletRequest request) throws Exception {
		Formation form = formation.findById(idFormation);
		if (form.getPhoto() == null) {
			return IOUtils.toByteArray(new ByteArrayInputStream(getStaticImage("formation.jpg", request)));
		}
		return IOUtils.toByteArray(new ByteArrayInputStream(form.getPhoto()));
	}

	@RequestMapping(value = "photoChapitre", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoChapitre(HttpServletRequest request) throws Exception {
		return IOUtils.toByteArray(new ByteArrayInputStream(getStaticImage("chapter.jpg", request)));
	}

	@RequestMapping(value = "photoPiece", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoPiece(Long idPiece, HttpServletRequest request) throws Exception {
		PieceJointeEmail piece = pieceJointe.findById(idPiece);
		if (piece.getPieceJointe() == null) {
			return IOUtils.toByteArray(new ByteArrayInputStream(getStaticImage("piece.png", request)));
		}
		return IOUtils.toByteArray(new ByteArrayInputStream(piece.getPieceJointe()));
	}
}
