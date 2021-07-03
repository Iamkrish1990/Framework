package base;

public class SelenuimParameterBuilders {
	
	private final SeleniumTestParameters testParameters;
	
	public SelenuimParameterBuilders(String currentScenario,String currentTestCase)
	{
		this.testParameters=new SeleniumTestParameters(currentScenario, currentTestCase);
	}
	
	public SelenuimParameterBuilders testInstance(String testInstance)
	{
		this.testParameters.setCurrentTestInstance(testInstance);
		return this;
	}

	
	public SeleniumTestParameters build()
	{
		return this.testParameters;
	}
}
