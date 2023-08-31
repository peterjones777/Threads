package settings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Customwait {
	WebDriver driver;
	
	public Customwait(WebDriver driver) {
		this.driver=driver;
	}

public void pause(By xp) {
	
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOfElementLocated(xp));
}

public void pauseUntilElementInvisible(By xp) {
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.invisibilityOfElementLocated(xp));
	
}
}
