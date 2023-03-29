package practice;

import java.io.IOException;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.propertyfileutility;

public class genericproperty {

	public static void main(String[] args) throws IOException {
		
propertyfileutility pro = new propertyfileutility();
String url=pro.readDataFromPropertyFile("url");
System.out.println(url);
ExcelFileUtility eutil = new ExcelFileUtility();
String value=eutil.readDataFromExcel("organisation", 1, 2);
System.out.println(value);
System.out.println(eutil.getRowCount("contacts"));
eutil.writeDataIntoExcel("contacts", 4, 5, value);


	}

}
