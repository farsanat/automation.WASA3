package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertyprogram {

	public static void main(String[] args) throws IOException {
		  FileInputStream fls = new FileInputStream("./src/test/resources/commom data.properties");
		    Properties pobj = new Properties();
		    pobj.load(fls);
		    Object URL = pobj.getProperty("url");
		   Object USERNAME = pobj.getProperty("username");
		   String BROWSER = pobj.getProperty("browser");
		   String PASSWORD = pobj.getProperty("password");
		    System.out.println(URL);
		    
		    System.out.println(USERNAME);
		    System.out.println(BROWSER);
		    System.out.println(PASSWORD );
		   
		    
	}

}
