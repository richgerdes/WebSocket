package com.richgerdes.test;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class WebSocketTesting {
	
	public static void main(String[] args){
		Map<String, String> map = new HashMap<String, String>();
		/*
		 * header requirements
		 * ]
		 * >> Set By class
		 * 
		 * GET /mtgox HTTP/1.1		
		 * Upgrade: websocket		
		 * Connection: Upgrade
		 * Host: websocket.mtgox.com
		 * Origin: ws://websocket.mtgox.com
		 * 
		 * >> Set Here
		 * 
		 * Sec-WebSocket-Key: 6omOcZl7/BelBTW0PIM8xQ==  //TODO Unknown key needs to be replaced
		 * Sec-WebSocket-Protocol: mtgox
		 * Sec-WebSocket-Version: 13
		 * 
		 */

		map.put("Upgrade", "WebSocket");
		map.put("Connection", "Upgrade");
		map.put("Host", "websocket.mtgox.com");
		map.put("Origin", "ws://websocket.mtgox.com");
		map.put("Sec-WebSocket-Key", "6omOcZl7/BelBTW0PIM8xQ==");
		map.put("Sec-WebSocket-Protocol", "mtgox");
		map.put("Sec-WebSocket-Version", "13");		
		try {
			MarketWatcher m = new MarketWatcher(map);
			m.connect();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
