package com.pfe.elearning.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String nom;
	private String prenom;
	private String email;
	private Date dateNaissance;
	private String pays;
	private String ville;
	private Date dateInscription;
	@Lob
	private byte[] photo;
	private String motDePasse;
	private boolean valide;
	private boolean etat;
	@Column(name = "apropos")
	@Type(type = "text")
	private String apropos;
	private String sexe;
	private String type;

	@OneToMany(mappedBy = "proprietaire")
	private List<EspaceUtilisateur> espaceUtilisateur;

	/**
	 * La liste des participants dans un evenement
	 */
	@ManyToMany
	@JoinTable(name = "EvenementUtilisateur", joinColumns = @JoinColumn(name = "idUtilisateur"), inverseJoinColumns = @JoinColumn(name = "idEvenement"))
	private Collection<Evenement> participationEvenement;

	/**
	 * Liste des evenements créer par un utilisateur
	 */
	@OneToMany(mappedBy = "utilisateurCreateur")
	private Collection<Evenement> creerEvenements;

	/**
	 * Liste des participants visioConf
	 */
	@ManyToMany
	@JoinTable(name = "VisioConferenceUtilisateur", joinColumns = @JoinColumn(name = "idUtilisateur"), inverseJoinColumns = @JoinColumn(name = "idVisioConference"))
	private Collection<VisioConference> participantVisioConf;
	/**
	 * List des emails reçus
	 */
	@OneToMany(mappedBy = "utilisateurDestinataire")
	private Collection<Email> eMailsRecus;
	/**
	 * Liste des emails envoyés
	 */
	@OneToMany(mappedBy = "utilisateurExpeditreur")
	private Collection<Email> eMailsEnvoye;
	/**
	 * Liste des messages du chat room
	 */
	@OneToMany(mappedBy = "utilisateur")
	private Collection<MessagesChatRoom> messagesChatRooms;
	/**
	 * List des messages postés dans un forum
	 */
	@OneToMany(mappedBy = "utilisateur")
	private Collection<MessagesForum> messagesForums;
	/**
	 * Liste des sujets postés dans le forum
	 */
	@OneToMany(mappedBy = "utilisateur")
	private Collection<SujetForum> sujetForums;

	/**
	 * Notification
	 */
	@OneToMany(mappedBy = "utilisateur")
	private Collection<Notification> notifications;

	public Utilisateur(String nom, String prenom, String email, Date dateNaissance, String pays, String ville, Date dateInscription, byte[] photo, String motDePasse, boolean valide, boolean etat, String apropos, String sexe, String type) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.pays = pays;
		this.ville = ville;
		this.dateInscription = dateInscription;
		this.photo = photo;
		this.motDePasse = motDePasse;
		this.valide = valide;
		this.etat = etat;
		this.apropos = apropos;
		this.sexe = sexe;
		this.type = type;
	}

	public Utilisateur() {
		super();
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateNaissance() throws ParseException {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public Collection<Evenement> getCreerEvenements() {
		return creerEvenements;
	}

	public void setCreerEvenements(Collection<Evenement> creerEvenements) {
		this.creerEvenements = creerEvenements;
	}

	public Collection<Email> geteMailsRecus() {
		return eMailsRecus;
	}

	public void seteMailsRecus(Collection<Email> eMailsRecus) {
		this.eMailsRecus = eMailsRecus;
	}

	public Collection<Email> geteMailsEnvoye() {
		return eMailsEnvoye;
	}

	public void seteMailsEnvoye(Collection<Email> eMailsEnvoye) {
		this.eMailsEnvoye = eMailsEnvoye;
	}

	public Collection<MessagesChatRoom> getMessagesChatRooms() {
		return messagesChatRooms;
	}

	public void setMessagesChatRooms(Collection<MessagesChatRoom> messagesChatRooms) {
		this.messagesChatRooms = messagesChatRooms;
	}

	public Collection<MessagesForum> getMessagesForums() {
		return messagesForums;
	}

	public void setMessagesForums(Collection<MessagesForum> messagesForums) {
		this.messagesForums = messagesForums;
	}

	public Collection<SujetForum> getSujetForums() {
		return sujetForums;
	}

	public void setSujetForums(Collection<SujetForum> sujetForums) {
		this.sujetForums = sujetForums;
	}

	public Collection<Evenement> getParticipationEvenement() {
		return participationEvenement;
	}

	public void setParticipationEvenement(Collection<Evenement> participationEvenement) {
		this.participationEvenement = participationEvenement;
	}

	public Collection<VisioConference> getParticipantVisioConf() {
		return participantVisioConf;
	}

	public void setParticipantVisioConf(Collection<VisioConference> participantVisioConf) {
		this.participantVisioConf = participantVisioConf;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Collection<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Collection<Notification> notifications) {
		this.notifications = notifications;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getApropos() {
		return apropos;
	}

	public void setApropos(String apropos) {
		this.apropos = apropos;
	}

	public List<EspaceUtilisateur> getEspaceUtilisateur() {
		return espaceUtilisateur;
	}

	public void setEspaceUtilisateur(List<EspaceUtilisateur> espaceUtilisateur) {
		this.espaceUtilisateur = espaceUtilisateur;
	}
}
