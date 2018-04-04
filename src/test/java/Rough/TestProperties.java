
package Rough;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestBase;
import Utilities.TestUtil;

public class TestProperties extends TestBase {
	
	public static void main(String[] args) throws InterruptedException {
		
		loginasPMEAdmin();
		
		
	}

	@Test(priority = 1)
	// (dataProvider = "getData")
	public static void loginasPMEAdmin() throws InterruptedException {
		// String uname, String pwd) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hgulia\\eclipse-workspace\\PME\\src\\test\\resources\\Executables\\chromedriver.exe");

		driver = new ChromeDriver();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("unamelogin"))));

		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("PMEAdmin");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("PMEAdmin");
		driver.findElement(By.xpath(".//*[@id='submit']")).click();


		Thread.sleep(1000);

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));
		driver.findElement(By.xpath(OR.getProperty("main"))).click();

		Thread.sleep(200);
		driver.findElement(By.xpath(OR.getProperty("unlock"))).click();
		//click("system");

		log.debug("Login Successfully executed");

	}

	@Test(priority = 2)
	public void ldapDeleteData() throws InterruptedException {

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));
		// click("system");

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("ldapldap"))));
		Thread.sleep(100);
		click("ldapldap");
		Thread.sleep(100);
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("ldapstatic"))), "page not correct");

		if (driver.findElements(By.cssSelector("a[tester-id*='QA Automation']")).size() != 0) {

			driver.findElement(By.cssSelector("a[tester-id*='QA Automation']")).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("deleteuserinsideldap"))));

			click("deleteuserinsideldap");

			Thread.sleep(100);

			driver.switchTo().alert().accept();

		}

		else {

			System.out.println("No data found for delete in Ldap");
		}
		Thread.sleep(100);
	}

	@Test(priority = 3)
	public void ftpDeleteData() throws InterruptedException {

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));
		// click("system");

		click("ftpftp");
		Thread.sleep(100);

		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("ftpstatic"))), "page not correct");

		if (driver.findElements(By.partialLinkText("QA Automation")).size() != 0) {

			driver.findElement(By.partialLinkText("QA Automation")).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("deleteftp"))));

			click("deleteftp");

			Thread.sleep(100);

			driver.switchTo().alert().accept();

		} else {

			System.out.println("No data found for delete in FTP");
		}
		Thread.sleep(100);
	}

	@Test(priority = 4)
	public void appServerDeleteDataCucm() throws InterruptedException {

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));
		// click("system");
		Thread.sleep(100);
		click("serverapp");
		Thread.sleep(100);
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("staticcucm"))), "page not correct");

		if (driver.findElements(By.cssSelector("a[tester-id*='QA Auto Call Manager 11.5']")).size() != 0) {

			driver.findElement(By.cssSelector("a[tester-id*='QA Auto Call Manager 11.5']")).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("deleteuserinsidecucm"))));
			Thread.sleep(100);
			click("deleteuserinsidecucm");

			Thread.sleep(100);

			driver.switchTo().alert().accept();

		}

		else {

			System.out.println("No data found for delete Cucm");
		}
		Thread.sleep(100);
	}

	@Test(priority = 5)
	public void appServerDeleteDataUnity() throws InterruptedException {

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));
		// click("system");
		Thread.sleep(100);
		click("connectunity");

		Thread.sleep(100);

		if (driver.findElements(By.cssSelector("a[tester-id*='QA Auto Unity 11.5']")).size() != 0) {

			driver.findElement(By.cssSelector("a[tester-id*='QA Auto Unity 11.5']")).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("deleteuserinsideunity"))));

			click("deleteuserinsideunity");

			Thread.sleep(100);

			driver.switchTo().alert().accept();

		}

		else {

			System.out.println("No data found for delete in Unity");
		}
		Thread.sleep(100);
	}

	@Test(priority = 6)
	public void appServerDeleteDataUccx() throws InterruptedException {

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));
		// click("system");
		Thread.sleep(100);
		click("uccxuccx");

		Thread.sleep(100);

		if (driver.findElements(By.cssSelector("a[tester-id*='QA Auto UCCX 11.5']")).size() != 0) {

			driver.findElement(By.cssSelector("a[tester-id*='QA Auto UCCX 11.5']")).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("deleteinsideuccx"))));

			click("deleteinsideuccx");

			Thread.sleep(100);

			driver.switchTo().alert().accept();

		} else {

			System.out.println("No data found for delete in Uccx");
		}
		Thread.sleep(100);
	}

	@Test(priority = 7)
	public void appServerDeleteDataUcce() throws InterruptedException {

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));
		// // click("system");
		Thread.sleep(100);
		click("ucceucce");

		Thread.sleep(100);

		if (driver.findElements(By.cssSelector("a[tester-id*='QA Auto UCCE 10']")).size() != 0) {

			driver.findElement(By.cssSelector("a[tester-id*='QA Auto UCCE 10']")).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("deleteinsideucce"))));

			click("deleteinsideucce");

			Thread.sleep(100);

			driver.switchTo().alert().accept();

		}

		else {

			System.out.println("No data found for delete in Ucce");
		}
		Thread.sleep(100);
	}

	@Test(priority = 8)
	public void appServerDeleteDataWebex() throws InterruptedException {

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));
		// click("system");
		Thread.sleep(100);

		click("webexwebex");

		Thread.sleep(100);

		if (driver.findElements(By.cssSelector("a[tester-id*='akkadianlabs-qa-auto']")).size() != 0) {

			driver.findElement(By.cssSelector("a[tester-id*='akkadianlabs-qa-auto']")).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("deleteinsidewebex"))));

			click("deleteinsidewebex");

			Thread.sleep(100);

			driver.switchTo().alert().accept();

		}

		else {

			System.out.println("No data found for delete in Webex");
		}
		Thread.sleep(100);
	}

	@Test(priority = 9)
	public void appServerDeleteDataSpark() throws InterruptedException {

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));
		// click("system");
		Thread.sleep(3000);
		click("sparkspark");

		Thread.sleep(100);

		if (driver.findElements(By.cssSelector("a[tester-id*='QA Auto Spark']")).size() != 0) {

			driver.findElement(By.cssSelector("a[tester-id*='QA Auto Spark']")).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("deleteinsidespark"))));

			click("deleteinsidespark");

			Thread.sleep(100);

			driver.switchTo().alert().accept();

		}

		else {

			System.out.println("No data found for delete in Spark");
		}
		Thread.sleep(1000);

	}

	@Test(priority = 10)
	public void appServerDeleteDataCisco() throws InterruptedException {

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));
		// click("system");

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("ciscomeeting"))));
		Thread.sleep(3000);
		// click("ciscomeeting");

		driver.findElement(By.xpath(OR.getProperty("ciscomeeting"))).sendKeys(Keys.ENTER);

		Thread.sleep(100);

		if (driver.findElements(By.cssSelector("a[tester-id*='QA Auto Cisco Meeting']")).size() != 0) {

			driver.findElement(By.cssSelector("a[tester-id*='QA Auto Cisco Meeting']")).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("deleteinsidecisco"))));

			click("deleteinsidecisco");

			Thread.sleep(100);

			driver.switchTo().alert().accept();

		}

		else {

			System.out.println("No data found for delete in Cisco");
		}

	}

}
