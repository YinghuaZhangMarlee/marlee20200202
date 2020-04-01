package neu.edu.csye6200.net4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HTTPUrlConnectTest {

	private URL url= null;
	private HttpURLConnection con = null;
	
	//Constructor
	public HTTPUrlConnectTest(String urlStr){
		try {
			url = new URL(urlStr);
			con= (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
		/**
	 * Set a GET request to the URL and check the response code
	 * @return
	 * @throws IOException
	 */
	public int sendGetRequest() throws IOException {
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		System.out.println("Sending get to url "+url);
		int responseCode= con.getResponseCode();
		return responseCode;
	}
	/**
	 * Get a string reply - note call sendGetRequest first
	 * @return the HTTP reply
	 * @throws IOException
	 */
	public String getResponse () throws IOException {
		BufferedReader inBuf= new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		
		String inLine;
		StringBuffer sb = new StringBuffer();
		
		while((inLine = inBuf.readLine()) != null) {
			sb.append(inLine);
		}
		
		inBuf.close();
		return (sb.toString());
	}
	

	public static void main(String[] args) {
		HTTPUrlConnectTest httpCon = 
				new HTTPUrlConnectTest("http://www.google.com/search?q=dog");
		
		try {
			int respCode= httpCon.sendGetRequest();
			System.out.println(">>>>>> Response Code is : "+ respCode);
			
			System.out.println(">>>>>> Response is : ");
			String resp = httpCon.getResponse();
			System.out.println(resp);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
