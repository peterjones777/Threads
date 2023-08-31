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

public class _07_Like_thread_reply {

	By notification = By.xpath("//a[contains(text(),'View')]//parent::div");
	By unlike = By.xpath("(//*[@aria-label='Unlike'])");

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

//Adding content to the thread
		String content_chars = "Liking a threadreply";
		home.newThread();
		home.threadCont(content_chars);
		home.post();

		wait.pause(notification);

		driver.findElement(notification).click();
//Adding reply to the thread
		reply.replyThread();
		reply.replyContent("Like me");
		reply.post();

		wait.pause(notification);

		driver.findElement(notification).click();

//Liking reply of thread
		String expected = "rgb(255, 48, 64)";
		String actual = "";
		try {
		profile.likeReply();
		
		 actual = driver.findElement(unlike).getAttribute("color");
		}
		catch(Exception e) {
			 actual = driver.findElement(unlike).getAttribute("color");
		}

//Verifying if thread reply is liked
		

		Assert.assertEquals(actual, expected);
	

		driver.quit();

	}
}
