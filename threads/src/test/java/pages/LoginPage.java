package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.Customwait;

public class LoginPage {

	By username = By.xpath("//input[@autocomplete='username']");
	By password = By.xpath("//input[@autocomplete='current-password']");
	By login_Btn = By.xpath("(//*[contains(text(),'Log in')])[2]");

	WebDriver driver;
	Customwait wait;

	public LoginPage(WebDriver driver) {
	this.driver=driver;
	wait = new Customwait(driver);
	
	driver.get("https://www.threads.net/");
	driver.manage().window().maximize();
	}



	public void user1() {

		

		wait.pause(username);
		driver.findElement(username).sendKeys("thread95057");
		driver.findElement(password).sendKeys("Newspaper123*");
		driver.findElement(login_Btn).click();

	}

	public void user2()  {
	

		wait.pause(login_Btn);
		driver.findElement(username).sendKeys("racoonsun");
		driver.findElement(password).sendKeys("universe500*");
		driver.findElement(login_Btn).click();

	}
}
