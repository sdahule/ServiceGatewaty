package com.enterprise.ServiceGateway.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;


import com.fasterxml.jackson.core.JsonParser;



import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;



public class RestService {

	public static JSONArray call(String resturl, String requestMethod ,Map<String,String> requestParameters) {
		String output = null;
		StringBuilder response = new StringBuilder();
		JSONParser p = new JSONParser(JSONParser.MODE_JSON_SIMPLE);
		
		HttpURLConnection conn = null;
		try {
		
			URL url = new URL(resturl);
			 conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(requestMethod);
			
			for(Map.Entry<String, String> entry : requestParameters.entrySet()) {
				conn.setRequestProperty(entry.getKey(), entry.getValue());
			}
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
			response.append(output);
			}
			
			return (JSONArray)p.parse(response.toString());
		  } catch (MalformedURLException e) {
			  conn.disconnect();
			e.printStackTrace();

		  } catch (IOException e) {
			  conn.disconnect();
			e.printStackTrace();

		  } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			  conn.disconnect();
		  }
		return null;

	}
}
