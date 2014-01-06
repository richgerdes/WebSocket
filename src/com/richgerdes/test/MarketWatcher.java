package com.richgerdes.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

public class MarketWatcher extends WebSocketClient {
	
	public MarketWatcher(Map<String, String> headers) throws URISyntaxException{
		super(new URI("ws://websocket.mtgox.com/mtgox"), new Draft_17(), headers);
	}

	@Override
	public void onClose(int code, String reason, boolean remote) {
		System.out.println("closed with exit code " + code + " by " + ((remote) ? "Server" : "Self") + ". additional info: " + reason);
	}

	@Override
	public void onError(Exception e) {
		e.printStackTrace();
	}

	@Override
	public void onMessage(String mesg) {
		System.out.println(mesg);
		
	}

	@Override
	public void onOpen(ServerHandshake h) {
		System.out.println("Connection complete >> " + h.getHttpStatusMessage());
	}

}
