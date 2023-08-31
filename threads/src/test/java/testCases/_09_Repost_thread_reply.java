package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.SearchPage;
import settings.Browsers;
import settings.Customwait;

public class _09_Repost_thread_reply {

	By notification = By.xpath("//a[contains(text(),'View')]//parent::div");
	By repostNotif = By.xpath("(//*[contains(text(),'Reposted')])");

	WebDriver driver;
	Browsers browser = new Browsers();

	@Test
	public void test() {

		driver = browser.selectBrowser("Chrome");

		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		Customwait wait = new Customwait(driver);
		SearchPage reply = new SearchPage(driver);
		ProfilePage profile = new ProfilePage(driver);

		login.user2();

// Adding characters to the new thread
		String content_chars = "Reposting this thread reply";
		home.newThread();
		home.threadCont(content_chars);
		home.post();

		wait.pause(notification);

		driver.findElement(notification).click();

// Adding replies to thread
		reply.replyThread();
		reply.replyContent("Repost me");
		reply.post();

		wait.pause(notification);

		driver.findElement(notification).click();
// Reposting reply
		profile.repostReply();

// Verify reply has been reposted
		wait.pause(repostNotif);
		String actual = driver.findElement(repostNotif).getText();
		String expected = "Reposted";

		Assert.assertEquals(actual, expected);
		
	
		driver.quit();
	}
}
