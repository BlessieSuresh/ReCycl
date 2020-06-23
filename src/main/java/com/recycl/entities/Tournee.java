package com.recycl.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TOURNEE database table.
 * 
 */
@Entity
@Table(name="TOURNEE")
@NamedQuery(name="Tournee.findAll", query="SELECT t FROM Tournee t")
public class Tournee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, precision=6)
	private long notournee;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date datetournee;

	//bi-directional many-to-one association to Demande
	@OneToMany(mappedBy="tournee")
	private List<Demande> demandes;

	//bi-directional many-to-one association to Detaildepot
	@OneToMany(mappedBy="tournee")
	private List<Detaildepot> detaildepots;

	//bi-directional many-to-one association to Camion
	@ManyToOne
	@JoinColumn(name="NOIMMATRIC", nullable=false)
	private Camion camion;

	//bi-directional many-to-one association to Employe
	@ManyToOne
	@JoinColumn(name="NOEMPLOYE", nullable=false)
	private Employe employe;

	public Tournee() {
	}

	public long getNotournee() {
		return this.notournee;
	}

	public void setNotournee(long notournee) {
		this.notournee = notournee;
	}

	public Date getDatetournee() {
		return this.datetournee;
	}

	public void setDatetournee(Date datetournee) {
		this.datetournee = datetournee;
	}

	public List<Demande> getDemandes() {
		return this.demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

	public Demande addDemande(Demande demande) {
		getDemandes().add(demande);
		demande.setTournee(this);

		return demande;
	}

	public Demande removeDemande(Demande demande) {
		getDemandes().remove(demande);
		demande.setTournee(null);

		return demande;
	}

	public List<Detaildepot> getDetaildepots() {
		return this.detaildepots;
	}

	public void setDetaildepots(List<Detaildepot> detaildepots) {
		this.detaildepots = detaildepots;
	}

	public Detaildepot addDetaildepot(Detaildepot detaildepot) {
		getDetaildepots().add(detaildepot);
		detaildepot.setTournee(this);

		return detaildepot;
	}

	public Detaildepot removeDetaildepot(Detaildepot detaildepot) {
		getDetaildepots().remove(detaildepot);
		detaildepot.setTournee(null);

		return detaildepot;
	}

	public Camion getCamion() {
		return this.camion;
	}

	public void setCamion(Camion camion) {
		this.camion = camion;
	}

	public Employe getEmploye() {
		return this.employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

}