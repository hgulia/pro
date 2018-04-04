package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class DeleteDataTest extends TestBase {

	@Test(priority = 1, dataProvider = "getData")
	public void loginasPMEAdmin(String uname, String pwd) throws InterruptedException {

		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("unamelogin"))));

		login.sendKeys(uname);

		log.debug("Inside Login Test");

		type("pwdlogin", pwd);

		driver.findElement(By.xpath(OR.getProperty("signinlogin"))).click();

		// Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("system"))),
		// "Login not successful");

		// driver.findElement(By.xpath(OR.getProperty("main"))).click();

		Thread.sleep(500);
		// driver.findElement(By.xpath(OR.getProperty("unlock"))).click();

		click("system");

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
			Thread.sleep(500);

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

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));
		click("system");

		click("ftpftp");
		Thread.sleep(100);

		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("ftpstatic"))), "page not correct");

		if (driver.findElements(By.partialLinkText("QA Automation")).size() != 0) {

			driver.findElement(By.partialLinkText("QA Automation")).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("deleteftp"))));

			Thread.sleep(500);

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

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));
		click("system");
		Thread.sleep(100);
		click("serverapp");
		Thread.sleep(100);
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("staticcucm"))), "page not correct");

		if (driver.findElements(By.cssSelector("a[tester-id*='QA Auto Call Manager 11.5']")).size() != 0) {

			driver.findElement(By.cssSelector("a[tester-id*='QA Auto Call Manager 11.5']")).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("deleteuserinsidecucm"))));
			Thread.sleep(500);
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
			Thread.sleep(500);
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
		Thread.sleep(1000);
		click("uccxuccx");

		Thread.sleep(100);

		if (driver.findElements(By.cssSelector("a[tester-id*='QA Auto UCCX 11.5']")).size() != 0) {

			driver.findElement(By.cssSelector("a[tester-id*='QA Auto UCCX 11.5']")).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("deleteinsideuccx"))));
			Thread.sleep(500);
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
			Thread.sleep(500);
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
			Thread.sleep(500);
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
			Thread.sleep(500);
			click("deleteinsidespark");

			Thread.sleep(300);

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
			Thread.sleep(500);
			click("deleteinsidecisco");

			Thread.sleep(300);

			driver.switchTo().alert().accept();

		}

		else {

			System.out.println("No data found for delete in Cisco");
		}

	}

	@DataProvider
	public Object[][] getData() {

		String sheetName = "LoginTest";

		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {

				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}

		}

		return data;
	}
}