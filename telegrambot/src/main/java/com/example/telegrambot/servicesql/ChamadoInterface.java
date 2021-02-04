package com.example.telegrambot.servicesql;

import java.util.Date;
import java.util.List;

import com.example.telegrambot.model.Chamado;

public interface ChamadoInterface {
	
	List<Object[]> chamadosListNative();	
	
	List<Integer> chamadosIdListNative();
	
	void save(Chamado chamado);
	
	void remove(Chamado chamado);
	
	void setSent(Chamado chamado);
	
	List<Object[]> ticketsToSendListNative();
	
	Chamado findByNmchamadoAndDtexclusao(String nmChamado, Date dtExclusao);
	
}
