import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	WebDriver driver = new ChromeDriver();
	String WebsiteURL = "https://global.almosafer.com/en";
//	String WebsiteURL = "https://global.almosafer.com/ar"; //just try
	
	Random rand = new Random(); 


	@BeforeTest
	public void mySetup() {
		driver.manage().window().maximize();
		driver.get(WebsiteURL);

		WebElement ButtonForTheCurrency = driver
				.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		ButtonForTheCurrency.click();

//		WebElement ButtonForTheCurrencyAr = driver.findElement(By.cssSelector(".sc-jTzLTM.eJkYKb.cta__button.cta__saudi.btn.btn-primary")); //just try
//		ButtonForTheCurrencyAr.click(); //just try

	}

	@Test(priority = 1)
	public void CheckTheEnglishLanguageIsDefault() {

		String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
		String ExpectedLanguage = "en";

		Assert.assertEquals(ActualLanguage, ExpectedLanguage);

	}

	@Test(priority = 2)
	public void CheckTheDefaultCurrncyIsSAR() {

		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();
		String ExpectedCurrency = "SAR";

//		String ActualCurrency = driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO")).getText(); //just try
//		String ExpectedCurrency = "SAR"; //just try

		Assert.assertEquals(ActualCurrency, ExpectedCurrency);

	}

	@Test(priority = 3)
	public void CheckContactNumber() {

		String ActualcontactNum = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();
		String ExpectedcontactNum = "+966554400000";

		Assert.assertEquals(ActualcontactNum, ExpectedcontactNum);

	}

	@Test(priority = 4)
	public void CheckQitafLogoIsThereInTheFoter() {

		boolean ActualLogo = driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ciodno.lkfeIG")).isDisplayed();
		boolean ExpectedLogo = true;

		Assert.assertEquals(ActualLogo, ExpectedLogo);
	}

	@Test(priority = 5)
	public void CheckHotelTabIsNotSelected() {

		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualValue = HotelTab.getAttribute("aria-selected");
//		String ActualValue = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).getAttribute("aria-selected"); //just try
		String ExpectedValue = "false";

		Assert.assertEquals(ActualValue, ExpectedValue);
	}

	@Test(priority = 6)
	public void CheckDepatureDate() {

		int today = LocalDate.now().getDayOfMonth();
		int Tomorrow = LocalDate.now().plusDays(1).getDayOfMonth();
//		int DayAfterTomorrow = LocalDate.now().plus(2).getDayOfMonth();

//		System.out.println(today);
//		System.out.println(Tomorrow);
//		System.out.println(DayAfterTomorrow);

		String ActualDepature = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']"))
				.getText();
		String ExpectedDepature = Integer.toString(Tomorrow);
		Assert.assertEquals(ActualDepature, ExpectedDepature);

	}
	
	@Test(priority = 7)
	public void CheckreturnDate() {

		int today = LocalDate.now().getDayOfMonth();
//		int Tomorrow = LocalDate.now().plusDays(1).getDayOfMonth();
		int DayAfterTomorrow = LocalDate.now().plusDays(2).getDayOfMonth();

//		System.out.println(today);
//		System.out.println(Tomorrow);
//		System.out.println(DayAfterTomorrow);

		String ActualReturn = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']")).getText();
		String ExpectedReturn = Integer.toString(DayAfterTomorrow);
		Assert.assertEquals(ActualReturn, ExpectedReturn);

	}
	
	@Test(priority = 8)
	public void RandomlyChangeTheLanguage() {
		
		String [] myWebsites = {"https://www.almosafer.com/ar","https://www.almosafer.com/en"};
		
		int randomIndex = rand.nextInt(myWebsites.length);
		
		driver.get(myWebsites[randomIndex]);
		
		if(driver.getCurrentUrl().equals("https://www.almosafer.com/ar")) {
			String ActualLaguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			String ExpectedLanguage = "ar";

			Assert.assertEquals(ActualLaguage, ExpectedLanguage);
		}else {
			String ActualLaguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			String ExpectedLanguage = "en";

			Assert.assertEquals(ActualLaguage, ExpectedLanguage);
		}

	}  
	
	

}
