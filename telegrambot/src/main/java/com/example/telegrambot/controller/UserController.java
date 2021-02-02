package com.example.telegrambot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.telegrambot.servicemysql.UserInterface;
import com.example.telegrambot.servicesql.ChamadoInterface;

@Controller
public class UserController {

	List<String> usernameList;
	
	List<Object[]> chamadosnameList;
	
	@Autowired
	UserInterface userinterface;
	
	@Autowired
	ChamadoInterface chamadointerface;
	
	@PostConstruct
	public void init() {
		usernameList = new ArrayList<String>();
		usernameList  = userinterface.usernameListNative();
		for (String string : usernameList) {
			System.out.println(string);
		}
		
		chamadosnameList = new ArrayList<Object[]>();
		chamadosnameList  = chamadointerface.chamadosListNative();
		for (Object[] c : chamadosnameList) {
			System.out.println(c[0]);
			System.out.println(c[2]);
			System.out.println(c[3]);
		}
		
	}

	
	public List<Object[]> getChamadosnameList() {
		return chamadosnameList;
	}


	public void setChamadosnameList(List<Object[]> chamadosnameList) {
		this.chamadosnameList = chamadosnameList;
	}


	public List<String> getUsernameList() {
		return usernameList;
	}

	public void setUsernameList(List<String> usernameList) {
		this.usernameList = usernameList;
	}
	
	
		
}
