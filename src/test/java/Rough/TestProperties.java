
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

		// (dataProvider = "getData")

		// String uname, String pwd) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hgulia\\eclipse-workspace\\PME\\src\\test\\resources\\Executables\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://192.168.110.82/cuadmin/home.do");

		Thread.sleep(1000);

		driver.findElement(By.xpath("html/body/form/div[2]/table[1]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/input"))
				.sendKeys("admin");

		driver.findElement(By.xpath("html/body/form/div[2]/table[1]/tbody/tr[1]/td[2]/table/tbody/tr[4]/td/input"))
				.sendKeys("fid53103");

		driver.findElement(By.xpath("html/body/form/div[2]/table[1]/tbody/tr[1]/td[2]/table/tbody/tr[5]/td/button[1]"))
				.click();
		
		Thread.sleep(5000);

	//WebElement fr=(driver.findElement(By.xpath(".//*[@id='cutreeContent']/div")));
		
	driver.switchTo().frame("tree");
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath(".//*[@id='cutree_1']/a/span")).click();

		System.out.println("hello");
	}
}
