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

public class _04_Post_thread_reply_option_Anyone {

	By notification = By.xpath("//*[contains(text(),'Posted')]");

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

//Adding chars to the thread and choosing reply options to anyone
		String content_chars = "Testing for anyone";

		home.newThread();
		home.threadCont(content_chars);

//Choosing 'Anyone' can reply option
		home.threadReplyAnyone();
		home.post();
		home.logout();

//Second random user replying on thread of first user
		login.user2();

		home.searchBtn();
		search.searchBar("thread95057");
		search.selectAccount(0);
		search.selectThread(content_chars);
		search.replyThread();
		search.replyContent("Access to anybody");

		home.post();

		wait.pause(notification);

//Verifying if reply is successfully posted
		String actual = driver.findElement(notification).getText();
		String expected = "Posted";
		Assert.assertEquals(actual, expected);

	

		driver.quit();
	}
}
