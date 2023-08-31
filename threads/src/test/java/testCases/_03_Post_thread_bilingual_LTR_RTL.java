package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import settings.Browsers;

public class _03_Post_thread_bilingual_LTR_RTL {
	By typeThread = By.xpath("//*[contains(text(),'Anyone ')]//preceding::p");

	WebDriver driver;
	Browsers browser = new Browsers();

	@Test
	public void test() {

		driver = browser.selectBrowser("Chrome");

		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);

		login.user1();

//Adding an RTL language Urdu first and then adding English which is a LTR language in a newline

		String content_Urdu = " ب پ ت ٹ ث ج چ ح خ د ڈ ذ ر ڑ ز ژ س ش ص ض ط ظ ع غ ف ق ک گ ل م ن (ں) و ہ (ھ) ء ی ے ب پ ت ٹ ث ج چ ح خ د ڈ ذ ر ڑ ز ژ س ش ص ض ط ظ ع غ ف ق ک گ ل م ن (ں) و ہ (ھ) ء ی ے";
		String content_English = "Hello how are you??";

		home.newThread();
		home.threadCont(content_Urdu);
		home.threadCont(Keys.ENTER);
		home.threadCont(content_English);

//Verifying if direction of language has changed from RTL to LTR when typing in newline in English

		String actual = driver.findElement(By.xpath("//input//preceding::p")).getAttribute("dir");
		String expected = "ltr";

		Assert.assertEquals(actual, expected);



		driver.quit();

	}

}
