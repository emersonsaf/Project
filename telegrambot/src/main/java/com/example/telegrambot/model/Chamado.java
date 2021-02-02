package com.example.telegrambot.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.telegrambot.util.GenericEntity;

@Entity
@Table(name = "chamados")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Chamado extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "nm_chamado")
	private String nmchamado;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "enviado")
	private String enviado;
	@Column(name = "dt_exclusao")
	private String dtexclusao;

	public String getNmchamado() {
		return nmchamado;
	}

	public void setNmchamado(String nmchamado) {
		this.nmchamado = nmchamado;
	}

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

	public String getEnviado() {
		return enviado;
	}

	public void setEnviado(String enviado) {
		this.enviado = enviado;
	}

	public String getDtexclusao() {
		return dtexclusao;
	}

	public void setDtexclusao(String dtexclusao) {
		this.dtexclusao = dtexclusao;
	}

}
