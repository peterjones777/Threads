package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import settings.Customwait;

public class HomePage {

	By startThread = By.xpath("//*[contains(text(),'thread..')]");
	By typeThread = By.xpath("//*[contains(text(),'Anyone ')]//preceding::p");
	By typeThread2 = By.xpath("//*[contains(text(),'Anyone ')]//preceding::p//parent::div");
	By post_Btn = By.xpath("(//input//following::*[contains(text(),'Post')]//parent::div)[1]");
	By post_Btn_disabled=By.xpath("(//*[contains(text(),'Post')]//parent::div)[1]");
	By replyOptions=By.xpath("(//*[contains(text(),'can reply')]//parent::*)[1]");
	By anyoneOption=By.xpath("//*[text()=\"Anyone\"]//ancestor::*[@role='button']");
	By profilesYouFollowOption=By.xpath("//*[text()='Profiles you follow']//ancestor::*[@role='button']");
	By mentionedOnlyOption=By.xpath("//*[text()=\"Mentioned only\"]//ancestor::*[@role='button']");
	By moreOption=By.xpath("((//*[@aria-label='More']//parent::div)[1]//parent::div)[1]");
	By moreOption2=By.xpath("(//*[@aria-label='More']//parent::div)[2]");
	By logout= By.xpath("(//*[contains(text(),'Log out')]//parent::*)[1]");
	By searchBtn=By.xpath("(//a[@href='/search/']//parent::div)[1]");
	By profileBtn=By.xpath("(//a[contains(@href,'/@')]//parent::div)[1]");

	WebDriver driver;
	Customwait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new Customwait(driver);
	}
	
	public void searchBtn() {
		wait.pause(searchBtn);
		driver.findElement(searchBtn).click();
	}
	
	public void profileBtn() {
		wait.pause(profileBtn);
		driver.findElement(profileBtn).click();
	}

	public void newThread() {

		wait.pause(startThread);
		driver.findElement(startThread).click();
	}
	
	public void threadCont(String content) {
		wait.pause(typeThread2);
		driver.findElement(typeThread2).sendKeys(content);
		
	}
	public void threadCont(Keys content) {
		wait.pause(typeThread);

		driver.findElement(typeThread).sendKeys(content);
		
	}
	
	public void threadReplyAnyone() {
		driver.findElement(replyOptions).click();
		wait.pause(anyoneOption);
		driver.findElement(anyoneOption).click();
	}
	
	public void threadReplyProfilesYouFollow() {
		driver.findElement(replyOptions).click();
		wait.pause(profilesYouFollowOption);
		driver.findElement(profilesYouFollowOption).click();
	}
	
	public void threadReplyMentionedOnly() {
		driver.findElement(replyOptions).click();
		wait.pause(mentionedOnlyOption);
		driver.findElement(mentionedOnlyOption).click();
	}
	
	public void post() {
		wait.pause(post_Btn);
		driver.findElement(post_Btn).click();
	}
	
	public void logout() {
		
		
		try {
			wait.pauseUntilElementInvisible(replyOptions);
			Thread.sleep(3000);
			wait.pause(moreOption);
		driver.findElement(moreOption).click();
		
		}
		catch(Exception e) {
			
			driver.findElement(moreOption).click();
		}
		
		wait.pause(logout);
		
		driver.findElement(logout).click();
	}
}
