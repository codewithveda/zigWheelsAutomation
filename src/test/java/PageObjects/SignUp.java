package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BaseClass.BaseObject;

public class SignUp extends BaseObject{
	
	 public SignUp(WebDriver driver) {
		super(driver);
	}
  
	 @FindBy(id = "forum_login_wrap_lg")
	 WebElement btn_login;
	 
	 @FindBy(xpath  = "/html/body/div[12]/div/div/div/div[1]/div/div[3]/div[6]/div")
	 WebElement btn_google;
	 
	 @FindBy(id  = "identifierId")
	 WebElement txt_email;
	 
	 @FindBy(xpath  = "//span[normalize-space()='Next']")
	 WebElement btn_next;
	 
	 @FindBy(xpath  = "//div[@class='Ekjuhf Jj6Lae']")
	 WebElement error;


	 public void login()
	 {
		 btn_login.click();
	 }
	 
	 
	public void google()
	 {
		 btn_google.click();
	 }
	 
		public void getEmail()  
		{
            for (String windowHandle : driver.getWindowHandles())
            {
                driver.switchTo().window(windowHandle);
            }

            txt_email.sendKeys("invalid-email@example.com");
		}

		public void next()
		{
			btn_next.click();
		}
		
		public boolean error()
		{
			boolean act=error.isDisplayed();
			return act;
		}
}
