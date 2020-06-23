package com.recycl.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DETAILDEPOT database table.
 * 
 */
@Entity
@Table(name="DETAILDEPOT")
@NamedQuery(name="Detaildepot.findAll", query="SELECT d FROM Detaildepot d")
public class Detaildepot implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetaildepotPK id;

	@Column(nullable=false, precision=3)
	private BigDecimal quantitedeposee;

	//bi-directional many-to-one association to Centretraitement
	@ManyToOne
	@JoinColumn(name="NOCENTRE", nullable=false, insertable=false, updatable=false)
	private Centretraitement centretraitement;

	//bi-directional many-to-one association to Tournee
	@ManyToOne
	@JoinColumn(name="NOTOURNEE", nullable=false, insertable=false, updatable=false)
	private Tournee tournee;

	//bi-directional many-to-one association to Typedechet
	@ManyToOne
	@JoinColumn(name="NOTYPEDECHET", nullable=false, insertable=false, updatable=false)
	private Typedechet typedechet;

	public Detaildepot() {
	}

	public DetaildepotPK getId() {
		return this.id;
	}

	public void setId(DetaildepotPK id) {
		this.id = id;
	}

	public BigDecimal getQuantitedeposee() {
		return this.quantitedeposee;
	}

	public void setQuantitedeposee(BigDecimal quantitedeposee) {
		this.quantitedeposee = quantitedeposee;
	}

	public Centretraitement getCentretraitement() {
		return this.centretraitement;
	}

	public void setCentretraitement(Centretraitement centretraitement) {
		this.centretraitement = centretraitement;
	}

	public Tournee getTournee() {
		return this.tournee;
	}

	public void setTournee(Tournee tournee) {
		this.tournee = tournee;
	}

	public Typedechet getTypedechet() {
		return this.typedechet;
	}

	public void setTypedechet(Typedechet typedechet) {
		this.typedechet = typedechet;
	}

}