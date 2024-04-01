package PageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import BaseClass.BaseObject;

public class Bikes extends BaseObject{
	
	public static String MainWindowPage;
	
	 public Bikes(WebDriver driver) {
		super(driver);
	}
	 
	 @FindBy(xpath = "//a[normalize-space()='New Bikes']")
	 WebElement newbikes;
	 
	 @FindBy(xpath = "//span[@onclick=\"goToUrl('/upcoming-bikes')\"]")
	 WebElement honda;
	 
	 @FindBy(xpath = "//select[@id='makeId']")
	 WebElement manufactures;
	 
	 @FindBy(xpath = "//span[@class='fnt-12 b rmec jr-m c-p']")
	 WebElement read;
	 
	 @FindBy(xpath  = "//*[table]")
	 WebElement table;
	 

	 public void bikes()
	 {
		 Actions action = new Actions(driver);
		 action.moveToElement(newbikes).perform();
	 }
	 
	 public void clickHonda()
	 {
		 honda.click();
	 }
	 
	 public void clickManufactures()
	 {
		 Select sc=new Select(manufactures);
		 sc.selectByVisibleText("Honda");
	 }
	 
	 public void readmore()
	 {
		 read.click();
	     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", table);

	 }
	
	 public void table() {
		    WebElement var = table;
		    List<WebElement> rows = var.findElements(By.tagName("tr"));
		    
		    System.out.println(String.format("%-20s %-15s %-20s", "Model", "Expected Price", "Expected Launch Date"));
		    System.out.println();

		    for (WebElement row : rows) {
		        List<WebElement> cells = row.findElements(By.tagName("td"));

		        // Check that the row has at least 3 cells
		        if (cells.size() < 3) {
		            continue;
		        }

		        String priceText = cells.get(1).getText().replace("Rs.", "").replace(",", "").trim();
		        double priceInLakhs;
		        if (priceText.contains("Lakh")) {
		            priceInLakhs = Double.parseDouble(priceText.replace("Lakh", "").trim());
		        } else {
		            priceInLakhs = Double.parseDouble(priceText) / 100000;
		        }

		        if (priceInLakhs < 4) {
		        	 System.out.println(String.format("%-20s %-15s %-20s", cells.get(0).getText(), cells.get(1).getText(), cells.get(2).getText()));

		        }
		    }
		    System.out.println();
		}

}
	 
		

