package com.circuito_universitario.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEvento;
	private String nomeEvento;
	private String descricaoEvento;
	private Date dataEvento;
	private String enderecoEvento;
	private String imagemEvento;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

//CONTRUTOR
	public Evento(Integer idEvento, String nomeEvento, String descricaoEvento, Date dataEvento, String enderecoEvento,
			String imagemEvento) {
		super();
		this.idEvento = idEvento;
		this.nomeEvento = nomeEvento;
		this.descricaoEvento = descricaoEvento;
		this.dataEvento = dataEvento;
		this.enderecoEvento = enderecoEvento;
		this.imagemEvento = imagemEvento;
	}

//GET & SET
	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public String getDescricaoEvento() {
		return descricaoEvento;
	}

	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getEnderecoEvento() {
		return enderecoEvento;
	}

	public void setEnderecoEvento(String enderecoEvento) {
		this.enderecoEvento = enderecoEvento;
	}

	public String getImagemEvento() {
		return imagemEvento;
	}

	public void setImagemEvento(String imagemEvento) {
		this.imagemEvento = imagemEvento;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	// HASH & EQUALS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEvento == null) ? 0 : idEvento.hashCode());
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
		Evento other = (Evento) obj;
		if (idEvento == null) {
			if (other.idEvento != null)
				return false;
		} else if (!idEvento.equals(other.idEvento))
			return false;
		return true;
	}

}
