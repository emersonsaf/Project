package com.example.telegrambot.servicemysql;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.telegrambot.repositorymysql.GlpiChamadosRepository;



@Service
public class GlpiChamadosInterfaceImp implements GlpiChamadosInterface{
	@Autowired
	GlpiChamadosRepository repository;

	@Override
	public List<String> usernameListNative() {
		return repository.usernameListNative();
	}

	@Override
	public List<Object[]> newGlpiTicketsListNative(Date date) {
		return repository.newGlpiTicketsListNative(date);
	}

	@Override
	public List<Object[]> newGlpiTicketsTodayListNative(List<Integer> ticketNumbers) {
		if(ticketNumbers.size()>0) {
			return repository.newGlpiTicketsListCurrentDateNative(ticketNumbers);
		}else {
			return repository.newGlpiTicketsListCurrentDateListEmptyNative();
		}
		
	}

	
}
