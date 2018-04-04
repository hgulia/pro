package Testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class ApplicationServerTest extends TestBase {

	@Test(priority = 1, dataProvider = "getData")
	public void cucmServer(String callmanager, String unity, String uccx, String ucce, String webex, String spark,
			String cisco, String ldap) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));
		click("system");

		click("serverapp");

		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("serverstaticapp"))), "page not correct");

		Thread.sleep(100);

		click("addappcucm");

		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("staticcucm"))), "page not correct");

		type("nameappcucm", callmanager);
		type("servercucm", "192.168.110.81");
		type("unamecucm", "admin");
		type("pwdcucm", "fid53103");
		type("confirmpwdcucm", "fid53103");
		click("verifyaxlcucm");

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("savecucm"))));

		Thread.sleep(1000);
		click("savecucm");

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("backcucm"))));

		Thread.sleep(1000);
		click("backcucm");

	}

	@Test(priority = 2, dataProvider = "getData")
	public void unityConnections(String callmanager, String unity, String uccx, String ucce, String webex, String spark,
			String cisco, String ldap) throws InterruptedException {

		click("connectunity");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("addunity"))));

		click("addunity");

		type("appserverunity", unity);
		type("serverunity", "192.168.110.82");
		type("unameunity", "admin");
		type("pwdunity", "fid53103");
		type("confirmpwdunity", "fid53103");
		click("verifyconnectionunity");

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("saveunity"))));
		Thread.sleep(1000);
		click("saveunity");

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("backunity"))));
		Thread.sleep(1000);
		click("backunity");
		Thread.sleep(100);
	}

	@Test(priority = 3, dataProvider = "getData")
	public void uccx(String callmanager, String unity, String uccx, String ucce, String webex, String spark,
			String cisco, String ldap) throws InterruptedException {
		Thread.sleep(100);
		click("uccxuccx");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("adduccx"))));

		click("adduccx");

		type("servernameuccx", uccx);
		type("serveruccx", "192.168.110.80");
		type("unameuccx", "admin");
		type("pwduccx", "fid53103");
		type("confirmpwduccx", "fid53103");
		click("verifyuccx");

		// WebElement saveuccx =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("saveuccx"))));
		Thread.sleep(1000);
		click("saveuccx");

		// WebElement backuccx =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("backuccx"))));
		Thread.sleep(1000);
		click("backuccx");
		Thread.sleep(100);

	}

	@Test(priority = 4, dataProvider = "getData")
	public void ucce(String callmanager, String unity, String uccx, String ucce, String webex, String spark,
			String cisco, String ldap) throws InterruptedException {
		Thread.sleep(100);
		click("ucceucce");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("adducce"))));

		click("adducce");

		type("servernameucce", ucce);
		type("serverucce", "192.168.124.240");
		type("unameucce", "administrator@fidelus-dev.com");
		type("pwducce", "Fid53103");
		type("confirmpwducce", "Fid53103");
		type("sqldbnameucce", "dev_awdb");
		type("sqlserveruserucce", "pme");
		type("sqlserverpwducce", "fid53103");

		click("verifyucce");

		Thread.sleep(1000);

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("saveucce"))));

		// WebElement save=driver.findElement(By.xpath(OR.getProperty(saveucce")))"
		driver.findElement(By.xpath(OR.getProperty("saveucce"))).submit();

		// saveucce.sub

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(
		// "backucce"))));

		Thread.sleep(1000);

		driver.findElement(By.xpath(OR.getProperty("backucce"))).click();

		Thread.sleep(100);

	}

	@Test(priority = 5, dataProvider = "getData")
	public void webExConnections(String callmanager, String unity, String uccx, String ucce, String webex, String spark,
			String cisco, String ldap) throws InterruptedException {

		click("webexwebex");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("addwebex"))));

		click("addwebex");

		type("sitenamewebex", webex);
		type("siteurlwebex", "akkadianlabs-qa.webex.com");
		type("siteidwebex", "1004167");
		type("partneridwebex", "jrVODMk1mpWD5hvkBZPWtg");
		type("unamewebex", "pma@akkadianlabs.com");
		type("pwdwebex", "Fid53103!");
		type("confirmpwdwebex", "Fid53103!");
		click("verifywebex");

		// WebElement savewebex = wait
		// .until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("savewebex"))));
		Thread.sleep(2000);
		click("savewebex");

		// WebElement backwebex =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("backwebex"))));
		Thread.sleep(1000);
		click("backwebex");
		Thread.sleep(100);

	}

	@Test(priority = 6, dataProvider = "getData")
	public void spark(String callmanager, String unity, String uccx, String ucce, String webex, String spark,
			String cisco, String ldap) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("sparkspark"))));

		click("sparkspark");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("addspark"))));

		click("addspark");

		type("sitenamespark", spark);
		type("siteurlspark", "api.ciscospark.com");
		type("unamespark", "sparkapi@akkadianlabs.com");
		type("accesstokenspark", "MGZlZjVkMmYtMTZmNC00NWE1LTlkNGUtOTE0MTBkYWFlOTg1MDNjN2M1MDItZjQ5");

		click("verifyspark");

		// WebElement savespark =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("savespark"))));

		Thread.sleep(1000);
		click("savespark");

		// WebElement backspark =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("backspark"))));
		Thread.sleep(1000);
		click("backspark");
		Thread.sleep(100);
	}

	@Test(priority = 7, dataProvider = "getData")
	public void ciscoMeetingServer(String callmanager, String unity, String uccx, String ucce, String webex,
			String spark, String cisco, String ldap) throws InterruptedException {
		Thread.sleep(100);
		click("ciscomeeting");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("addcisco"))));

		click("addcisco");

		type("sitenamecisco", cisco);
		type("siteurlcisco", "https://hqcms2.fidelusexperience.com");
		type("serverportcisco", "445");
		type("unamecisco", "admin");
		type("pwdcisco", "only4demo!");

		click("verifycisco");

		// WebElement savecisco =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("savecisco"))));
		Thread.sleep(1000);
		click("savecisco");

		// WebElement backcisco =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("backcisco"))));
		Thread.sleep(1000);
		click("backcisco");
		Thread.sleep(100);

	}

	@Test(priority = 8)
	public void scheduleSync() throws InterruptedException {
		Thread.sleep(100);
		click("schedulesync");

		click("settimeschedule");
		driver.findElement(By.xpath(OR.getProperty("settimedata"))).sendKeys("6", Keys.ENTER);

		click("ampmschedule");
		driver.findElement(By.xpath(OR.getProperty("settimedata"))).sendKeys("AM", Keys.ENTER);

		click("repeatschedule");
		driver.findElement(By.xpath(OR.getProperty("settimedata"))).sendKeys("Daily", Keys.ENTER);

		click("repeateveryschedule");
		driver.findElement(By.xpath(OR.getProperty("settimedata"))).sendKeys("1", Keys.ENTER);

		driver.findElement(By.xpath(OR.getProperty("startsonschedule"))).clear();
		driver.findElement(By.xpath(OR.getProperty("startsonschedule"))).sendKeys("04/02/2018", Keys.ENTER);
		Thread.sleep(1000);
		click("endsschedule");
		driver.findElement(By.xpath(OR.getProperty("settimedata"))).sendKeys("Never", Keys.ENTER);

		Thread.sleep(100);
		if (!driver.findElement(By.xpath(OR.getProperty("emailcheckboxschedule"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("emailcheckboxschedule"))).click();
		}
		Thread.sleep(100);
		if (!driver.findElement(By.xpath(OR.getProperty("onlyonfailureschedule"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("onlyonfailureschedule"))).click();
		}

		driver.findElement(By.xpath(OR.getProperty("emailtextboxschedule"))).clear();
		type("emailtextboxschedule", "hgulia@akkadianlabs.com");

		Thread.sleep(100);
		if (!driver.findElement(By.xpath(OR.getProperty("unityconnectionschedule"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("unityconnectionschedule"))).click();
		}
		Thread.sleep(100);
		if (!driver.findElement(By.xpath(OR.getProperty("ucceconnectionschedule"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("ucceconnectionschedule"))).click();
		}
		Thread.sleep(100);
		if (!driver.findElement(By.xpath(OR.getProperty("uccxconnectionschedule"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("uccxconnectionschedule"))).click();
		}

		click("updatebtnschedule");

	}

	@DataProvider(name = "getData")
	public Object[][] getData() {

		String sheetName = "cucmServer";

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
