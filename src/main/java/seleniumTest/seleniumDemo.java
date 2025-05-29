package seleniumTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumDemo {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
	public void openBrowser() {
		
		//class object
		ChromeOptions co = new ChromeOptions();
				
		//Setting browser version
		co.setBrowserVersion("137");
			
		//Creating new WebDriver - Chrome
		driver = new ChromeDriver();
				
		//maximizing window
		driver.manage().window().maximize();
				
		//Setting page to open
		driver.get("https://the-internet.herokuapp.com");
		
		wait = new WebDriverWait (driver,Duration.ofSeconds(5));
	}
	public void addRemoveElements() throws InterruptedException {
		
		WebElement link = driver.findElement(By.linkText("Add/Remove Elements"));
		link.click();
		
		//Adding sleep timers to slow test down a bit for visual purposes
		Thread.sleep(1000);
		
		//adding button
		WebElement addButton = driver.findElement(By.xpath("//div[@class='example']/button[@onclick='addElement()']"));
		addButton.click();
		
		Thread.sleep(2000);
		
		//removing button
		WebElement remButton = driver.findElement(By.className("added-manually"));
		remButton.click();
		
		Thread.sleep(2000);
		
		//Going back a page
		driver.navigate().back();
	}
	public void basicAuth() throws InterruptedException {
		String user, pass;
		user = "admin";
		pass = "admin";
		
		WebElement link = driver.findElement(By.linkText("Basic Auth"));
		link.click();
		
		driver.switchTo().alert().sendKeys(user + Keys.TAB + pass);
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		driver.navigate().back();
	}
	public void checkbox() throws InterruptedException {
		
		WebElement link = driver.findElement(By.linkText("Checkboxes"));
		link.click();
		
		Thread.sleep(1000);
		
		//WebElement check1 = driver.findElement(By.xpath("//div[@class='example']/form[@id='checkbox']"));
		List<WebElement> check1 = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		//looking for checked boxes to de-select them
		for(WebElement chkSelected : check1) {
			if (chkSelected.isSelected()) {
				chkSelected.click();
			}
	
		}
		Thread.sleep(1000);
		
		//selecting all check boxes now
		for(WebElement chkSelected : check1) {
			if (!chkSelected.isSelected()) {
				chkSelected.click();
			}
	
		}
		
		Thread.sleep(2000);
		driver.navigate().back();
	}
	public void contextMenu() throws InterruptedException {
		
		WebElement link = driver.findElement(By.linkText("Context Menu"));
		link.click();
		
		Thread.sleep(1000);
		
		actions = new Actions(driver);
		
		//Locating context menu area location
		WebElement element = driver.findElement(By.id("hot-spot"));
		
		//"moving" mouse to context menu area
		actions.contextClick(element).perform();
		
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		driver.navigate().back();
	}
	public void inputPage() throws InterruptedException {
		
		//Calling new class - Inputs
		WebElement link = driver.findElement(By.linkText("Inputs"));
		link.click();
		
		//wait = new WebDriverWait (driver, Duration.ofSeconds(10));
				
		WebElement textInput = driver.findElement(By.xpath("//div[@class='example']/input[@type='number']"));
				
		//searching then submitting
		textInput.sendKeys("20");
		
		Thread.sleep(2000);
		driver.navigate().back();
	}
	public void closeBrowser() {
		//closeing browser
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {

		seleniumDemo obj = new seleniumDemo();
		
		//Running all the methods
		obj.openBrowser();
		obj.addRemoveElements();
		//obj.basicAuth(); --come back to this later
		obj.checkbox();
		obj.contextMenu();
		obj.inputPage();
		
		obj.closeBrowser();
	}


}
