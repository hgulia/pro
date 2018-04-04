package Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class ServiceGroupsTest extends TestBase {

	@Test(dataProvider = "getData")
	public void settingsServiceGroups(String callmanager, String unity, String uccx, String ucce, String webex,
			String spark, String cisco, String ldap) throws InterruptedException, IOException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));
		click("system");

		click("servicegroups");

		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("staticgroups"))), "page not correct");

		Thread.sleep(100);

		click("addgroups");

		// click("settingsgroups");

		type("namegroups", callmanager);

		type("descriptiongroups", callmanager);

		click("commmanagergroups");
		driver.findElement(By.xpath(OR.getProperty("selectvaluegroups"))).sendKeys(callmanager, Keys.ENTER);

		click("unityconnectiongroups");
		driver.findElement(By.xpath(OR.getProperty("selectvaluegroups"))).sendKeys(unity, Keys.ENTER);

		click("uccxgroups");
		driver.findElement(By.xpath(OR.getProperty("selectvaluegroups"))).sendKeys(uccx, Keys.ENTER);

		click("uccegroups");
		driver.findElement(By.xpath(OR.getProperty("selectvaluegroups"))).sendKeys(ucce, Keys.ENTER);

		click("webexsitegroups");
		driver.findElement(By.xpath(OR.getProperty("selectvaluegroups"))).sendKeys(webex, Keys.ENTER);

		click("sparkgroups");
		driver.findElement(By.xpath(OR.getProperty("selectvaluegroups"))).sendKeys(spark, Keys.ENTER);

		click("ciscomeetinggroups");
		driver.findElement(By.xpath(OR.getProperty("selectvaluegroups"))).sendKeys(cisco, Keys.ENTER);

		type("dnagingperiodgroups", "10");

		if (!driver.findElement(By.xpath(OR.getProperty("enableserachgroups"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("enableserachgroups"))).click();
		}

		Thread.sleep(1000);

		WebElement dropdown = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("searchablecommgroups"))));
		dropdown.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='select2-drop']/ul/li[15]/div"))).click();

		if (!driver.findElement(By.xpath(OR.getProperty("enablesitetempgroups"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("enablesitetempgroups"))).click();
		}

		if (!driver.findElement(By.xpath(OR.getProperty("requiresitetempgroups"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("requiresitetempgroups"))).click();
		}

		// CUCM End User Database - LDAP Status Monitoring

		if (!driver.findElement(By.xpath(OR.getProperty("enableldapcucmend"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("enableldapcucmend"))).click();
		}

		Thread.sleep(500);

		click("frequencyhourcusmend");
		driver.findElement(By.xpath(OR.getProperty("selectvaluegroups"))).sendKeys("2", Keys.ENTER);

		if (!driver.findElement(By.xpath(OR.getProperty("sendemailcusmend"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("sendemailcusmend"))).click();
		}

		Thread.sleep(1000);

		type("emailnotificationcusmend", "hgulia@akkadianlabs.com");

		if (!driver.findElement(By.xpath(OR.getProperty("convertlocalcusmend"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("convertlocalcusmend"))).click();
		}

		if (!driver.findElement(By.xpath(OR.getProperty("deprovisionusercucmend"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("deprovisionusercucmend"))).click();
		}

		// Client Matter Code Rule

		if (!driver.findElement(By.xpath(OR.getProperty("enableclientmatter"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("enableclientmatter"))).click();
		}

		Thread.sleep(500);

		type("rulematter", "cmc_hgulia");

		if (!driver.findElement(By.xpath(OR.getProperty("deletelinkedmatter"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("deletelinkedmatter"))).click();
		}

		// Forced Authorization Code Rule

		if (!driver.findElement(By.xpath(OR.getProperty("enablerulesforced"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("enablerulesforced"))).click();
		}

		Thread.sleep(500);

		type("ruleforced", "fac_hgulia");

		if (!driver.findElement(By.xpath(OR.getProperty("deletewithforced"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("deletewithforced"))).click();
		}

		// DN Pool Reporting Configuration

		click("settimednpool");
		driver.findElement(By.xpath(OR.getProperty("selectvaluegroups"))).sendKeys("8", Keys.ENTER);

		click("ampmdnpool");
		driver.findElement(By.xpath(OR.getProperty("selectvaluegroups"))).sendKeys("AM", Keys.ENTER);

		// driver.findElement(By.xpath(OR.getProperty("setdaysdnpool"))).clear();

		// click("setdaysdnpool");
		// driver.findElement(By.xpath(OR.getProperty("selectvaluegroups"))).sendKeys("Mon",
		// Keys.ENTER);

		if (!driver.findElement(By.xpath(OR.getProperty("sendemailnotficationdnpool"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("sendemailnotficationdnpool"))).click();
		}

		Thread.sleep(500);

		type("emailboxdnpool", "hgulia@akkadianlabs.com");

		// DN Synchronization to Active Directory

		if (!driver.findElement(By.xpath(OR.getProperty("enablednsync"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("enablednsync"))).click();
		}

		click("ldapserverdnsync");
		driver.findElement(By.xpath(OR.getProperty("selectvaluegroups"))).sendKeys(ldap, Keys.ENTER);

		type("unamebinddnsync", "sAMAccountName");

		driver.findElement(By.xpath("//*[contains(@id, 'sync_dn_bind_name')]")).sendKeys("ldap auto");

		// CUC Voice Mailbox Scheduled Delete Service

		if (!driver.findElement(By.xpath(OR.getProperty("enablecucvoice"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("enablecucvoice"))).click();
		}
		Thread.sleep(500);

		type("numberofdaycucvoice", "2");

		if (!driver.findElement(By.xpath(OR.getProperty("sendemailboxcucvoice"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("sendemailboxcucvoice"))).click();
		}

		Thread.sleep(500);

		type("emailsendnotificationcucvoice", "hgulia@akkadianlabs.com");

		// Self-Service Configuration

		String actualString = driver.findElement(By.xpath(OR.getProperty("urlselfserviceconfig")))
				.getAttribute("value");

		System.out.println(actualString);

		verifyEquals(actualString, "https://192.168.110.199/pme/selfservice?sg=");

		if (!driver.findElement(By.xpath(OR.getProperty("enableselfserviceportal"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("enableselfserviceportal"))).click();
		}

		type("companynameportal", "QA Auto Akkadianlabs");

		// Active Directory Auto-provision

		if (!driver.findElement(By.xpath(OR.getProperty("enableadactivedir"))).isSelected()) {
			driver.findElement(By.xpath(OR.getProperty("enableadactivedir"))).click();
		}

		Thread.sleep(500);

		click("defaultldapactivedir");
		driver.findElement(By.xpath(OR.getProperty("selectvaluegroups"))).sendKeys(ldap, Keys.ENTER);

		type("defaultunameactivedir", "ldapAuto");

		click("saveservicegroups");
		
		Thread.sleep(500);
		
		click("backservicegroups");

	}

	@DataProvider
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
