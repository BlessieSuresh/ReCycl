package com.recycl.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TYPEDECHET database table.
 * 
 */
@Entity
@Table(name="TYPEDECHET")
@NamedQuery(name="Typedechet.findAll", query="SELECT t FROM Typedechet t")
public class Typedechet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, precision=3)
	private long notypedechet;

	@Column(name="NIV_DANGER", precision=1)
	private BigDecimal nivDanger;

	@Column(length=50)
	private String nomtypedechet;

	//bi-directional many-to-one association to Detaildemande
	@OneToMany(mappedBy="typedechet")
	private List<Detaildemande> detaildemandes;

	//bi-directional many-to-one association to Detaildepot
	@OneToMany(mappedBy="typedechet")
	private List<Detaildepot> detaildepots;

	public Typedechet() {
	}

	public long getNotypedechet() {
		return this.notypedechet;
	}

	public void setNotypedechet(long notypedechet) {
		this.notypedechet = notypedechet;
	}

	public BigDecimal getNivDanger() {
		return this.nivDanger;
	}

	public void setNivDanger(BigDecimal nivDanger) {
		this.nivDanger = nivDanger;
	}

	public String getNomtypedechet() {
		return this.nomtypedechet;
	}

	public void setNomtypedechet(String nomtypedechet) {
		this.nomtypedechet = nomtypedechet;
	}

	public List<Detaildemande> getDetaildemandes() {
		return this.detaildemandes;
	}

	public void setDetaildemandes(List<Detaildemande> detaildemandes) {
		this.detaildemandes = detaildemandes;
	}

	public Detaildemande addDetaildemande(Detaildemande detaildemande) {
		getDetaildemandes().add(detaildemande);
		detaildemande.setTypedechet(this);

		return detaildemande;
	}

	public Detaildemande removeDetaildemande(Detaildemande detaildemande) {
		getDetaildemandes().remove(detaildemande);
		detaildemande.setTypedechet(null);

		return detaildemande;
	}

	public List<Detaildepot> getDetaildepots() {
		return this.detaildepots;
	}

	public void setDetaildepots(List<Detaildepot> detaildepots) {
		this.detaildepots = detaildepots;
	}

	public Detaildepot addDetaildepot(Detaildepot detaildepot) {
		getDetaildepots().add(detaildepot);
		detaildepot.setTypedechet(this);

		return detaildepot;
	}

	public Detaildepot removeDetaildepot(Detaildepot detaildepot) {
		getDetaildepots().remove(detaildepot);
		detaildepot.setTypedechet(null);

		return detaildepot;
	}

}