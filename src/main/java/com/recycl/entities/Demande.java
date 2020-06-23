package com.recycl.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DEMANDE database table.
 * 
 */
@Entity
@Table(name="DEMANDE")
@NamedQuery(name="Demande.findAll", query="SELECT d FROM Demande d")
public class Demande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, precision=6)
	private long nodemande;

	@Temporal(TemporalType.DATE)
	private Date datedemande;

	@Temporal(TemporalType.DATE)
	private Date dateenlevement;

	@Column(name="WEB_O_N", length=1)
	private String webON;

	//bi-directional many-to-one association to Entreprise
	@ManyToOne
	@JoinColumn(name="SIRET", nullable=false)
	private Entreprise entreprise;

	//bi-directional many-to-one association to Tournee
	@ManyToOne
	@JoinColumn(name="NOTOURNEE")
	private Tournee tournee;

	//bi-directional many-to-one association to Detaildemande
	@OneToMany(mappedBy="demande")
	private List<Detaildemande> detaildemandes;

	public Demande() {
	}

	public long getNodemande() {
		return this.nodemande;
	}

	public void setNodemande(long nodemande) {
		this.nodemande = nodemande;
	}

	public Date getDatedemande() {
		return this.datedemande;
	}

	public void setDatedemande(Date datedemande) {
		this.datedemande = datedemande;
	}

	public Date getDateenlevement() {
		return this.dateenlevement;
	}

	public void setDateenlevement(Date dateenlevement) {
		this.dateenlevement = dateenlevement;
	}

	public String getWebON() {
		return this.webON;
	}

	public void setWebON(String webON) {
		this.webON = webON;
	}

	public Entreprise getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Tournee getTournee() {
		return this.tournee;
	}

	public void setTournee(Tournee tournee) {
		this.tournee = tournee;
	}

	public List<Detaildemande> getDetaildemandes() {
		return this.detaildemandes;
	}

	public void setDetaildemandes(List<Detaildemande> detaildemandes) {
		this.detaildemandes = detaildemandes;
	}

	public Detaildemande addDetaildemande(Detaildemande detaildemande) {
		getDetaildemandes().add(detaildemande);
		detaildemande.setDemande(this);

		return detaildemande;
	}

	public Detaildemande removeDetaildemande(Detaildemande detaildemande) {
		getDetaildemandes().remove(detaildemande);
		detaildemande.setDemande(null);

		return detaildemande;
	}

}