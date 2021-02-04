package com.example.telegrambot.servicesql;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.telegrambot.model.Chamado;
import com.example.telegrambot.repository.ChamadoRepository;

@Service
public class ChamadoInterfaceImp implements ChamadoInterface{
	@Autowired
	ChamadoRepository repository;

	@Override
	public List<Object[]> chamadosListNative() {
		// TODO Auto-generated method stub
		return repository.chamadosListNative();
	}

	@Override
	public List<Integer> chamadosIdListNative() {
		return repository.chamadosIdListNative();
	}

	@Override
	public void save(Chamado chamado) {
		repository.save(chamado);
	}
	
	
	@Override
	public void remove(Chamado chamado) {
		chamado.setDtExclusao(new Date());
		repository.save(chamado);
	}

	@Override
	public List<Object[]> ticketsToSendListNative() {
		return repository.ticketsToSendListNative();
	}

	@Override
	public void setSent(Chamado chamado) {
		chamado.setEnviado(new Date());
		repository.save(chamado);
	}

	@Override
	public Chamado findByNmchamadoAndDtexclusao(String nmChamado, Date dtExclusao) {
		return repository.findByNmChamadoAndDtExclusao(nmChamado, dtExclusao);
	}
	
}
