package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LandingPage {

	public WebDriver driver;
	WebElement element;
	
	@FindBy(className="search-box-container")
	WebElement search_box;
	
	@FindBy(className="login-container")
	WebElement login_button;
	
	@FindBy(id="email")
	WebElement write_email;
	
	@FindBy(id="password")
	WebElement write_password;
	
	@FindBy(id="loginSubmit")
	WebElement click_loginBtn;
	
	
	public LandingPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);     
	}
	
	public WebElement ValidateLandingPageBySearcBoxCheck() 
	{
		return search_box;
	}
	
	public LandingPage ClickSignIn()
	{
		login_button.click();
		return this;
	}
	
	public LandingPage LoginInfo(String email, String password)
	{
		write_email.sendKeys(email);
		write_password.sendKeys(password);
		return this;
	}
	
	public LoginPage ClickLogin()
	{
		LoginPage loginpage = new LoginPage(driver);
		click_loginBtn.click();
		return loginpage;
	}
	

}
