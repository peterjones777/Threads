package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import settings.Browsers;
import settings.Customwait;

public class _01_Post_thread_500_characters {

	By notification = By.xpath("//*[contains(text(),'Posted')]");

	WebDriver driver;
	Browsers browser = new Browsers();

	@Test
	public void test() {

		driver = browser.selectBrowser("Chrome");  //Assign Browser Chrome or Edge

		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		Customwait wait = new Customwait(driver);

		login.user2(); //Assign user1 or user 2

//Adding 500 chars to the thread
		String content_500_chars = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibu";
		home.newThread();
		home.threadCont(content_500_chars);
		home.post();

		wait.pause(notification);
//Verifying if content is successfully posted
		String actual = driver.findElement(notification).getText();
		String expected = "Posted";
		Assert.assertEquals(actual, expected);

	

		driver.quit();
	}

}
