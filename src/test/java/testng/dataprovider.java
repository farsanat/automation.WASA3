package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {
	@Test(dataProvider="phone")
	public void addproduct(String name,int value)
	{
		System.out.println(name+"   "+value);
	}
	@DataProvider(name="phone")
	public Object[][] getdata()
	{
		Object[][] data=new Object[3][2];
		data[0][0]="samsung";
		data[0][1]=1000;
		data[1][0]="iphone";
		data[1][1]=2000;
		data[2][0]="nokia";
		data[2][1]=500;
		return data;
	}

}
