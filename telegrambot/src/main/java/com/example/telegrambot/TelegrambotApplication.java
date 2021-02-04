package com.example.telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


import com.example.telegrambot.telegrambotconfig.GlpiTelegramMobitBot;


@SpringBootApplication
public class TelegrambotApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelegrambotApplication.class, args);

		System.out.println("########################### INICIANDO TELEGRAM BOT ##################################### ");

		/*
		 * try { TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
		 * 
		 * GlpiTelegramMobitBot botglpi = new GlpiTelegramMobitBot();
		 * botsApi.registerBot(botglpi); botglpi.sendMessageTest(); } catch
		 * (TelegramApiException e) { e.printStackTrace(); }
		 */
		System.out.println("Chegou ao final da main");
	}

}
