package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {

	public WebDriver driver;
	
	@FindBy(className="pb-basket-item-price")
	WebElement lastPrice;
	
	@FindBy(xpath="/html/body/div[3]/div[2]/div[2]/section/section[1]/div[2]/div/div/div[2]/div[2]/div[3]/div[1]/div/button[2]")
	WebElement increase_countBtn;
	
	@FindBy(className="i-trash")
	WebElement emptyBasket_btn;
	
	@FindBy(xpath="/html/body/div[14]/div[2]/form/div/div[2]/div/div[2]/button")
	WebElement click_eraseBtn;
	
	@FindBy(id="basketNoProductPage")
	WebElement checkBasket;
	
	public BasketPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);     
	}
	
	public WebElement GetLastPrice()
	{
		lastPrice.getText();
		return lastPrice;
	}
	
	public BasketPage IncreaseSelectedItem()
	{
		increase_countBtn.click();
		return this;
	}
	
	public BasketPage ClickTrashBin()
	{
		emptyBasket_btn.click();
		return this;
	}
	
	public BasketPage ClickEraseBtn()
	{
		click_eraseBtn.click();
		return this;
	}
	
	public WebElement ValidateBasket()
	{
		return checkBasket;
	}
}
