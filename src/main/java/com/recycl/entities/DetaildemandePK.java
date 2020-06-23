package com.recycl.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DETAILDEMANDE database table.
 * 
 */
@Embeddable
public class DetaildemandePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false, precision=6)
	private long nodemande;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=3)
	private long notypedechet;

	public DetaildemandePK() {
	}
	public long getNodemande() {
		return this.nodemande;
	}
	public void setNodemande(long nodemande) {
		this.nodemande = nodemande;
	}
	public long getNotypedechet() {
		return this.notypedechet;
	}
	public void setNotypedechet(long notypedechet) {
		this.notypedechet = notypedechet;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetaildemandePK)) {
			return false;
		}
		DetaildemandePK castOther = (DetaildemandePK)other;
		return 
			(this.nodemande == castOther.nodemande)
			&& (this.notypedechet == castOther.notypedechet);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.nodemande ^ (this.nodemande >>> 32)));
		hash = hash * prime + ((int) (this.notypedechet ^ (this.notypedechet >>> 32)));
		
		return hash;
	}
}