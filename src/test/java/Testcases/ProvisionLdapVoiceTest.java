package Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class ProvisionLdapVoiceTest extends TestBase {

	@Test(priority = 1)
	public void mainPageOpenLdapVoice() throws InterruptedException {
		
		log.debug(" Test Class Start:  ProvisionLdapVoiceTest");

		driver.get("https://192.168.110.213/pme/index.php/");

		Thread.sleep(1000);

		click("actactions");

		Thread.sleep(500);

		click("provisionactions");

		Thread.sleep(1000);

	}

	@Test(priority = 2, dataProvider = "getData")
	public void provisionLdapVoice(String huntpilot, String huntlistname, String linegroupname, String cucm, String cuc)
			throws InterruptedException, IOException {

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("ldapvoicemailjob")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(2000);

		click("ldapvoicealias");
		Thread.sleep(1000);
		driver.findElement(By.xpath(OR.getProperty("ldapdatainput"))).sendKeys("Kchan", Keys.ENTER);
		Thread.sleep(4000);
		click("ldapoptionuser");

		Thread.sleep(10000);

		type("ldapvoicepin", "1980");

		Thread.sleep(1500);

		click("ldapvoicecucmusername");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("ldapdatainput"))).sendKeys("Kenrick", Keys.ENTER);
		Thread.sleep(4000);
		click("ldapfirstoptionuser");
		Thread.sleep(10000);

		click("ldapvoicecucmline");
		Thread.sleep(1000);
		driver.findElement(By.xpath(OR.getProperty("ldapdatainput"))).sendKeys("1223", Keys.ENTER);
		Thread.sleep(2000);
		click("ldapfirstoptionuser");
		Thread.sleep(2000);

		click("ldapcoicetemplate");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("ldapdatainput"))).sendKeys("NFL", Keys.ENTER);
		Thread.sleep(2000);
		click("ldapfirstoptionuser");
		Thread.sleep(4000);

		click("performpro");

		log.debug("Click on perform");

		Thread.sleep(4000);

		boolean errormsgdisplay = (driver.findElement(By.xpath(OR.getProperty("errormsgpro")))).isDisplayed();

		if (errormsgdisplay == true) {

			log.debug("Provision Failed");
		}

		else if (errormsgdisplay == false) {

			driver.get(cuc);

			type("ciscologin", "admin");

			type("ciscopwd", "fid53103");

			click("ciscologinbtn");

			Thread.sleep(2000);

			driver.switchTo().frame("tree");

			Thread.sleep(2000);

			click("cucfinduser");

			driver.switchTo().defaultContent();

			Thread.sleep(3000);

			driver.switchTo().frame("content");

			Thread.sleep(2000);

			Select select = new Select(driver.findElement(By.xpath(OR.getProperty("ciscofindexact"))));

			select.selectByValue("isExactly");

			Thread.sleep(1000);

			driver.findElement(By.xpath(OR.getProperty("ciscofindhunt"))).clear();

			Thread.sleep(1000);

			type("ciscofindhunt", "Kchan");

			Thread.sleep(1000);

			click("ciscofindbtn");

			Thread.sleep(1000);

			String status = (driver.findElement(By.xpath(OR.getProperty("ciscocucmsg"))).getText());

			String expected = "  Found 1 User(s)";
			verifyEquals(status, expected);

			if (status.equals(expected)) {

				log.debug("Provision Success! Records find:: " + status);

			}

			else {

				log.debug("Provision Failed! Records not find:: " + status);

			}
		}
	}

	@Test(priority = 3)
	public void mainPageOpenDeleteLdapVoice() throws InterruptedException {

		driver.get("https://192.168.110.213/pme/index.php/");

		Thread.sleep(1000);

		click("actactions");

		Thread.sleep(500);

		click("provisionactions");

		Thread.sleep(1000);

	}

	@Test(priority = 4, dataProvider = "getData")
	public void provisionDeleteLdapVoice(String huntpilot, String huntlistname, String linegroupname, String cucm,
			String cuc) throws InterruptedException, IOException {

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("ldapvoicemailjobdelete")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(2000);

		click("ldapvoicecucmusernamedelete");
		Thread.sleep(1000);
		driver.findElement(By.xpath(OR.getProperty("ldapdatainput"))).sendKeys("Kchan", Keys.ENTER);
		Thread.sleep(4000);
		click("ldapoptionuserdelete");

		Thread.sleep(10000);

		click("performpro");

		log.debug("Click on perform delete");

		Thread.sleep(4000);

		boolean errormsgdisplay = (driver.findElement(By.xpath(OR.getProperty("errormsgpro")))).isDisplayed();

		if (errormsgdisplay == true) {

			log.debug("Provision Failed");
		}

		else if (errormsgdisplay == false) {

			driver.get(cuc);

			Thread.sleep(2000);

			driver.switchTo().frame("tree");

			Thread.sleep(2000);

			click("cucfinduser");

			driver.switchTo().defaultContent();

			Thread.sleep(3000);

			driver.switchTo().frame("content");

			Thread.sleep(2000);

			Select select = new Select(driver.findElement(By.xpath(OR.getProperty("ciscofindexact"))));

			select.selectByValue("isExactly");

			Thread.sleep(1000);

			driver.findElement(By.xpath(OR.getProperty("ciscofindhunt"))).clear();

			Thread.sleep(1000);

			type("ciscofindhunt", "Kchan");

			Thread.sleep(1000);

			click("ciscofindbtn");

			Thread.sleep(1000);

			String status = (driver.findElement(By.xpath(OR.getProperty("ciscocucmsg"))).getText());

			String expected = "  Found 0 User(s)";
			verifyEquals(status, expected);

			if (status.equals(expected)) {

				log.debug("Provision Success! Records Deleted:: " + status);

			}

			else {

				log.debug("Provision Failed! Records find:: " + status);

			}
		}
		
		log.debug(" Test Class Finish:  ProvisionLdapVoiceTest");

	}

	@DataProvider(name = "getData")
	public Object[][] getData() {

		String sheetName = "ProvisionData";

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