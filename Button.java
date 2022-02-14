package selenium.assignments;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class Button {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		
		//Click button to travel home page
		driver.findElementByXPath("//button[text()='Go to Home Page']").click();
		String curURL = driver.getCurrentUrl();
		String homeURL ="http://leafground.com/home.html";
		if(curURL.equals(homeURL))
		{
			System.out.println("Navigation successful");
		}
		else
		{
			System.out.println("navigation failed");
		}
		
		//Find position of button (x,y)
driver.findElementByXPath("//img[@alt='Buttons']").click();
Dimension size = driver.findElementById("position").getSize();
System.out.println("The position of button is " + size);

//Find button color
String findcolour = driver.findElementById("color").getCssValue("background-color");
System.out.println("The background colour is" + findcolour);

//Find the height and width
Dimension findsize = driver.findElementById("size").getSize();
System.out.println("The size of the element"+ findsize);
	}
	

}
