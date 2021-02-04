package com.example.telegrambot.servicesql;

import java.util.List;

import com.example.telegrambot.model.Chamado;

public interface ChamadoInterface {
	
	List<Object[]> chamadosListNative();	
	
	List<Integer> chamadosIdListNative();
	
	void save(Chamado chamado);
	
	void remove(Chamado chamado);
}
