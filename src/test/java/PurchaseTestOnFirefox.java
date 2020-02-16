import static Configuration.CommonMethods.waitUntilPageLoad;
import static Configuration.Variables.Data.ADDRESS_LINE1_LABEL;
import static Configuration.Variables.Data.ADDRESS_LINE2_LABEL;
import static Configuration.Variables.Data.ADD_TO_BASKET;
import static Configuration.Variables.Data.BEACH_BAG;
import static Configuration.Variables.Data.CONTINUE_TO_ADDRESS_AND_DELIVERY;
import static Configuration.Variables.Data.CONTINUE_TO_PAYMENT_TYPE;
import static Configuration.Variables.Data.CONTINUE_TO_VERIFICATION;
import static Configuration.Variables.Data.COOKIES_BTN;
import static Configuration.Variables.Data.EMAIL;
import static Configuration.Variables.Data.FIRST_NAME_LABEL;
import static Configuration.Variables.Data.GO_TO_SHOPPING_BASKET;
import static Configuration.Variables.Data.GUEST_EMAIL;
import static Configuration.Variables.Data.LAST_NAME_LABEL;
import static Configuration.Variables.Data.MERCEDES_URL;
import static Configuration.Variables.Data.MS_LABEL;
import static Configuration.Variables.Data.PAYPAL;
import static Configuration.Variables.Data.PLACE_ORDER_AS_GUEST;
import static Configuration.Variables.Data.POSTAL_CODE_LABEL;
import static Configuration.Variables.Data.TOWN_LABEL;
import static Configuration.Variables.Data.WOMEN_COLLECTION;
import static Configuration.Variables.Data.YOUR_ORDER_DATA;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class PurchaseTestOnFirefox {
	public static void main(String[] args) throws InterruptedException {
		//Report configuration
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("testReports.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest testFirefox = extent.createTest("PurchaseTestOnFirefox","Execute a purchase action on Mercedez-benz portal");


		System.setProperty("webdriver.gecko.driver","C:\\webdriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//Start test case execution
		testFirefox.log(Status.INFO,"Starting Test Case");
		driver.manage().window().maximize();
		driver.get(MERCEDES_URL);
		testFirefox.pass("Browser was successfully reached");
		waitUntilPageLoad();
		if (driver.findElement(By.xpath(COOKIES_BTN)).isDisplayed()){
			driver.findElement(By.xpath(COOKIES_BTN)).click();
		}
		driver.findElements(By.className(WOMEN_COLLECTION)).get(0).click();
		waitUntilPageLoad();
		testFirefox.pass("Product's list successfully displayed");
		driver.findElement(By.xpath(BEACH_BAG)).click();
		waitUntilPageLoad();
		testFirefox.pass("Beach bag was successfully selected");
		driver.findElement(By.xpath(ADD_TO_BASKET)).click();
		Assert.assertEquals(driver.getTitle(),"Beach bag");
		testFirefox.pass("Beach bag was added to basket, and title validation was successfully executed");
		waitUntilPageLoad();
		driver.findElement(By.xpath(GO_TO_SHOPPING_BASKET)).click();
		waitUntilPageLoad();
		testFirefox.pass("Shopping basket is displayed");
		driver.findElement(By.xpath(CONTINUE_TO_ADDRESS_AND_DELIVERY)).click();
		waitUntilPageLoad();
		driver.findElement(By.cssSelector(GUEST_EMAIL)).sendKeys(EMAIL);
		driver.findElement(By.xpath(PLACE_ORDER_AS_GUEST)).click();
		waitUntilPageLoad();
		driver.findElement(By.xpath(MS_LABEL)).click();
		driver.findElement(By.name(FIRST_NAME_LABEL)).sendKeys("Beatriz");
		driver.findElement(By.name(LAST_NAME_LABEL)).sendKeys("Cunha");
		driver.findElement(By.name(ADDRESS_LINE1_LABEL)).sendKeys("Estrada Serra da Mira");
		driver.findElement(By.name(ADDRESS_LINE2_LABEL)).sendKeys("64");
		driver.findElement(By.name(POSTAL_CODE_LABEL)).sendKeys("SP2 0FL");
		driver.findElement(By.name(TOWN_LABEL)).sendKeys("Amadora");
		waitUntilPageLoad();
		driver.findElements(By.xpath(CONTINUE_TO_PAYMENT_TYPE)).get(0).click();
		waitUntilPageLoad();
		driver.findElements(By.xpath(PAYPAL)).get(0).click();
		driver.findElement(By.xpath(CONTINUE_TO_VERIFICATION)).click();
		waitUntilPageLoad();
		Assert.assertEquals(driver.findElement(By.xpath(YOUR_ORDER_DATA)).getText(),"Your order data");

		testFirefox.pass("Purchase flow was executed with success");
		driver.close();
		testFirefox.pass("Close the browser");
		testFirefox.info("Test completed");

		extent.flush();


	}
}