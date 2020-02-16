import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PurchaseTestOnChrome {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://shop.mercedes-benz.com/en-gb/collection/");
		Thread.sleep(3000);
		//Accept cookies
		if (driver.findElement(By.xpath("//*[@id='layer-text']/p[4]/button")).isDisplayed()){
			driver.findElement(By.xpath("//*[@id='layer-text']/p[4]/button")).click();
		}
		driver.findElements(By.className("utils-content-carousel-container-tile-image")).get(0).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[contains(text(),'Beach bag')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[contains(text(),' Add to basket')]")).click();
		Assert.assertEquals(driver.getTitle(),"Beach bag");

		//validaçoes
		//ver melhor os threads
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(text(),' Go to shopping basket')]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(text(),'Continue to address and delivery')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("input#dcp-login-guest-user-email")).sendKeys("mbfcunha@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Place order as guest')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[contains(text(),'Ms')]")).click();
		driver.findElement(By.name("co_payment_address-firstName")).sendKeys("Beatriz");
		driver.findElement(By.name("co_payment_address-lastName")).sendKeys("Cunha");
		driver.findElement(By.name("co_payment_address-line1")).sendKeys("Estrada Serra da Mira");
		driver.findElement(By.name("co_payment_address-line2")).sendKeys("64");
		driver.findElement(By.name("co_payment_address-postalCode")).sendKeys("SP2 0FL");
		driver.findElement(By.name("co_payment_address-town")).sendKeys("Amadora");
		Thread.sleep(2000);
		driver.findElements(By.xpath("//button[contains(text(),'Continue to payment type')]")).get(0).click();

		Thread.sleep(10000);
		driver.findElements(By.xpath("//*[contains(text(),'PayPal')]")).get(0).click();
		driver.findElement(By.xpath("//button[contains(text(),'Continue to verification and order placement')]")).click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Your order data')]")).getText(),"Your order data");


		driver.close();



	}
}
