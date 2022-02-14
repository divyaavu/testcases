package selenium.prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "./drivers2/chromedriver.exe");
ChromeDriver driver= new ChromeDriver();
driver.get("https://www.amazon.in");
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.findElementById("twotabsearchtextbox").sendKeys("outslayer");
Thread.sleep(3000);
driver.findElementById("twotabsearchtextbox").sendKeys(Keys.DOWN,Keys.ENTER);
driver.findElementByXPath("//span[@class='a-dropdown-prompt']").click();
Thread.sleep(1000);
driver.findElementByLinkText("Avg. Customer Review").click();
List<WebElement> items = driver.findElements(By.xpath("//a[@class='a-link-normal s-link-style a-text-normal']"));
WebElement firstdisplayeditem = items.get(0);
System.out.println("The displayed first item is "+ firstdisplayeditem.getText() );
//firstdisplayeditem.click();
Thread.sleep(9000);
List<WebElement> listofprices = driver.findElementsByXPath("//span[@class='a-price-whole']");
List<Integer> pricelist= new ArrayList<Integer>();
List<Integer> sortedpricelist = new ArrayList<Integer>();
for (WebElement price : listofprices) {
	String eachpriceitem = price.getText().replaceAll("[^0-9]", "");
	pricelist.add(Integer.parseInt(eachpriceitem));
	sortedpricelist.add(Integer.parseInt(eachpriceitem));
}
System.out.println("*******************************");
System.out.println("The unsorted prices of the items are "+ sortedpricelist);
Collections.sort(sortedpricelist);
System.out.println(" The sorted price items are"+ sortedpricelist);
Integer max = Collections.max(pricelist);
System.out.println(" The maximum price of the items is " + max); 
listofprices.get(pricelist.indexOf(max)).click();
Set<String> allwindows = driver.getWindowHandles();
List<String >listofwindows= new ArrayList<String>(allwindows);
String currentwindow = listofwindows.get(1);
driver.switchTo().window(currentwindow);
driver.findElementById("add-to-cart-button").click();
driver.findElementByXPath("(//span[@class='a-button-inner'])[1]").click();
driver.findElementById("continue").click();
String errormsg = driver.findElementByXPath("(//div[@class='a-alert-content'])[2]").getText();
System.out.println("The msg displayed is "+ errormsg);




	}
	

}
