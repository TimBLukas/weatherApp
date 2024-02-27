package weatherInformation;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.reflect.*;

public class weatherInformation {

	/**
	 * convert a json String to a HashMap
	 * @param str json String that is supposed to be converted
	 * @return a HashMap representing the json String
	 */
	 public static Map<String, Object> jsonToMap(String str) 
	 {
		 
	        if (str == null || str.isEmpty()) 
	        {
	            throw new IllegalArgumentException("JSON string is null or empty");
	        }
	        	        
	        return new Gson().fromJson(
	        		str, new TypeToken<HashMap<String, Object>>() {}.getType()
	        		);
	   
	 }
	
	 /**
	  * a method to get the weather information of a specific city using the openweathermap API
	  * @param country the country the city is located in
	  * @param city the city for which the weather data is to be evaluated
	  * @return a Map containing the weatherInfomation for the city
	  */
	public static Map <String, Object> getWeatherInformation(String country, String city){
		
		// Datei auslesen um auf den API Key zugreifen zu können
		
		String API_KEY = null;
		
		try (BufferedReader reader = new BufferedReader(new FileReader("../weather/src/API.txt")))
		{
			
			String zeile ;
			
			while ((zeile = reader.readLine()) != null)
			{
				API_KEY = zeile;
			}
			
			
		}catch (FileNotFoundException fileNotFound)
		{
			fileNotFound.printStackTrace();
		}catch (IOException ioException) 
		{
			ioException.printStackTrace();
		}catch (Exception exception)
		{
			exception.printStackTrace();
		}
		
		String LOCATION = city + "," + country;
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY + "&units=metric";
		
		Map <String, Object> weatherData = new HashMap<>();
		
		try 
		{
			StringBuilder result = new StringBuilder();
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			
			while((line = rd.readLine()) != null) 
			{
				result.append(line);
			}
			rd.close();
			
			System.out.println(result);
			
			Map<String, Object> respMap = jsonToMap(result.toString());
			System.out.println(respMap);
			
			Object weatherObject = respMap.get("weather");
			List<Map<String, Object>> weatherList = new ArrayList<>();
			
			if (weatherObject instanceof Object[]) {
	            Object[] weatherArray = (Object[]) weatherObject;
	            for (Object obj : weatherArray) {
	                if (obj instanceof Map) {
	                    Map<String, Object> weatherMap = (Map<String, Object>) obj;
	                    weatherList.add(weatherMap);
	                }
	            }
	        }
			
			Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
			Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
			
			if(weatherList.size() > 0) weatherData.put("weather", weatherList.get(0));
			
			weatherData.put("current temp", mainMap.get("temp"));
			
			weatherData.put("feels_like", mainMap.get("feels_like"));
			
			weatherData.put("wind Speed", windMap.get("speed"));
			
			weatherData.put("wind_angle", windMap.get("deg"));
			
			return weatherData;
			
		}catch(IOException ioException) 
		{
			System.out.println(ioException.getMessage());

		}catch(Exception exception) 
		{
			System.out.println(exception.getMessage());

		}
		
		return weatherData;
		
	}
}

