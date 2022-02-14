package selenium.assignments;

import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		
		//Select the languages that you know?
		driver.findElementByXPath("(//input[@type='checkbox'])[1]").click();
		
		//Confirm Selenium is checked
		boolean select = driver.findElementByXPath("(//input[@type='checkbox'])[6]").isSelected();
		System.out.println(select);
		
		//DeSelect only checked
		driver.findElementByXPath("(//input[@type='checkbox'])[8]").click();
		
		
		//Select all below checkboxes
		driver.findElementByXPath("(//input[@type='checkbox'])[9]").click();
		driver.findElementByXPath("(//input[@type='checkbox'])[10]").click();
		driver.findElementByXPath("(//input[@type='checkbox'])[11]").click();
		driver.findElementByXPath("(//input[@type='checkbox'])[12]").click();
		driver.findElementByXPath("(//input[@type='checkbox'])[13]").click();
		
	}

}
