package com.circuito_universitario.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;
	private String nomeUser;
	private String faculdadeUser;
	private Integer idadeUser;

//CONSTRUTOR
	public Usuario(Integer idUser, String nomeUser, String faculdadeUser, Integer idadeUser) {
		super();
		this.idUser = idUser;
		this.nomeUser = nomeUser;
		this.faculdadeUser = faculdadeUser;
		this.idadeUser = idadeUser;
	}

//GET/SET
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getNomeUser() {
		return nomeUser;
	}
	public void setNomeUser(String nomeUser) {
		this.nomeUser = nomeUser;
	}

	public String getFaculdadeUser() {
		return faculdadeUser;
	}
	public void setFaculdadeUser(String faculdadeUser) {
		this.faculdadeUser = faculdadeUser;
	}

	public Integer getIdadeUser() {
		return idadeUser;
	}
	public void setIdadeUser(Integer idadeUser) {
		this.idadeUser = idadeUser;
	}

//HASH/EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}
}
