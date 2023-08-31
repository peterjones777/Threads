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

public class _08_Delete_thread_reply {

	By notification = By.xpath("//a[contains(text(),'View')]//parent::div");
	By like = By.xpath("(//*[@aria-label='Like'])[2]");

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

		login.user1();

//Adding  characters to the new thread
		String content_chars = "Deleting this thread reply";
		home.newThread();
		home.threadCont(content_chars);
		home.post();

		wait.pause(notification);

		driver.findElement(notification).click();

//Adding replies to thread
		reply.replyThread();
		reply.replyContent("Delete this now");
		reply.post();

		wait.pause(notification);

		driver.findElement(notification).click();

//Deleting thread reply

		profile.deleteReply();

//Verifying if thread reply is deleted
		Boolean actual = driver.findElement(like).isDisplayed();
		Boolean expected = false;

		Assert.assertEquals(actual, expected);

		

		driver.quit();

	}
}
