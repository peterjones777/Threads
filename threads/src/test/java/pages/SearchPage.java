package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import settings.Customwait;

public class SearchPage {

	By searchBar = By.xpath("//input[@placeholder=\"Search\"]");
	By searchList = By.xpath("//ul/li[contains(@aria-selected,'false')]");
	By reply = By.xpath("//*[@aria-label='Comment']//parent::div");
	By typeThread = By.xpath("//*[contains(text(),'can reply')]//preceding::p");
	By post_Btn = By.xpath("(//input//following::*[contains(text(),'Post')]//parent::div)[1]");

	WebDriver driver;
	Customwait wait;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		wait = new Customwait(driver);
	}

	public void searchBar(String content) {
		wait.pause(searchBar);
		driver.findElement(searchBar).sendKeys(content);
		wait.pause(searchList);

	}

	public void selectAccount(int n) {
		List<WebElement> li = driver.findElements(searchList);
		li.get(n).click();
	}

	public void selectThread(String th) {
		String selectTh = "//*[contains(text(),'" + th + "')]";
		wait.pause(By.xpath(selectTh));
		driver.findElement(By.xpath(selectTh)).click();
		
		
	}

	public void replyThread() {
		
			try {
		
				Thread.sleep(7000);
				driver.navigate().refresh();
				wait.pause(reply);
				driver.findElement(reply).click();
			}
			catch(Exception e) {
				System.out.println("reply thread blockfailed");
				
				
			}
	

	
		

	}

	public void replyContent(String content) {

		wait.pause(typeThread);
		driver.findElement(typeThread).sendKeys(content);

	}

	public void post() {
		wait.pause(post_Btn);
		driver.findElement(post_Btn).click();
	}
}
