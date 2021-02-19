package com.example.telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.telegrambot.controller.TicketsController;

@SpringBootApplication
public class TelegrambotApplication {
	static TicketsController sendTx = new TicketsController();

	public static void main(String[] args) {
		SpringApplication.run(TelegrambotApplication.class, args);		
	}

}
