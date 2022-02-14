package selenium.prac;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Crmcloud {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "./drivers2/chromedriver.exe");
ChromeDriver driver= new ChromeDriver();
driver.get("https://demo.1crmcloud.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.findElementById("login_user").sendKeys("admin");
driver.findElementById("login_pass").sendKeys("admin");
WebElement theme = driver.findElementById("login_theme");
Select opt= new Select(theme);
opt.selectByVisibleText("Claro Theme");
driver.findElementByXPath("//span[@class='uii uii-arrow-right']").click();
driver.findElementByXPath("//div[text()='Sales & Marketing']").click();
driver.findElementByXPath("//div[text()='Create Contact']").click();
WebElement title = driver.findElementByXPath("(//div[@title='(none)'])[1]");
title.click();
title.sendKeys("Mrs.",Keys.ENTER);
//Thread.sleep(3000);
driver.findElementById("DetailFormlast_name-input").sendKeys("lo");
driver.findElementById("DetailFormemail1-input").sendKeys("lljhgkjhpiuy@gmail.com");
driver.findElementById("DetailFormphone_work-input").sendKeys("9609065444");
driver.findElementByName("first_name").sendKeys("riyu");
String name = driver.findElementByName("first_name").getText();
driver.findElementByXPath("(//div[@class='input-field input-field-group rbullet'])[2]").sendKeys("Public Relations",Keys.ENTER);
//Thread.sleep(2000);
//driver.findElementByXPath("(//div[@class='input-field input-field-group rbullet'])[3]").sendKeys("Sales",Keys.ENTER);
driver.findElementById("DetailFormprimary_address_street-input").sendKeys("xxxiu yyoy zzzbbb");
driver.findElementById("DetailFormprimary_address_city-input").sendKeys("Chennai");
driver.findElementById("DetailFormprimary_address_state-input").sendKeys("Tamil NAdu");
driver.findElementById("DetailFormprimary_address_country-input").sendKeys("India",Keys.TAB);
driver.findElementById("DetailForm_save2").click();
Thread.sleep(5000);
//String name = driver.findElementByXPath("//a[@class='listViewNameLink']").getText();
Actions builder= new Actions(driver);
//builder.moveToElement(driver.findElementByXPath("(//a[@class='menubar-link'])[1]")).build().perform();
builder.moveToElement(driver.findElementById("grouptab-0")).build().perform();
Thread.sleep(3000);
builder.moveToElement(driver.findElementByXPath("//div[text()='Meetings']")).click().build().perform();
Thread.sleep(1000);
//.keyDown(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
driver.findElementByXPath("(//span[text()='Create'])[1]").click();
driver.findElementById("DetailFormname-input").sendKeys("Project Status");
//driver.findElementByXPath("(//div[@class='input-field input-field-group rbullet'])[1]").click();
//Thread.sleep(1000);
//builder.moveToElement(driver.findElementByXPath("//div[text()='Held']")).click().build().perform();
//builder.moveToElement(driver.findElementById("DetailFormdate_start-input")).click().perform();;
driver.findElementById("DetailFormduration-time").clear();
driver.findElementById("DetailFormduration-time").sendKeys("1");
driver.findElementByXPath(" //span[text()=' Add Participants']").click();
//driver.findElementByXPath(" //span[text()=' Add Participants']").sendKeys(name);

driver.findElementByXPath("(//input[@class='input-text'])[4]").sendKeys("riyu");
Thread.sleep(2000);
driver.findElementByXPath("(//input[@class='input-text'])[4]").sendKeys(Keys.ENTER);
driver.findElementById("DetailForm_save2-label").click();
builder.moveToElement(driver.findElementById("grouptab-1")).build().perform();
Thread.sleep(3000);
builder.moveToElement(driver.findElementByXPath("//div[text()='Contacts']")).click().build().perform();


//driver.findElementByXPath("option-cell input-label ").click();
//Actions op= new Actions(driver);
//op.moveToElement(driver.findElementByXPath("option-cell input-label ")).click().perform();
driver.findElementById("filter_text").sendKeys("riyu");
Thread.sleep(5000);
driver.findElementById("filter_text").sendKeys(Keys.ENTER);
Thread.sleep(5000);
driver.findElementByXPath("//a[@class='listViewNameLink']").click();
boolean displayed = driver.findElementByXPath("(//span[@class='text-number'])[4]").isDisplayed();
System.out.println("The meeting is scheduled "+ displayed);




	}

}
