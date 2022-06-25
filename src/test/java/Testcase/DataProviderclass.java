package Testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utils.ExcelfileRead;

public class DataProviderclass {

	@DataProvider(name="FBlogindata")
	public Object[][] logindata() throws IOException
	{
		ExcelfileRead e = new ExcelfileRead();
		return e.ExcelReaddata("Inputfile.xls", "FBLogin");
	}
}
