package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage {

	public WebDriver driver;
	
	@FindBy(xpath="//img[@alt='Huawei MediaPad T5 32GB 10.1\" Tablet Siyah']")
	WebElement selectedProduct;
	
	@FindBy(className="add-to-bs-tx")
	WebElement addToBasket_btn;
	
	@FindBy(linkText="Sepete Git")
	WebElement gotoBasket_btn;
	
	
	public ShoppingPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);     
	}
	
	public ShoppingPage ClickProduct()
	{
		selectedProduct.click();
		return this;
	}
	
	public ShoppingPage AddtoBasket()
	{
		addToBasket_btn.click();
		return this;
	}
	
	public BasketPage GoToBasket()
	{
		BasketPage basketpage = new BasketPage(driver);
		gotoBasket_btn.click();
		return basketpage;
	}

}
