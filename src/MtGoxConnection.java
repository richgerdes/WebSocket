import java.io.IOException;
import java.net.URI;

import com.sixfire.websocket.WebSocket;


public class MtGoxConnection extends Thread {
	
	WebSocket w;
	
	public MtGoxConnection(URI url) throws IOException {
		w = new WebSocket(url);
		w.connect();
		
		start();
	}
	
	public void run(){		
		try {
			String read = "";
			while((read = w.recv()) != null){
				
				System.out.println(read);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void send(String msg) throws IOException {
		w.send(msg);
		
	}

}
