package com.example.telegrambot;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.telegrambot.controller.UserController;
import com.example.telegrambot.modelmysql.User;
import com.example.telegrambot.repositorymysql.UserRepository;
import com.example.telegrambot.servicemysql.UserInterface;
import com.example.telegrambot.servicemysql.UserInterfaceImp;
import com.mysql.cj.x.protobuf.MysqlxExpect.Open.CtxOperation;

@SpringBootApplication
public class TelegrambotApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TelegrambotApplication.class, args);
		
			 
	}

}
