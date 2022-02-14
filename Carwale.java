package selenium.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Carwale {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Rewrite code using Page object model:: create one page class and object repo

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./drivers2/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(opt);
		driver.get("https://www.carwale.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElementByXPath("//span[text()='Used']").click();
		driver.findElementByXPath("//input[@placeholder='City, eg: Mumbai']").sendKeys("Chennai");
		// driver.findElementByXPath("//input[@placeholder='City, eg:
		// Mumbai']").click();
		Actions act = new Actions(driver);
		WebElement option = driver.findElementByXPath(
				"//div[@class='o-fznJzu o-fznJPk o-OAYdd o-dbKqqe o-cpnuEd o-bUVylL o-eMXLyl o-GFmfi']");
		act.moveToElement(option).click().build().perform();
		WebElement min = driver.findElementByXPath("(//div[@class='o-brXWGL'])[3]");
		act.moveToElement(min).click().sendKeys("8").build().perform();
		WebElement max = driver.findElementByXPath("(//div[@class='o-brXWGL'])[4]");
		act.moveToElement(max).click().sendKeys("12").build().perform();
		driver.findElementByXPath("//button[text()='Search']").click();
		Thread.sleep(5000);
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		WebElement cars = driver.findElementByXPath("//span[text()='Cars with Photos']");
		act.moveToElement(cars).click().build().perform();
		Thread.sleep(5000);
		JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
		jsx1.executeScript("window.scrollBy(0,450)", "");
		WebElement manufacturer = driver.findElementByXPath("//span[text()=' Hyundai ']");
		act.moveToElement(manufacturer).click().build().perform();
		driver.findElementByXPath("//span[text()='Creta']").click();
		// jsx1.executeScript("window.scrollBy(0,850)", "");
		JavascriptExecutor jsx2 = (JavascriptExecutor) driver;
		jsx2.executeScript("window.scrollBy(0,450)", "");
		WebElement fueltype = driver.findElementByXPath("(//h3[@class='sub-values'])[6]");
		act.moveToElement(fueltype).click().build().perform();

		driver.findElementByXPath("(//span[@class='filterText'])[66]").click();
		Thread.sleep(8000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("sort"))).click();
		WebElement bestmatch = driver.findElementById("sort");
		Select opt1 = new Select(bestmatch);
		opt1.selectByValue("1");
		List<WebElement> carprices = driver.findElementsByXPath("//div[@class='gridViewPrice car-unit-data']");
		for (WebElement ea : carprices) {
			// System.out.println(ea.getText());
		}
		WebElement leastcar = carprices.get(0);
		WebElement wishlist = driver.findElementByXPath("//span[@class='shortlist-icon--inactive shortlist']");
		act.moveToElement(leastcar).moveToElement(wishlist).click().build().perform();
		driver.findElementByXPath("//li[@class='action-box shortlistBtn']").click();
		driver.findElementByLinkText("More details »").click();
		Set<String> allwindows = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(allwindows);
		String currentwindow = list.get(1);
		driver.switchTo().window(currentwindow);
		JavascriptExecutor jsx3 = (JavascriptExecutor) driver;
		jsx3.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(5000);
		List<WebElement> ItemName = driver
				.findElementsByXPath("//div[@id='overview']//ul//li//div[@class='equal-width text-light-grey']");
		List<WebElement> ItemPrice = driver
				.findElementsByXPath("//div[@id='overview']//ul//li//div[@class='equal-width dark-text']");

		List<List<WebElement>> listoflist = new ArrayList<>();

		String[][] table = new String[ItemName.size()][ItemName.size()];
		table[0][0] = "Overview";
		table[0][1] = "Features";

		for (int i = 0; i < ItemName.size() - 1; i++) {
			String name = ItemName.get(i).getText();
			String value = ItemPrice.get(i).getText();
			System.out.println(name);
		    System.out.println(value);
		//	table[i + 1][0] = name;
		//	table[i + 1][1] = value;
		}

		//length(table);
		// driver.quit();
	
	}}

/*	public static void length(String[][] matrix) {

		int rowsLength = matrix.length;

		for (int k = 0; k < rowsLength; k++) {

			printMatrix(rowsLength, k, matrix);
*/
	//	}

//	}

	/*public static void printMatrix(int size, int row, String[][] matrix) {

		for (int i = 0; i < 2 * matrix[row].length; i++) {
			System.out.print("-");
		}
		System.out.println("-");

		for (int i = 1; i < 3; i++) {
			System.out.printf("| %4s ", matrix[row][i - 1]);
		}
		System.out.println("|");

		if (row == size - 1) {

			// when we reach the last row,
			// print bottom line "---------"

			for (int i = 0; i < 2 * matrix[row].length; i++) {
				System.out.print("-");
			}
			System.out.println("-");

		}
*/
	
//}

//}
