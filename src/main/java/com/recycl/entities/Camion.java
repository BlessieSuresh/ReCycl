package com.recycl.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CAMION database table.
 * 
 */
@Entity
@Table(name="CAMION")
@NamedQuery(name="Camion.findAll", query="SELECT c FROM Camion c")
public class Camion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=10)
	private String noimmatric;

	@Temporal(TemporalType.DATE)
	private Date dateachat;

	@Column(nullable=false, length=50)
	private String marque;

	@Column(nullable=false, length=50)
	private String modele;

	//bi-directional many-to-one association to Tournee
	@OneToMany(mappedBy="camion")
	private List<Tournee> tournees;

	public Camion() {
	}

	public String getNoimmatric() {
		return this.noimmatric;
	}

	public void setNoimmatric(String noimmatric) {
		this.noimmatric = noimmatric;
	}

	public Date getDateachat() {
		return this.dateachat;
	}

	public void setDateachat(Date dateachat) {
		this.dateachat = dateachat;
	}

	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return this.modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public List<Tournee> getTournees() {
		return this.tournees;
	}

	public void setTournees(List<Tournee> tournees) {
		this.tournees = tournees;
	}

	public Tournee addTournee(Tournee tournee) {
		getTournees().add(tournee);
		tournee.setCamion(this);

		return tournee;
	}

	public Tournee removeTournee(Tournee tournee) {
		getTournees().remove(tournee);
		tournee.setCamion(null);

		return tournee;
	}

}