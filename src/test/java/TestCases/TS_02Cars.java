package TestCases;

import org.testng.annotations.Test;

import BaseClass.TestBase;
import PageObjects.Cars;

public class TS_02Cars extends TestBase{
	
	@Test(priority = 2)
	public void cars()
	{
		Cars c=new Cars(driver);
		c.usedCars();
		c.clickChennai();
		log.info("Geeting the Popular Models");
		c.models();
	}

}
