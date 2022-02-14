package selenium.assignments;

import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		
		//Are you enjoying the classes?
		driver.findElementByXPath("//input[@class='myradio']").click();
		
		//Find default selected radio button
	    String defaultselection = driver.findElementByXPath("//label[@for='Checked']").getText();
	    System.out.println("the default selection is "+ defaultselection);
	    
	    //Select your age group (Only if choice wasn't selected)
	   if( driver.findElementByXPath("(//input[@value=1])[3]") .isSelected())
	   {
	    System.out.println("The age selection is already done");
		}
	   else
	   {
		   driver.findElementByXPath("(//input[@value=1])[3])").click();
	   }

}
}
