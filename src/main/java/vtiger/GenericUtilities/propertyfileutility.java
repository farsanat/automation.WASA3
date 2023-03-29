package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * this class consists of generic method to read data from property file
 * @author farsana
 *
 */

public class propertyfileutility {
	/**
	 * this method read data from propertyfile
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fls = new FileInputStream("./src/test/resources/commom data.properties");
	    Properties pobj = new Properties();
	    pobj.load(fls);
	    String value=pobj.getProperty(key);
		return value;
	}
	

}
