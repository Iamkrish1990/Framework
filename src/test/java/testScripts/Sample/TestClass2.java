package testScripts.Sample;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Guice;
//import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import base.SeleniumTestParameters;
import base.SelenuimParameterBuilders;
import base.TestBase;
import parameters.TestCases;


public class TestClass2 extends TestBase{
	
	@Test(dataProvider="WebBrowsers", dataProviderClass=TestBase.class)
	public void testRunner(SeleniumTestParameters testParameters)
	{
		
		initializeDriver();
		//getTestCaseName(currentMethod);
		
	}
	
	

}
