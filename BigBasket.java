package selenium.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasket {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./drivers3/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//input[@value='Change Location']").click();
		driver.findElementByXPath("//span[@class='btn btn-default form-control ui-select-toggle']").click();
		driver.findElementByXPath("//span[text()='Chennai']").click();
		driver.findElementByXPath("//button[text()='Continue']").click();
		WebElement category = driver.findElementByXPath("//a[@qa='categoryDD']");
		Actions act=new Actions(driver);
		act.moveToElement(category).build().perform();
		Thread.sleep(5000);
		WebElement food = driver.findElementByXPath("(//a[text()='Foodgrains, Oil & Masala'])[2]");
		act.moveToElement(food).build().perform();
		
	}

}
