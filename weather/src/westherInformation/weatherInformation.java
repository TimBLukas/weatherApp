package westherInformation;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.reflect.*;

public class weatherInformation {

	 public static Map<String, Object> jsonToMap(String str) {
		 
	        if (str == null || str.isEmpty()) {
	            throw new IllegalArgumentException("JSON string is null or empty");
	        }
	        	        
	        return new Gson().fromJson(
	        		str, new TypeToken<HashMap<String, Object>>() {}.getType()
	        		);
	   
	 }
	 
	public static void main(String[] args) {
		
		String API_KEY = "24d30a7d497706ee1ca8ccef63208a64";
		String LOCATION = "Stuttgart,DE";
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY + "&units=metric";
		
		try {
			StringBuilder result = new StringBuilder();
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			
			while((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();
			
			System.out.println(result);
			
			Map<String, Object> respMap = jsonToMap(result.toString());
			Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
			Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
			
			System.out.println("Current Temprature: " + mainMap.get("temp"));
			System.out.println("Current Humidity: " + mainMap.get("humidity"));
			System.out.println("Wind Speed: " + windMap.get("speed"));
			System.out.println("Wind Angels: " + windMap.get("deg"));
			
		}catch(IOException ioException) {
			System.out.println(ioException.getMessage());
		}catch(Exception exception) {
			System.out.println(exception.getMessage());
		}
		
	}
}

