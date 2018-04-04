package com.webservices.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



public class MyRESTClient
{
	public static void main(String ...s)
	{
		
		//Get the Data
		String locationVal = "goa";
		String typeVal = "xml";
		
		String contentType=null;
		String url=null;
		
		if(typeVal.equals("xml")) {
			contentType = MediaType.APPLICATION_XML;
			url = "https://maps.googleapis.com/maps/api/geocode/xml?address="+locationVal;
		
		} else if(typeVal.equals("json")) {
			contentType = MediaType.APPLICATION_JSON;
			url = "https://maps.googleapis.com/maps/api/geocode/json?address="+locationVal;
		}
		
		/*
		 * Invoke the Google Maps Web Services
		 */
		//1. Build the Client
		Client client = ClientBuilder.newClient();
		
		//2. Set the Target
		System.out.println(url);
		WebTarget target = client.target(url);
		
		//3. Get the Response
		Response response = target.request(contentType).get();
		
		//4. Process the Response
		String respData = (String)response.readEntity(String.class);
		
		System.out.println(respData);
		
	}
}
