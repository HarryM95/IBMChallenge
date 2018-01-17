package restServices;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.lang.Object;

import javax.json.*;
import javax.ws.rs.GET; 
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  
@Path("/filmsService") 

public class filmsService {
	
    JsonArray jarray = Json.createArrayBuilder().build();


	   @GET 
	   @Produces(MediaType.TEXT_HTML) 
	   public String test() {
		   return "TestTestTest";
	   }
    
    	/*@GET 
	   @Produces(MediaType.TEXT_HTML) 
	   public String getText() throws MalformedURLException{ 
		   
		   URL url = new URL("https://data.sfgov.org/resource/wwmu-gmzc.json");
		   readFromUrl(url);
		   
		  
		      	JsonObject newObject = Json.createObjectBuilder().build();
				
				JsonArrayBuilder builder = Json.createArrayBuilder();
				
				for(int i=0; i<jarray.size(); i++){		//jarray.size();
					
					try{
						builder.add(Json.createObjectBuilder()
							.add("title", jarray.getJsonObject(i).getString("title"))
							.add("locations", jarray.getJsonObject(i).getString("locations")).build());
					}catch (NullPointerException e) {e.printStackTrace();}
					
					
				}
				
				JsonArray newArray = builder.build();
			
		      return newArray.toString();
		        
	   }  */
	   

	   @GET 
	   @Path("{s}") 
	   @Produces(MediaType.TEXT_HTML) 
	   public String filter(@PathParam("s") String s) throws MalformedURLException{ 
		   
		   URL url = new URL("https://data.sfgov.org/resource/wwmu-gmzc.json");
		   readFromUrl(url);
		   
		  
		      	JsonObject newObject = Json.createObjectBuilder().build();
				
				JsonArrayBuilder builder = Json.createArrayBuilder();
				
				for(int i=0; i<jarray.size(); i++){		//jarray.size();
					
					try{
						
						if(jarray.getJsonObject(i).getString("title").equals(s)) {
							
							builder.add(Json.createObjectBuilder()
								.add("title", jarray.getJsonObject(i).getString("title"))
								.add("locations", jarray.getJsonObject(i).getString("locations")).build());
						}
					}catch (NullPointerException e) {e.printStackTrace();}
					
					
				}
				
				JsonArray newArray = builder.build();
			
		      return newArray.toString();
		        
	   } 
	   
	   public void readFromUrl(URL url) {
		   
		   try {         
	            URLConnection yc = url.openConnection();
	            //BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	            
	            JsonReader reader = Json.createReader(new InputStreamReader(yc.getInputStream()));
	           
	            jarray = reader.readArray();
	            
	            reader.close();
	           
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
		   
	   }
	
}
