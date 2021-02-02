package com.example.telegrambot.servicesql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.telegrambot.repository.ChamadoRepository;
import com.example.telegrambot.repositorymysql.UserRepository;

@Service
public class ChamadoInterfaceImp implements ChamadoInterface{
	@Autowired
	ChamadoRepository chamdorepository;

	@Override
	public List<Object[]> chamadosListNative() {
		// TODO Auto-generated method stub
		return chamdorepository.chamadosListNative();
	}

	
}
