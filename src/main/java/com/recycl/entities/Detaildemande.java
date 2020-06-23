package com.recycl.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DETAILDEMANDE database table.
 * 
 */
@Entity
@Table(name="DETAILDEMANDE")
@NamedQuery(name="Detaildemande.findAll", query="SELECT d FROM Detaildemande d")
public class Detaildemande implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetaildemandePK id;

	@Column(nullable=false, precision=3)
	private BigDecimal quantiteenlevee;

	@Column(length=100)
	private String remarque;

	//bi-directional many-to-one association to Demande
	@ManyToOne
	@JoinColumn(name="NODEMANDE", nullable=false, insertable=false, updatable=false)
	private Demande demande;

	//bi-directional many-to-one association to Typedechet
	@ManyToOne
	@JoinColumn(name="NOTYPEDECHET", nullable=false, insertable=false, updatable=false)
	private Typedechet typedechet;

	public Detaildemande() {
	}

	public DetaildemandePK getId() {
		return this.id;
	}

	public void setId(DetaildemandePK id) {
		this.id = id;
	}

	public BigDecimal getQuantiteenlevee() {
		return this.quantiteenlevee;
	}

	public void setQuantiteenlevee(BigDecimal quantiteenlevee) {
		this.quantiteenlevee = quantiteenlevee;
	}

	public String getRemarque() {
		return this.remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public Demande getDemande() {
		return this.demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	public Typedechet getTypedechet() {
		return this.typedechet;
	}

	public void setTypedechet(Typedechet typedechet) {
		this.typedechet = typedechet;
	}

}