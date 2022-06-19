package SeleniumTestngBasics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

public class SecondpageforTestng 
{

	@BeforeClass
	public void beforeclass()
	{
		System.out.println("beforeclass in second class");
	}

	@AfterClass
	public void afterclass()
	{
		System.out.println("afterclass in second class");
	}
	
	@Test(groups="SIT")
	public void Testcase2()
	{
		System.out.println("Test case 2 in second class");
		
	}
}
