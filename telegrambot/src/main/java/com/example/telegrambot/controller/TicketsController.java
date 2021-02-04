package com.example.telegrambot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.example.telegrambot.model.Chamado;
import com.example.telegrambot.servicemysql.GlpiChamadosInterface;
import com.example.telegrambot.servicesql.ChamadoInterface;
import com.example.telegrambot.telegrambotconfig.GlpiTelegramMobitBot;

@Controller
public class TicketsController {

	List<Object[]> newGlpiTicketsList;

	List<Object[]> chamadosnameList;

	List<Integer> chamadosIdList;

	List<Object[]> ticketsToSendList;

	@Autowired
	GlpiChamadosInterface glpiticketsinterface;

	@Autowired
	ChamadoInterface chamadointerface;

	@PostConstruct
	public void init() {

		findChamadoIdList();
		findNewGlpiTickets();
		saveNewChamadosOnSqlServerDatabase();
		findTicketsToSend();
		sendTickets();
		//sendTestMessage();
		

		for (Object[] ticket : newGlpiTicketsList) {
			System.out.println(ticket[0]);
			System.out.println(ticket[1]);
			System.out.println(ticket[2]);
		}

	}

	public void findTicketsToSend() {
		ticketsToSendList = new ArrayList<Object[]>();
		ticketsToSendList = chamadointerface.ticketsToSendListNative();
	}
	
	public void sendTestMessage() {
		try {
			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

			GlpiTelegramMobitBot botglpi = new GlpiTelegramMobitBot();
			botsApi.registerBot(botglpi);
			botglpi.sendMessageTest();
			

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}

	public void sendTickets() {
		try {
			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

			GlpiTelegramMobitBot botglpi = new GlpiTelegramMobitBot();
			botsApi.registerBot(botglpi);

			for (Object[] ticketToSend : ticketsToSendList) {
				
				try {
					
					botglpi.sendMessageGlpiTicket(ticketToSend[0].toString(),
							ticketToSend[1].toString(),
							ticketToSend[2].toString());
					
					Chamado ticketToSave = new Chamado(); 
					ticketToSave = chamadointerface.findByNmchamadoAndDtexclusao(ticketToSend[0].toString(), null);
					chamadointerface.setSent(ticketToSave);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}

	public void saveNewChamadosOnSqlServerDatabase() {

		for (Object[] ticket : newGlpiTicketsList) {
			Chamado newTicket = new Chamado();
			newTicket.setNmChamado(ticket[0].toString());
			newTicket.setTitulo(ticket[1].toString());
			newTicket.setDescricao(ticket[2].toString());
			try {
				chamadointerface.save(newTicket);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void findNewGlpiTickets() {
		newGlpiTicketsList = new ArrayList<Object[]>();
		newGlpiTicketsList = glpiticketsinterface.newGlpiTicketsTodayListNative(chamadosIdList);
	}

	public void findChamadoIdList() {
		chamadosIdList = new ArrayList<Integer>();
		chamadosIdList = chamadointerface.chamadosIdListNative();
	}

	public List<Object[]> getChamadosnameList() {
		return chamadosnameList;
	}

	public void setChamadosnameList(List<Object[]> chamadosnameList) {
		this.chamadosnameList = chamadosnameList;
	}

	public List<Object[]> getNewGlpiTicketsList() {
		return newGlpiTicketsList;
	}

	public void setNewGlpiTicketsList(List<Object[]> newGlpiTicketsList) {
		this.newGlpiTicketsList = newGlpiTicketsList;
	}

	public List<Integer> getChamadosIdList() {
		return chamadosIdList;
	}

	public void setChamadosIdList(List<Integer> chamadosIdList) {
		this.chamadosIdList = chamadosIdList;
	}

	public List<Object[]> getTicketsToSendList() {
		return ticketsToSendList;
	}

	public void setTicketsToSendList(List<Object[]> ticketsToSendList) {
		this.ticketsToSendList = ticketsToSendList;
	}

}
