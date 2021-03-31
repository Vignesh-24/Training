package eyrest;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class RemoteClient {

	public static void main(String[] args) throws IOException {
		
		URL url=new URL("http://localhost:8080/eyrest/rest/test");
		URLConnection urlConnection=url.openConnection();
		urlConnection.getInputStream();
		
	}

}
