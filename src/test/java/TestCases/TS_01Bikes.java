package TestCases;

import org.testng.annotations.Test;

import BaseClass.TestBase;
import PageObjects.Bikes;

public class TS_01Bikes extends TestBase{
	
	
	@Test(priority = 1)
	public void bike()
	{
		Bikes b=new Bikes(driver);
		b.bikes();
		b.clickHonda();
		b.clickManufactures();
		b.readmore();
		log.info("Getting the Table Information ");
		b.table();
	}

}

