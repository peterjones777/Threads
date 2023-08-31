package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import settings.Browsers;

public class _02_Post_thread_501_characters {

	By post_Btn = By.xpath("(//input//following::*[contains(text(),'Post')]//parent::div)[1]");

	WebDriver driver;
	Browsers browser = new Browsers();

	@Test
	public void test() {

		driver = browser.selectBrowser("Chrome");

		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);

		login.user1();

//Adding 501 characters to the thread
		String content_501_chars = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibu1";
		home.newThread();
		home.threadCont(content_501_chars);

//Verifying if the post button got disabled
		String actual = driver.findElement(post_Btn).getAttribute("aria-disabled");
		String expected = "true";

		Assert.assertEquals(actual, expected);

		driver.quit();

	}
}
