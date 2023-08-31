package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import settings.Browsers;
import settings.Customwait;

public class _05_Post_thread_reply_option_Profiles_you_follow {

	By notification = By.xpath("//*[contains(text(),'limited replies ')]");

	WebDriver driver;
	Browsers browser = new Browsers();

	@Test
	public void test() {

		driver = browser.selectBrowser("Chrome");

		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		Customwait wait = new Customwait(driver);
		SearchPage search = new SearchPage(driver);

		login.user1();

//Adding chars to the thread and choosing reply options to profiles you follow
		String content_chars = "Testing for profiles you follow";

		home.newThread();
		home.threadCont(content_chars);

//Choosing 'Profiles you follow' can reply option
		home.threadReplyProfilesYouFollow();
		home.post();
		// Thread.sleep(5000);
		home.logout();

//Random non-follower user attempting to reply on thread of first user
		login.user2();

		home.searchBtn();
		String username = "thread95057";
		search.searchBar(username);
		search.selectAccount(0);
		search.selectThread(content_chars);
		search.replyThread();

		wait.pause(notification);

//Verifying if error message is successfully 
		String actual = driver.findElement(notification).getText();
		String expected = username + " limited replies on this post.";
		Assert.assertEquals(actual, expected);

	
		driver.quit();

	}
}
