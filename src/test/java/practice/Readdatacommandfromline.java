package practice;

import org.testng.annotations.Test;

public class Readdatacommandfromline {

	@Test

	public void Readdata()
	{
	String  BROWSER = System.getProperty("browser");
	System.out.println(BROWSER);
	String  USERNAME = System.getProperty("username");
	System.out.println(USERNAME);
	String  PASSWORD = System.getProperty("password");
	System.out.println(PASSWORD);
	String  URL = System.getProperty("url");
	System.out.println(URL);
	System.out.println("........");
	
	
	}

}
