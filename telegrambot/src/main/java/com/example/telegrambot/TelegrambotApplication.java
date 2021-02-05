package com.example.telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.example.telegrambot.telegrambotconfig.GlpiTelegramMobitBot;

@SpringBootApplication
//@PropertySource("file:application.properties")
public class TelegrambotApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelegrambotApplication.class, args);
	}

}
