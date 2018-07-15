package Satellite.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.mashape.unirest.http.Unirest;

public class SatelliteBot extends TelegramLongPollingBot{

	String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

	String apiToken = "";
	String chatId = "@SatelliteDatenbonkosMDB";
	
	
	public void onUpdateReceived(Update update) {
		
		
	}

	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "ModerneDatenbonkosBot";
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "515018362:AAGbnYF-LJ51MoP0PTHWOrO9E2z9HsOTfvc";
	}
	
	public void sendMessage(String message)
	{
		
		SendMessage sm = new SendMessage();
		sm.setChatId("@SatelliteDatenbonkosMDB");
		sm.setText(message);
		try {
			sendMessage(sm);
		} catch (TelegramApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
