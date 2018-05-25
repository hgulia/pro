package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.TestBase;

public class RoughTest extends TestBase {

	@Test(priority = 1)
	public void mainPageOpenAddExt7970() throws InterruptedException {

		click("main");

		Thread.sleep(500);

		click("unlock");

		Thread.sleep(500);

		click("system");

		driver.findElement(By.xpath(".//*[@id='system-update']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='chk_force_manual']")).click();

		Thread.sleep(3000);

		WebElement file = (driver.findElement(By.xpath(".//*[@id='updateFile']")));

		file.sendKeys("C:\\Users\\hgulia\\Desktop\\PMEVersion\\aPME_4.14.14_595_UPDATE_OVA_20180425.zip");
		
		Thread.sleep(500);
		
		driver.findElement(By.xpath(".//*[@id='updateFileBtn']")).click();
		
		
		
		WebDriverWait waitok=new WebDriverWait(driver, 60000);
		
		waitok.until(ExpectedConditions.elementToBeClickable(By.xpath( ".//*[@id=\"dialog\"]")));
		
		driver.findElement(By.xpath("//*[@id=\"dialog\"]")).getText();
		

	}

}
