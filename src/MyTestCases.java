import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends Parameters {

	@BeforeTest
	public void mySetup() {

		MySetupToEnterTheWebsite();

	}

	@Test(priority = 1)
	public void CheckTheEnglishLanguageIsDefault() {

		String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");

		Assert.assertEquals(ActualLanguage, ExpectedLanguage);

	

	}

	@Test(priority = 2)
	public void CheckTheDefaultCurrncyIsSAR() {

		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();

		Assert.assertEquals(ActualCurrency, ExpectedCurrency);

		

	}

	@Test(priority = 3)
	public void CheckContactNumber() {

		String ActualcontactNum = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();

		Assert.assertEquals(ActualcontactNum, ExpectedcontactNum);

	}

	@Test(priority = 4)
	public void CheckQitafLogoIsThereInTheFoter() {

		WebElement Thefooter = driver.findElement(By.tagName("footer"));
		boolean ActualResult = Thefooter.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ciodno.lkfeIG"))
				.isDisplayed();

		Assert.assertEquals(ActualResult, ExpectedResultForQitafLogo);

	}

	@Test(priority = 5)
	public void CheckHotelTabIsNotSelected() {

		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualValue = HotelTab.getAttribute("aria-selected");

		Assert.assertEquals(ActualValue, ExpectedValue);
	}

	@Test(priority = 6)
	public void CheckDepatureDate() {

		String ActualDepature = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']"))
				.getText();
		Assert.assertEquals(ActualDepature, ExpectedDepature);

	}

	@Test(priority = 7)
	public void CheckReturnDate() {

		String ActualReturn = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']"))
				.getText();
		Assert.assertEquals(ActualReturn, ExpectedReturn);

	}

	@Test(priority = 8)
	public void RandomlyChangeTheLanguage() throws InterruptedException {

		randomlyEnterTheWebsite();

		WebElement HotelSearchBar = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));

		CheckTheWebsiteLanguageToEnterTheCityName(HotelSearchBar);

		EnterNumberOfVistorsAfterClickOnTheFirstCity();

	}

	@Test(priority = 9)
	public void CheckThatThePageIsFullyLoaded() {
		WebElement SearchResult = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']"));

		boolean ActualResult = SearchResult.getText().contains("found") || SearchResult.getText().contains("مكان");

		Assert.assertEquals(ActualResult, ExpectedValueForFinshingSearchAboutHotel);

	}

	@Test(priority = 10)
	public void CheckTheSortOption() throws InterruptedException {
		Thread.sleep(15000);

		WebElement SortOptin = driver.findElement(By.xpath("//div[@data-testid='srp_sort_LOWEST_PRICE']"));
		SortOptin.click();

		Thread.sleep(2000);

		SortOptionChecker();
	}
}