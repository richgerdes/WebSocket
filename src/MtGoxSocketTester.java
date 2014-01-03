import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MtGoxSocketTester {
	
	MtGoxConnection mtg;
	
	public MtGoxSocketTester(){
		
		URI uri;
		try {
			uri = new URI("ws://websocket.mtgox.com:80");
			
			mtg = new MtGoxConnection(uri);
			
			subscribe();
		
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void subscribe() throws IOException {
		String sub = "{\"op\": \"mtgox.subscribe\",\"type\": \"ticker\"}";
		mtg.send(sub);
	}

}
