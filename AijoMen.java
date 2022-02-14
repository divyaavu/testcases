package selenium.prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AijoMen {
public static void main(String[] args) throws InterruptedException {
	ChromeOptions options = new ChromeOptions();

	//Add chrome switch to disable notification - "**--disable-notifications**"
	options.addArguments("--disable-notifications");
	System.setProperty("webdriver.chrome.driver", "./drivers3/chromedriver.exe");
	ChromeDriver driver= new ChromeDriver(options);
	driver.get("https://www.ajio.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//driver.close();
	Actions builder= new Actions(driver);
	WebElement menlink = driver.findElementByLinkText("MEN");
    builder.moveToElement(menlink).perform();
    driver.findElementByXPath("(//a[text()='Jackets & Coats'])[1]").click();
    driver.findElementByXPath("//span[text()='brands']").click();
    driver.findElementById("verticalsizegroupformat").click();
    driver.findElementByXPath("(//label[@for='modal-Campus Sutra'])[1]").click();
    driver.findElementByXPath("(//label[@for='modal-Fort Collins'])[1]").click();
    driver.findElementByXPath("//span[text()='ARMANI EXCHANGE']").click();
    driver.findElementByXPath("//button[text()='Apply']").click();
    driver.findElementByXPath("//span[text()='colors']").click();
    Thread.sleep(3000);
    driver.findElementByXPath("//label[@for='Black']").click();
    driver.findElementByXPath("//label[@for='Brown']").click();
    driver.findElementByXPath("//span[text()='sleeve']").click();
    Thread.sleep(2000);
    driver.findElementByXPath("//label[@for='Full-length']").click();
    Thread.sleep(2000);
    WebElement items = driver.findElementByClassName("length");
    System.out.println(items.getText());
    
    Thread.sleep(5000);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    
    
    int count =driver.findElementsByXPath("//div[@class='name']").size();
    System.out.println("Count is "+count);
    
List<WebElement> ele = driver.findElementsByXPath("//div[@class='name']");
//WebDriverWait wait = new WebDriverWait(driver,30);
//wait.until(ExpectedConditions.visibilityOfAllElements(ele));


for (WebElement eachname : ele) {
	System.out.println(eachname.getText());
}
WebElement sort = driver.findElementByXPath("//select");
 Select opt= new Select(sort);  
 opt.selectByVisibleText("Price (highest first)");
 
 driver.findElementByXPath("(//img[@class='rilrtl-lazy-img  rilrtl-lazy-img-loaded'])[1]").click();
 Set<String> allWindows = driver.getWindowHandles();
	List<String> list = new ArrayList<String>(allWindows);
	String desiredWindow = list.get(1);
	driver.switchTo().window(desiredWindow);
	System.out.println("opened the new window");
	 List<WebElement> sizes = driver.findElementsByXPath("//div[@class='circle size-variant-item size-instock ']");
 for (WebElement asize : sizes) {
	 System.out.println(asize.getText());
	if(asize.isEnabled()) {
		asize.click();
		break;
		
	}}

driver.findElementByXPath("//span[text()='ADD TO BAG']").click();
Thread.sleep(8000);
Actions builder1= new Actions(driver);
builder1.moveToElement(driver.findElementByXPath("//a[text()='MEN']")).build().perform();
driver.findElementByLinkText("Sneakers").click();
driver.findElementByXPath("//label[@for='Men - Sneakers & Sports Shoes']").click();
driver.findElementByXPath("//label[@for='Men']").click();
driver.findElementByXPath("//span[text()='brands']").click();
driver.findElementById("verticalsizegroupformat").click();
driver.findElementByXPath("//label[@for='modal-ASICS']").click();
driver.findElementByXPath("//span[text()='ARMANI EXCHANGE']").click();
driver.findElementByXPath("//span[text()='EA7 Emporio Armani']").click();
driver.findElementByXPath("//span[text()='G STAR RAW']").click();
driver.findElementByXPath("//span[text()='GAS']").click();
driver.findElementByXPath("//button[text()='Apply']").click();
driver.findElementByXPath("(//img[@class='rilrtl-lazy-img  rilrtl-lazy-img-loaded'])[1]").click();
Set<String> allWin = driver.getWindowHandles();
List<String>list1=new ArrayList<String>(allWin);
String shoewin = list1.get(2);
driver.switchTo().window(shoewin);
System.out.println(driver.findElementByXPath("//h2[@class='brand-name']").getText());
System.out.println(driver.findElementByXPath("//div[@class='prod-sp']").getText()); 
List<WebElement> shoesize = driver.findElementsByXPath("//div[@class='circle size-variant-item size-instock ']");
for (WebElement ssize : shoesize) {
	 System.out.println(ssize.getText());
		if(ssize.isEnabled()) {
			ssize.click();
			break;
		
}}
driver.findElementByXPath("//span[text()='ADD TO BAG']").click();
driver.findElementByXPath("//div[text()='PROCEED TO BAG']").click();
System.out.println(driver.findElementByXPath("//div[@class='order-summary-container']").getText());
driver.findElementByXPath("//button[text()='Proceed to shipping']").click();
driver.findElementByXPath("//input[@class='login-btn']").click();
String errormsg = driver.findElementById("error-msg").getText();
System.out.println(errormsg);
for(int i=0;i<list1.size()-1;i++)
{
		driver.switchTo().window(list1.get(i)).close();
}
}}






