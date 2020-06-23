package com.recycl.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DETAILDEPOT database table.
 * 
 */
@Embeddable
public class DetaildepotPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=6)
	private long notournee;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=3)
	private long notypedechet;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=3)
	private long nocentre;

	public DetaildepotPK() {
	}
	public long getNotournee() {
		return this.notournee;
	}
	public void setNotournee(long notournee) {
		this.notournee = notournee;
	}
	public long getNotypedechet() {
		return this.notypedechet;
	}
	public void setNotypedechet(long notypedechet) {
		this.notypedechet = notypedechet;
	}
	public long getNocentre() {
		return this.nocentre;
	}
	public void setNocentre(long nocentre) {
		this.nocentre = nocentre;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetaildepotPK)) {
			return false;
		}
		DetaildepotPK castOther = (DetaildepotPK)other;
		return 
			(this.notournee == castOther.notournee)
			&& (this.notypedechet == castOther.notypedechet)
			&& (this.nocentre == castOther.nocentre);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.notournee ^ (this.notournee >>> 32)));
		hash = hash * prime + ((int) (this.notypedechet ^ (this.notypedechet >>> 32)));
		hash = hash * prime + ((int) (this.nocentre ^ (this.nocentre >>> 32)));
		
		return hash;
	}
}