package com.example.telegrambot.servicemysql;

import java.util.Date;
import java.util.List;

import com.example.telegrambot.modelmysql.GlpiChamados;

public interface GlpiChamadosInterface {
	
	List<String> usernameListNative();
	
	List<Object[]> newGlpiTicketsListNative(Date date);
	
	List<Object[]> newGlpiTicketsTodayListNative();
	
	void setImported(GlpiChamados glpiChamado);
	
	void save(GlpiChamados glpiChamado);
	
	GlpiChamados findById(long id);
	
}
