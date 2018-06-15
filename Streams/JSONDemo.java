package streams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.*;

public class JSONDemo {
	
	public void readJSON() throws FileNotFoundException, IOException, ParseException, JSONException{
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./test.json")); 
		
		JSONObject jsonObject = (JSONObject) obj;
		
		String name = (String)jsonObject.get("Name");
		String author = (String)jsonObject.get("Author");
		JSONArray interestslist = (JSONArray) jsonObject.get("Interests");
		
		System.out.println(name);
		System.out.println(author);
		
		Iterator<String> it = interestslist.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	
	public void writeJSON() throws JSONException, IOException{
		JSONObject obj = new JSONObject();
		obj.put("Name", "TestJSON");
		obj.put("Author", "MadhaviVenkatesh");
		
		JSONArray interests = new JSONArray();
		interests.add("workout");
		interests.add("cooking");
		interests.add("singing");
		obj.put("Interests", interests);
		
		try(FileWriter file = new FileWriter("./test.json")){
			file.write(obj.toString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		}
	}
	
	public static void main(String[] args){
		JSONDemo write = new JSONDemo();
		try {
			write.writeJSON();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONDemo read = new JSONDemo();
		try {
			read.readJSON();
		} catch (IOException | ParseException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
