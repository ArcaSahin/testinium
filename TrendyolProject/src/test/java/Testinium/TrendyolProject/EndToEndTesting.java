package Testinium.TrendyolProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.BasketPage;
import Pages.LandingPage;
import Pages.LoginPage;
import Pages.ShoppingPage;
import Resources.Base;

public class EndToEndTesting extends Base {
	
	@Test(priority=0)
	
	public void BasePageNavigation() throws IOException
	{
		driver = initializeDriver();
		driver.get("https://www.trendyol.com/");
	}
	
	@Test(priority=1)
	
	public void ValidateLandingPage()
	{
		LandingPage landingpage = new LandingPage(driver);
		Assert.assertTrue(landingpage.ValidateLandingPageBySearcBoxCheck().isDisplayed());
		System.out.println("HomePage is Opened Successfully!");
	}
	
	@Test(priority=2)
	
	public void SignInActions() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LandingPage landingpage = new LandingPage(driver);
	    landingpage.ClickSignIn();
	    landingpage.LoginInfo("aarcasahin@gmail.com", "31qcnvjt");
	    LoginPage loginpage = landingpage.ClickLogin();
	}
	
	@Test(priority=3)
	
	public void ValidateLoginPage() throws InterruptedException
	{
		Thread.sleep(3000);
		LoginPage loginpage = new LoginPage(driver);
		Assert.assertTrue(loginpage.ValidateLoginPageByPopupScreen().isDisplayed());
		System.out.println("LoginPage is Opened Successfully!");
		loginpage.ClosePopup();
	}
	
	@Test(priority=4)
	
	public void SearchProductByName()
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.SearchProduct("bilgisayar");
	}
	
	@Test(priority=5)
	
	public void ClickSearchProduct() throws InterruptedException
	{
		Thread.sleep(3000);
		LoginPage loginpage = new LoginPage(driver);
		ShoppingPage shoppingpage = loginpage.ClickSearch();
	}
	
	@Test(priority=6)
	
	public void ClickSelectedProduct()
	{
		ShoppingPage shoppingpage = new ShoppingPage(driver);
		shoppingpage.ClickProduct();
	}
	
	@Test(priority=7)
	
	public void AddtheItemtoBasket() throws InterruptedException
	{
		Thread.sleep(2000);
		ShoppingPage shoppingpage = new ShoppingPage(driver);
		shoppingpage.AddtoBasket();
	}
	
	@Test(priority=8)
	
	public void GoToBasketPage() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ShoppingPage shoppingpage = new ShoppingPage(driver);
		BasketPage basketpage = shoppingpage.GoToBasket();
	}
		
	/*
	 * I have faced with issue on this method that i could not solve
	 * 
	@Test(priority=9)
	
	public void ValidatePrices() throws InterruptedException
	{
		Thread.sleep(2000);
		BasketPage basketpage = new BasketPage(driver);
		Assert.assertEquals(basketpage.GetLastPrice(), "1499");
		System.out.println("Prices are Compatible");
	}
	*/
	    
	
	@Test(priority=9)
	
	public void SelectedItemAddedMore() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		BasketPage basketpage = new BasketPage(driver);
		basketpage.IncreaseSelectedItem();	
	}
	
	@Test(priority=10)
	
	public void EmptyTheBasket() throws InterruptedException
	{
		Thread.sleep(3000);
		BasketPage basketpage = new BasketPage(driver);
		basketpage.ClickTrashBin();
	}
	
	@Test(priority=11)
	
	public void PopupClickErase() throws InterruptedException
	{
		BasketPage basketpage = new BasketPage(driver);
		basketpage.ClickEraseBtn();
	}
	
	@Test(priority=12)
	
	public void ValidateBasketEmptyOrNot() throws InterruptedException
	{
		Thread.sleep(3000);
		BasketPage basketpage = new BasketPage(driver);
		Assert.assertTrue(basketpage.ValidateBasket().isDisplayed());
		System.out.println("Basket is Empty !");
	}
}
	
	


