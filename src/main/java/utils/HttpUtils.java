package utils;
// binding json voi model
import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.NewsModel;

public class HttpUtils {
	private String valueConvert;
	public HttpUtils(String valueConvert) {
		this.valueConvert=valueConvert;
	}
	public HttpUtils() {
		
	}
	
	public <T> T toModel (Class <T> tclass) { 
		// generate String json vao model
		try {
			ObjectMapper om= new ObjectMapper();
			om.configure(Feature.AUTO_CLOSE_SOURCE, true);
			return om.readValue(valueConvert, tclass);
		}catch (Exception e ) {
		e.printStackTrace();
		 System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	public static HttpUtils of (BufferedReader reader) {
		//reader chua json
		StringBuilder sb= new StringBuilder();
		
		try { 
			String line;
			while ((line=reader.readLine()) != null) {
				sb.append(line);
			}	
			
		}
		
		catch (IOException e) {
		}
 		return new HttpUtils(sb.toString());
	}
}
