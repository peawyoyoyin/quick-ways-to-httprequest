import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class HttpRequestExample {
	
	static String url = "http://localhost:7777";
	static String number = "7";
	
	public static void main(String[] args) throws Exception{
		httpGet();
		httpPost();
	}
	
	public static void httpGet() throws Exception {
		URL server = new URL(url);
		URLConnection connection = server.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		String line;
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		
	}
	
	public static void httpPost() throws Exception {
		URL server = new URL(url+"/post");
		HttpURLConnection connection = (HttpURLConnection) server.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
		connection.setDoOutput(true);
		
		OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
		writer.write("number="+URLEncoder.encode(number,"utf8")+"&param2=hello");
		writer.close();
		
		String line;
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
	}
}
