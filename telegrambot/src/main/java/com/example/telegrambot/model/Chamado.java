package com.example.telegrambot.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.telegrambot.util.GenericEntity;

/**
 * @author ericksouza
 *
 */
@Entity
@Table(name = "chamados")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Chamado extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "nm_chamado")
	private String nmChamado;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "enviado")
	@Temporal(TemporalType.TIMESTAMP)
	private Date enviado;
	
	@Column(name = "dt_exclusao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtExclusao;



	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getEnviado() {
		return enviado;
	}

	public void setEnviado(Date enviado) {
		this.enviado = enviado;
	}

	public String getNmChamado() {
		return nmChamado;
	}

	public void setNmChamado(String nmChamado) {
		this.nmChamado = nmChamado;
	}

	public Date getDtExclusao() {
		return dtExclusao;
	}

	public void setDtExclusao(Date dtExclusao) {
		this.dtExclusao = dtExclusao;
	}

	
	

	

}
