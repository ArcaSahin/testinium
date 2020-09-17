package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	@FindBy(className="modal-close")
	WebElement close_popup;
	
	@FindBy(className="notification-popup-container")
	WebElement notification_popupBar;
	
	@FindBy(className="search-box")
	WebElement search_box;
	
	@FindBy(className="search-icon")
	WebElement click_searchProduct;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);     
	}
	
	public WebElement ClosePopup()
	{
		close_popup.click();
		return close_popup;
	}
	
	public WebElement ValidateLoginPageByPopupScreen()
	{
		return notification_popupBar;
	}
	
	public LoginPage SearchProduct(String productName)
	{
		search_box.sendKeys(productName);
		return this;
	}
	
	public ShoppingPage ClickSearch()
	{
		ShoppingPage shoppingpage = new ShoppingPage(driver);
		click_searchProduct.click();
		return shoppingpage;
	}
	
}
