package com.example.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

import com.example.telegrambot.model.Chamado;
import com.example.telegrambot.modelmysql.User;

@Component
public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

	@Query(value = "Select nm_chamado,enviado,titulo,descricao from chamados where dt_exclusao is null ", nativeQuery = true)
	List<Object[]> chamadosListNative();
}
