package base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Guice;

import io.github.bonigarcia.wdm.WebDriverManager;
import parameters.TestCases;

public class TestBase extends TestCases{
	
	protected static WebDriver driver;
	private String scenario;
	private String testCase;
	
	
	
	public String getTestCase() {
		return testCase;
	}

	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}

	protected TestCases dataTable;
	Properties properties;
	String propertiesFilePath=System.getProperty("user.dir") + "\\src\\test\\Resources\\Config.properties";
	
	public String getScenario()
	{
		return scenario;
	}
	
	public void setScenario(String scenario)
	{
		this.scenario=scenario;
	}
	
	
	
	public TestBase()
	{
		try{
		
		FileReader reader = new FileReader(propertiesFilePath);
		properties = new Properties();
		properties.load(reader);
		
		
		//initializeDriver();
		}
		catch(Exception Ex)
		{
			
		}
		
		
		
	}
	
	public void initializeDriver()
	{
		String browserName ="Chrome";//properties.getProperty("Browser");
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver" , "F:\\CommonTestFrameWork\\Hybrid\\src\\test\\Resources\\chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			driver = new ChromeDriver();
			driver.get("https://www.amazon.com");
		}
		else if(browserName.equals("firefox"))
		{
			
		}
	}
	
	
	@DataProvider(name="WebBrowsers")
	public Object[][] webBrowsers(Method currentMethod)
	{
		String[] curentPackageSplit= currentMethod.getDeclaringClass().getPackage().toString().split("testScripts.");
		currentScenario=curentPackageSplit[1];
		currentTestCase=currentMethod.getDeclaringClass().getSimpleName();
		setScenario(currentScenario);
		setTestCase(currentTestCase);
		Class<?> testScriptClass;
		TestCases testCase;
		try{
			testScriptClass=Class.forName("testScripts." + currentScenario.trim() + "." + currentTestCase.trim());
			testCase=(TestCases) testScriptClass.newInstance();
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return new Object[][]{{new SelenuimParameterBuilders(currentScenario, currentTestCase).testInstance("Instance1").build()}};
		//return returnValue;
	}
	 
	
	
	/*public String getTestCaseName()
	{
		Method currentMethod;
		String[] curentPackageSplit= currentMethod.getDeclaringClass().getPackage().toString().split("testScripts.");
		String scenario = curentPackageSplit[1];
		String testCase=currentMethod.getDeclaringClass().getSimpleName();
		System.out.println(testCase);
		return scenario;
		
	}*/
	
	public void getCurrentInfo(Method currentMethod){
		System.out.println(currentMethod);
		
		String[] curentPackageSplit= currentMethod.getDeclaringClass().getPackage().toString().split("testScripts.");
		
	}
	
}
