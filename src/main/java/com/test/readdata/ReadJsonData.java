/**
 * 
 */
package com.test.readdata;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;


/**  Anup
 *
 * April 20, 2025
 */
public class ReadJsonData {

	JSONParser parser = new JSONParser();

	@Test
	public void JsonData() throws IOException, ParseException {
		String JsonFilePath = "./InputData/JSON_File.jason";
		String attributeName = "gid";
		JSONObject data = null;
		//JSON parser object to parse read file
		JSONParser parser = new JSONParser();

		try {
			Object object = parser.parse(new FileReader(JsonFilePath));
			JSONObject jsonObject = (JSONObject)object;
			String gid = (String) jsonObject.get(attributeName);
			System.out.println("Name" +gid);

			//Reading the array
			JSONArray countries = (JSONArray)jsonObject.get("Countries");

			//Printing all the values
			System.out.println("First Name: " + "FirstName");
			System.out.println("Last Name: " + "");
			for(Object country : countries)
			{
				System.out.println("\t"+country.toString());
			}


		} catch (FileNotFoundException e) {

		} 
	}


}
