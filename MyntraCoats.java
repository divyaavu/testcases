package selenium.assignments;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MyntraCoats {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();

		//Add chrome switch to disable notification - "**--disable-notifications**"
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver","./drivers3/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		WebElement womenele = driver.findElement(By.xpath("//a[text()='Women']"));
		act.moveToElement(womenele).build().perform();
		driver.findElementByXPath("//a[text()='Jackets & Coats']").click();
		String titlecount = driver.findElementByXPath("//span[@class='title-count']").getText();
		System.out.println(titlecount);
		String count = titlecount.replaceAll("[^0-9]", "");
		int countint = Integer.parseInt(count);
		System.out.println("The total number of items is "+ countint);
		String Jacketscount = driver.findElementByXPath("//span[@class='categories-num']").getText();
		//System.out.println(Jacketscount);
		String jaccount = Jacketscount.replaceAll("[^0-9]", "");
		int jcount = Integer.parseInt(jaccount);
		System.out.println("The total number of jactets is " + jcount);
		String coatscount = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
		//System.out.println(coatscount);
		String coatcount = coatscount.replaceAll("[^0-9]", "");
		int ccount = Integer.parseInt(coatcount);
		System.out.println("The total number of coats " + ccount);
		int total = jcount+ccount;
		System.out.println(total);
		if(countint==total)
		{
			System.out.println("The count matches");
		}
		else
		{
			System.out.println("Incorrect number of items");
		}
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//div[@class='brand-more']").click();
		driver.findElementByXPath("//input[@placeholder='Search brand']").sendKeys("MANGO");
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[11]").click();
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		List<WebElement> brand = driver.findElements(By.xpath("//h3[text()='MANGO']"));
		List Mango = new ArrayList<>();
		System.out.println(brand.size());
		for(WebElement br:brand)
		{
	     assertEquals(br, "MANGO");
				}
		WebElement sort = driver.findElementByXPath("//div[@class='sort-sortBy']");
		act.moveToElement(sort).build().perform();
		driver.findElementByXPath("//label[text()='Better Discount']").click();
		List<WebElement> mcoat = driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));
		String firstpr = mcoat.get(0).getText();
		System.out.println(firstpr);
		String firstp =firstpr.replaceAll("[^0-9]", "");
		int fp = Integer.parseInt(firstp);
		System.out.println(fp);
		act.moveToElement(mcoat.get(0)).build().perform();
		driver.findElementByXPath("//span[text()='wishlist']").click();
		driver.quit();
	  
	  
	
	
			}



		
		
		
	
		
	}


