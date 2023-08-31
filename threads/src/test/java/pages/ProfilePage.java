package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import settings.Customwait;

public class ProfilePage {
	By like=By.xpath("(//*[@aria-label='Like']//parent::div)[2]");
	By threeDotOption=By.xpath("(//*[@aria-label='More']//parent::div)[4]");
	By deleteOption=By.xpath("//*[text()='Delete']//parent::div");
	By repostOption=By.xpath("(//*[@aria-label='Repost']//parent::div)[2]");
	By repost=By.xpath("(//*[@aria-label='Repost']//parent::div)[3]");
	
	WebDriver driver;
	Customwait wait;

		public ProfilePage(WebDriver driver) {
			this.driver=driver;
			wait = new Customwait(driver);
		}
		
		public void likeReply() {
			try {
				Thread.sleep(2000);
				driver.navigate().refresh();
				Thread.sleep(4000);
				wait.pause(like);
				driver.findElement(like).click();
				Thread.sleep(2000);
			}
			catch(Exception e) {
				System.out.println("retrying");
				driver.findElement(like).click();
			}
		
			
		}
		
		public void deleteReply() {
			try {
				Thread.sleep(6000);
				driver.navigate().refresh();
				Thread.sleep(5000);
				wait.pause(threeDotOption);
				driver.findElement(threeDotOption).click();
				wait.pause(deleteOption);
				driver.findElement(deleteOption).click();
				wait.pause(deleteOption);
				driver.findElement(deleteOption).click();
				
			}
			catch(Exception e) {
				System.out.println("retrying");
				driver.findElement(threeDotOption).click();
				wait.pause(deleteOption);
				driver.findElement(deleteOption).click();
				wait.pause(deleteOption);
				driver.findElement(deleteOption).click();
			}
					
			
		}
		public void repostReply() {
			try {
				Thread.sleep(6000);
				driver.navigate().refresh();
				Thread.sleep(5000);
				wait.pause(repostOption);
				driver.findElement(repostOption).click();	
				wait.pause(repost);
				driver.findElement(repost).click();	
			}
			catch(Exception e) {
				System.out.println("retrying");
				driver.findElement(repostOption).click();
				wait.pause(repost);
				driver.findElement(repost).click();	
			}
			
		}
}
