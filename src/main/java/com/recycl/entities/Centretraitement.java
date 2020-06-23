package com.recycl.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CENTRETRAITEMENT database table.
 * 
 */
@Entity
@Table(name="CENTRETRAITEMENT")
@NamedQuery(name="Centretraitement.findAll", query="SELECT c FROM Centretraitement c")
public class Centretraitement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, precision=3)
	private long nocentre;

	@Column(precision=5)
	private BigDecimal cpostalcentre;

	@Column(length=100)
	private String nomcentre;

	@Column(precision=3)
	private BigDecimal noruecentre;

	@Column(length=200)
	private String ruecentre;

	@Column(length=50)
	private String villecentre;

	//bi-directional many-to-one association to Detaildepot
	@OneToMany(mappedBy="centretraitement")
	private List<Detaildepot> detaildepots;

	public Centretraitement() {
	}

	public long getNocentre() {
		return this.nocentre;
	}

	public void setNocentre(long nocentre) {
		this.nocentre = nocentre;
	}

	public BigDecimal getCpostalcentre() {
		return this.cpostalcentre;
	}

	public void setCpostalcentre(BigDecimal cpostalcentre) {
		this.cpostalcentre = cpostalcentre;
	}

	public String getNomcentre() {
		return this.nomcentre;
	}

	public void setNomcentre(String nomcentre) {
		this.nomcentre = nomcentre;
	}

	public BigDecimal getNoruecentre() {
		return this.noruecentre;
	}

	public void setNoruecentre(BigDecimal noruecentre) {
		this.noruecentre = noruecentre;
	}

	public String getRuecentre() {
		return this.ruecentre;
	}

	public void setRuecentre(String ruecentre) {
		this.ruecentre = ruecentre;
	}

	public String getVillecentre() {
		return this.villecentre;
	}

	public void setVillecentre(String villecentre) {
		this.villecentre = villecentre;
	}

	public List<Detaildepot> getDetaildepots() {
		return this.detaildepots;
	}

	public void setDetaildepots(List<Detaildepot> detaildepots) {
		this.detaildepots = detaildepots;
	}

	public Detaildepot addDetaildepot(Detaildepot detaildepot) {
		getDetaildepots().add(detaildepot);
		detaildepot.setCentretraitement(this);

		return detaildepot;
	}

	public Detaildepot removeDetaildepot(Detaildepot detaildepot) {
		getDetaildepots().remove(detaildepot);
		detaildepot.setCentretraitement(null);

		return detaildepot;
	}

}