package base;

public class TestParameter {
	
	private final String currentScenario;
	private final String currentTestCase;
	private String currentTestInstance;
	
	public TestParameter(String currentScenario, String currentTestCase) {
		this.currentScenario = currentScenario;
		this.currentTestCase = currentTestCase;
		this.currentTestInstance="Instance1";
	}
	
	public String getCurrentScenario() {
		return currentScenario;
	}

	public String getCurrentTestCase() {
		return currentTestCase;
	}
	
	
	public String getCurrentTestInstance()
	{
		return currentTestInstance;
	}

	public void setCurrentTestInstance(String currentTestInstance)
	{
		this.currentTestInstance=currentTestInstance;
	}

}
