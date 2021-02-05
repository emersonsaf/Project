package com.example.telegrambot.modelmysql;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.telegrambot.util.GenericEntity;

@Entity
@Table(name = "glpi_tickets")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class GlpiChamados extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	private String name;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "imported")
	private String imported;

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImported() {
		return imported;
	}

	public void setImported(String imported) {
		this.imported = imported;
	}

}
