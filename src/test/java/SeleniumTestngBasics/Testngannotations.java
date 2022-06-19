package SeleniumTestngBasics;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;

public class Testngannotations 
{

@BeforeSuite(alwaysRun=true)
public void beforesuite()
{
	System.out.println("beforesuite");
}

@AfterSuite(alwaysRun=true)
public void aftersuite()
{
	System.out.println("aftersuite");
}

@BeforeTest
public void beforeTest()
{
	System.out.println("beforeTest");
}

@AfterTest
public void AfterTest()
{
	System.out.println("AfterTest");
}

@BeforeClass
public void beforeclass()
{
	System.out.println("beforeclass");
}

@AfterClass
public void afterclass()
{
	System.out.println("afterclass");
}

@BeforeMethod(alwaysRun=true)
public void beforemethod()
{
	System.out.println("beforemethod");
}

@AfterMethod(alwaysRun=true)
public void aftermethod()
{
	System.out.println("aftermethod");
}

@Test(priority=2,groups={"Sanity","SIT"})
public void Testcase1()
{
	System.out.println("Testcase1");
	//throw new ArithmeticException("our error");
}

@Test(priority=1,invocationCount=2,invocationTimeOut=60,timeOut=60,groups="Sanity",enabled=true)
public void Testcase3()
{
	System.out.println("Testcase3");
}

@Test(priority=0,dependsOnMethods="Testcase1",groups="Sanity")
public void Testcase2()
{
	System.out.println("Testcase2");
}

}
