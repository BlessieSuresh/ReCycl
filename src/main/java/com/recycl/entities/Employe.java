package com.recycl.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EMPLOYE database table.
 * 
 */
@Entity
@Table(name="EMPLOYE")
@NamedQuery(name="Employe.findAll", query="SELECT e FROM Employe e")
public class Employe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, precision=5)
	private long noemploye;

	@Temporal(TemporalType.DATE)
	private Date dateembauche;

	@Temporal(TemporalType.DATE)
	private Date datenaiss;

	@Column(length=50)
	private String fonction;

	@Column(length=50)
	private String nom;

	@Column(length=50)
	private String prenom;

	@Column(precision=8, scale=2)
	private BigDecimal salaire;

	//bi-directional many-to-one association to LoginUtilisateur
	@OneToMany(mappedBy="employe")
	private List<LoginUtilisateur> loginUtilisateurs;

	//bi-directional many-to-one association to Tournee
	@OneToMany(mappedBy="employe")
	private List<Tournee> tournees;

	public Employe() {
	}

	public long getNoemploye() {
		return this.noemploye;
	}

	public void setNoemploye(long noemploye) {
		this.noemploye = noemploye;
	}

	public Date getDateembauche() {
		return this.dateembauche;
	}

	public void setDateembauche(Date dateembauche) {
		this.dateembauche = dateembauche;
	}

	public Date getDatenaiss() {
		return this.datenaiss;
	}

	public void setDatenaiss(Date datenaiss) {
		this.datenaiss = datenaiss;
	}

	public String getFonction() {
		return this.fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public BigDecimal getSalaire() {
		return this.salaire;
	}

	public void setSalaire(BigDecimal salaire) {
		this.salaire = salaire;
	}

	public List<LoginUtilisateur> getLoginUtilisateurs() {
		return this.loginUtilisateurs;
	}

	public void setLoginUtilisateurs(List<LoginUtilisateur> loginUtilisateurs) {
		this.loginUtilisateurs = loginUtilisateurs;
	}

	public LoginUtilisateur addLoginUtilisateur(LoginUtilisateur loginUtilisateur) {
		getLoginUtilisateurs().add(loginUtilisateur);
		loginUtilisateur.setEmploye(this);

		return loginUtilisateur;
	}

	public LoginUtilisateur removeLoginUtilisateur(LoginUtilisateur loginUtilisateur) {
		getLoginUtilisateurs().remove(loginUtilisateur);
		loginUtilisateur.setEmploye(null);

		return loginUtilisateur;
	}

	public List<Tournee> getTournees() {
		return this.tournees;
	}

	public void setTournees(List<Tournee> tournees) {
		this.tournees = tournees;
	}

	public Tournee addTournee(Tournee tournee) {
		getTournees().add(tournee);
		tournee.setEmploye(this);

		return tournee;
	}

	public Tournee removeTournee(Tournee tournee) {
		getTournees().remove(tournee);
		tournee.setEmploye(null);

		return tournee;
	}

}