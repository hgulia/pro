
package Rough;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import Base.TestBase;

public class TestProperties {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;

		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hgulia\\eclipse-workspace\\PME\\src\\test\\resources\\Executables\\chromedriver.exe");

	}		
		

		public void UploadFileUsingSendKeys()
				throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://192.168.110.213/pme/index.php/user/login");
			
			

			driver.findElement(By.id("uploadfile")).sendKeys(
					"C:\\path\\to\\fileToUpload.txt");

			
			
			
		}
	}