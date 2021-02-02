package com.example.telegrambot.servicemysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.telegrambot.repositorymysql.UserRepository;

@Service
public class UserInterfaceImp implements UserInterface{
	@Autowired
	UserRepository userrepository;

	@Override
	public List<String> usernameListNative() {
		// TODO Auto-generated method stub
		return userrepository.usernameListNative();
	}

	
}
