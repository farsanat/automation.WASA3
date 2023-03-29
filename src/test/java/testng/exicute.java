package testng;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class exicute {
	
	@Test()
	public void create()
	{
		System.out.println("created");
		AssertJUnit.fail();
	}
	@Test(dependsOnMethods ={"create","updated"})
public void delete()
{
	System.out.println("deleted");
}
	@Test(dependsOnMethods ="create")
public void updated()
{
	System.out.println("updated");
}
}
