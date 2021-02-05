package com.example.telegrambot.servicemysql;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.telegrambot.modelmysql.GlpiChamados;
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
	public List<Object[]> newGlpiTicketsTodayListNative() {
			return repository.newGlpiTicketsListCurrentDateNative();
	}

	@Override
	public void setImported(GlpiChamados glpiChamado) {
		glpiChamado.setImported("1");
		repository.save(glpiChamado);
	}

	@Override
	public void save(GlpiChamados glpiChamado) {
		repository.save(glpiChamado);
	}

	@Override
	public GlpiChamados findById(long id) {
		return repository.findById(id);
	}

	
}
