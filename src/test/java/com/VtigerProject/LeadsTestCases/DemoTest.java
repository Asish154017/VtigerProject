package com.VtigerProject.LeadsTestCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoTest {
	
	@Test
	public void start()
	{
		Reporter.log("Started",true);
	}

	@Test
	public void stop()
	{
		Reporter.log("Stoped",true);
	}
	@Test
	public void run()
	{
		Reporter.log("Run",true);
	}
	
	
	
	
	
}
