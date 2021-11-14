package resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.restassured.path.json.JsonPath;

public class Global {
	
	public static JsonPath RawToJson(String response) {
		JsonPath js = new JsonPath(response);
		return js;
	}
	
	public static String DateNow() {
		Date thisDate = new Date();
		SimpleDateFormat dateForm = new SimpleDateFormat("ddMMYYHHmm");
		String dtmNow = dateForm.format(thisDate);
		return dtmNow;
	}
	
	public static String DateNowAssert() {
		Date thisDate = new Date();
		SimpleDateFormat assertDate = new SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss.SSS'Z'");
		String dtmNowAssert = assertDate.format(thisDate);
		return dtmNowAssert;
	}
	
}
