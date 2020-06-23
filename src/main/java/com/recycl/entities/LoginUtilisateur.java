package com.recycl.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the LOGIN_UTILISATEUR database table.
 * 
 */
@Entity
@Table(name="LOGIN_UTILISATEUR")
@NamedQuery(name="LoginUtilisateur.findAll", query="SELECT l FROM LoginUtilisateur l")
public class LoginUtilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, precision=6)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_MDP", nullable=false)
	private Date dateMdp;

	@Column(nullable=false, length=50)
	private String fonction;

	@Column(nullable=false, length=10)
	private String login;

	@Column(nullable=false, length=10)
	private String mdp;

	//bi-directional many-to-one association to Employe
	@ManyToOne
	@JoinColumn(name="NOEMPLOYE", nullable=false)
	private Employe employe;

	public LoginUtilisateur() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateMdp() {
		return this.dateMdp;
	}

	public void setDateMdp(Date dateMdp) {
		this.dateMdp = dateMdp;
	}

	public String getFonction() {
		return this.fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Employe getEmploye() {
		return this.employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

}