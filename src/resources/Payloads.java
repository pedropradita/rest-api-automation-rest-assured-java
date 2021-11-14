package resources;

public class Payloads {
	
	public static String AddUser(String name, String job)
	{			
		return "{\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"job\": \""+job+"\"\r\n"
				+ "}";
	}
	
	public static String AddUserNull(String name, String job)
	{			
		return "{\r\n"
				+ "    \"name\": "+name+",\r\n"
				+ "    \"job\": "+job+"\r\n"
				+ "}";
	}

}
