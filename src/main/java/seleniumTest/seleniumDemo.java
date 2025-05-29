package seleniumTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumDemo {

	WebDriver driver;
	WebDriverWait wait;
	
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
		
		WebElement addButton = driver.findElement(By.xpath("//div[@class='example']/button[@onclick='addElement()']"));
		addButton.click();
		
		//Adding sleep timer to slow test down a bit
		Thread.sleep(2000);
		
		WebElement remButton = driver.findElement(By.className("added-manually"));
		remButton.click();
		
		Thread.sleep(2000);
		
		//Going back a page
		driver.navigate().back();
		
		
	}
	
	public void inputPage() {
		
		//Calling new class - Inputs
		WebElement link = driver.findElement(By.linkText("Inputs"));
		
		link.click();
		
		//wait = new WebDriverWait (driver, Duration.ofSeconds(10));
				
		WebElement textInput = driver.findElement(By.xpath("//div[@class='example']/input[@type='number']"));
				
		//searching then submitting
		textInput.sendKeys("20");
	}
	
	public static void main(String[] args) throws InterruptedException {

		
		
		seleniumDemo obj = new seleniumDemo();
		obj.openBrowser();
		obj.addRemoveElements();
		obj.inputPage();
		
	}


}
