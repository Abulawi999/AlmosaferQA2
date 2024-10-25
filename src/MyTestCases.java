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
//	String WebsiteURL = "https://global.almosafer.com/ar";

	@BeforeTest
	public void mySetup() {
		driver.manage().window().maximize();
		driver.get(WebsiteURL);

		WebElement ButtonForTheCurrency = driver
				.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		ButtonForTheCurrency.click();

//		WebElement ButtonForTheCurrencyAr = driver.findElement(By.cssSelector(".sc-jTzLTM.eJkYKb.cta__button.cta__saudi.btn.btn-primary"));
//		ButtonForTheCurrencyAr.click();

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

//		String ActualCurrency = driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO")).getText();
//		String ExpectedCurrency = "SAR";

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
	
	

}
