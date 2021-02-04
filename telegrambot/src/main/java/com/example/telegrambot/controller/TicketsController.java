package com.example.telegrambot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.telegrambot.model.Chamado;
import com.example.telegrambot.servicemysql.GlpiChamadosInterface;
import com.example.telegrambot.servicesql.ChamadoInterface;

@Controller
public class TicketsController {

	List<Object[]> newGlpiTicketsList;
	
	List<Object[]> chamadosnameList;
	
	List<Integer> chamadosIdList;
	
	@Autowired
	GlpiChamadosInterface glpiticketsinterface;
	
	@Autowired
	ChamadoInterface chamadointerface;
	
	@PostConstruct
	public void init() {
		
		findChamadoIdList();
		findNewGlpiTickets();
		saveNewChamadosOnSqlServerDatabase();
		
		// recupera lista de chamados nao enviados no 34
		// envia pelo telegram
		
		
		for (Object[] ticket : newGlpiTicketsList) {
			System.out.println(ticket[0]);
			System.out.println(ticket[1]);
			System.out.println(ticket[2]);
		}
		
	}
	
	public void findTicketsToSend() {
		
	}
	
	public void sendTickets() {
		
	}
	
	public void saveNewChamadosOnSqlServerDatabase() {
		
		for (Object[] ticket : newGlpiTicketsList) {
			Chamado newTicket = new Chamado();
			newTicket.setNmchamado(ticket[0].toString());
			newTicket.setTitulo(ticket[1].toString());
			newTicket.setDescricao(ticket[2].toString());
			try {
				chamadointerface.save(newTicket);
			}catch (Exception e) {
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
	
	
		
}
