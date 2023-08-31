package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsers {
	WebDriver driver;

	public WebDriver selectBrowser(String brow)
	{
		if (brow.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		} 
		
		else if (brow.equalsIgnoreCase("Edge")) 
		{
			
			WebDriverManager.edgedriver().setup();
			EdgeOptions options=new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
		 
			driver = new EdgeDriver();
		}
		return driver;

	}
}
