package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.TestBase;
import PageObjects.SignUp;

public class TS_03SignUp extends TestBase{
	
	SignUp s;
	
	@Test(priority = 3)
	public void signup()
	{
		 s=new SignUp(driver);
		s.login();
		log.info("Getting into the Login");
		s.google();
		log.info("Redirect into the google Window");
		s.getEmail();
		s.next();
		
	}
	
	@Test(priority = 4)
	public void validate()
	{
		Assert.assertEquals(true, s.error());
	}

}
