package seleniumTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class seleniumDemo {

	public static void main(String[] args) {

		//class object
		ChromeOptions co = new ChromeOptions();
		
		//Setting browser version
		co.setBrowserVersion("137");
		
		//Creating new WebDriver - Chrome
		WebDriver driver = new ChromeDriver();
		
		//maximizing window
		driver.manage().window().maximize();
		
		//Setting page to open
		driver.get("https://the-internet.herokuapp.com/inputs");
		
		//looking for search bar (google)
		//WebElement element = driver.findElement(By.name("q"));
		//WebElement element = driver.findElement(By.className("gLFyf"));
		
		//WebElement element = driver.findElement(By.className("example"));
		WebElement element = driver.findElement(By.xpath("//div[@class='example']/input[@type='number']"));
		
		//searching then submitting
		element.sendKeys("20");
		//element.submit();
		
		//Close Browser
		//driver.close();
	}

}
