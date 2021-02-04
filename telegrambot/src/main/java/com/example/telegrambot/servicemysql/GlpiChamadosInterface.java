package com.example.telegrambot.servicemysql;

import java.util.Date;
import java.util.List;

public interface GlpiChamadosInterface {
	
	List<String> usernameListNative();
	
	List<Object[]> newGlpiTicketsListNative(Date date);
	
	List<Object[]> newGlpiTicketsTodayListNative(List<Integer> ticketNumbers);
	
}
