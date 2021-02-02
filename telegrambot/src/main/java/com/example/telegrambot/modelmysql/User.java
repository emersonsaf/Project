package com.example.telegrambot.modelmysql;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.telegrambot.util.GenericEntity;

@Entity
@Table(name = "user")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class User extends GenericEntity {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}