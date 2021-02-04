/**
 * 
 */
package com.example.telegrambot.telegrambotconfig;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @author ericksouza
 *
 */
public class GlpiTelegramMobitBot extends TelegramLongPollingBot {

	@Override
	public void onUpdateReceived(Update update) {
		// We check if the update has a message and the message has text
		if (update.hasMessage() && update.getMessage().hasText()) {
			SendMessage messageToSend = new SendMessage(); // Create a SendMessage object with mandatory fields
			messageToSend.setChatId(update.getMessage().getChatId().toString());
			messageToSend.setText(update.getMessage().getText());
			try {
				System.out.println(messageToSend.getChatId());
				System.out.println(messageToSend.getText());
				System.out.println(update.getMessage().getAuthorSignature());
				System.out.println(update.getMessage().getFrom());
				System.out.println(update.getMessage().getLocation());
				execute(messageToSend); // Call method to send the message
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getBotUsername() {
		return "Mobit_glpi_bot";
	}

	@Override
	public String getBotToken() {
		return "1619038022:AAEsyKaNDTAFeXUDM4jx-rW7DSjlNL0KvNI";
	}
	
	
	
	public void sendMessageTest() {
		SendMessage messageToSend = new SendMessage();
		messageToSend.setChatId("-349225705");
		messageToSend.setText("Ti lasca ai. Certamente não foi o piks");
		try {
			System.out.println("Mensagem de teste enviada");
			execute(messageToSend);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
//752388301 id do firu
//187109176 id erick