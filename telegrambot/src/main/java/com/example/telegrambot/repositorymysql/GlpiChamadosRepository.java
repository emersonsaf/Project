package com.example.telegrambot.repositorymysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import com.example.telegrambot.modelmysql.GlpiChamados;

@Component
public interface GlpiChamadosRepository extends JpaRepository<GlpiChamados, Long> {

	@Query(value = "Select name from glpi_tickets where is_deleted = 0", nativeQuery = true)
	List<String> usernameListNative();
	
	
	
	@Query(value = "SELECT tic.id,tic.name,tic.content FROM glpi_tickets tic " + 
			"join glpi_itilcategories cat on cat.id = tic.itilcategories_id and cat.itilcategories_id in (648,661,660,659,658,657,656,655,654, " + 
			"653,652,651,650,649,647,646,846) and cat.entities_id = 1 " + 
			"where tic.date >= ?1 and is_deleted = 0", nativeQuery = true)
	List<Object[]> newGlpiTicketsListNative(Date date);
	
	@Query(value = "SELECT tic.id,tic.name,tic.content FROM glpi_tickets tic " + 
			"join glpi_itilcategories cat on cat.id = tic.itilcategories_id and cat.itilcategories_id in (648,661,660,659,658,657,656,655,654, " + 
			"653,652,651,650,649,647,646,846) and cat.entities_id = 1 " + 
			"where tic.date >= current_date() and is_deleted = 0 "
			+ "and tic.imported = 0", nativeQuery = true)
	List<Object[]> newGlpiTicketsListCurrentDateNative();


	@Query(value = "SELECT tic.id,tic.name,tic.content FROM glpi_tickets tic " + 
			"join glpi_itilcategories cat on cat.id = tic.itilcategories_id and cat.itilcategories_id in (648,661,660,659,658,657,656,655,654, " + 
			"653,652,651,650,649,647,646,846) and cat.entities_id = 1 " + 
			"where tic.date >= current_date() and is_deleted = 0 "
			, nativeQuery = true)
	List<Object[]> newGlpiTicketsListCurrentDateListEmptyNative();
	
	GlpiChamados findById(long id);
	
	
}
