package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException
	{
		Properties prob = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\TrendyolProject\\src\\main\\java\\Resources\\data.properties");
		
		prob.load(fis);
		String browserName = prob.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.trendyol.com/");
			driver.manage().window().maximize();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
