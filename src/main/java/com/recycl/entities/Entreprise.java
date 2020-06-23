package com.recycl.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ENTREPRISE database table.
 * 
 */
@Entity
@Table(name="ENTREPRISE")
@NamedQuery(name="Entreprise.findAll", query="SELECT e FROM Entreprise e")
public class Entreprise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, precision=15)
	private long siret;

	@Column(length=50)
	private String contact;

	@Column(precision=5)
	private BigDecimal cpostalentr;

	@Column(precision=3)
	private BigDecimal norueentr;

	@Column(length=10)
	private String notel;

	@Column(nullable=false, length=50)
	private String raisonsociale;

	@Column(length=200)
	private String rueentr;

	@Column(length=50)
	private String villeentr;

	//bi-directional many-to-one association to Demande
	@OneToMany(mappedBy="entreprise")
	private List<Demande> demandes;

	public Entreprise() {
	}

	public long getSiret() {
		return this.siret;
	}

	public void setSiret(long siret) {
		this.siret = siret;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public BigDecimal getCpostalentr() {
		return this.cpostalentr;
	}

	public void setCpostalentr(BigDecimal cpostalentr) {
		this.cpostalentr = cpostalentr;
	}

	public BigDecimal getNorueentr() {
		return this.norueentr;
	}

	public void setNorueentr(BigDecimal norueentr) {
		this.norueentr = norueentr;
	}

	public String getNotel() {
		return this.notel;
	}

	public void setNotel(String notel) {
		this.notel = notel;
	}

	public String getRaisonsociale() {
		return this.raisonsociale;
	}

	public void setRaisonsociale(String raisonsociale) {
		this.raisonsociale = raisonsociale;
	}

	public String getRueentr() {
		return this.rueentr;
	}

	public void setRueentr(String rueentr) {
		this.rueentr = rueentr;
	}

	public String getVilleentr() {
		return this.villeentr;
	}

	public void setVilleentr(String villeentr) {
		this.villeentr = villeentr;
	}

	public List<Demande> getDemandes() {
		return this.demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

	public Demande addDemande(Demande demande) {
		getDemandes().add(demande);
		demande.setEntreprise(this);

		return demande;
	}

	public Demande removeDemande(Demande demande) {
		getDemandes().remove(demande);
		demande.setEntreprise(null);

		return demande;
	}

}