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

public class ProvisionLdapUserTest extends TestBase {

	@Test(priority = 1)
	public void mainPageOpenLdapUser() throws InterruptedException {
		log.debug(" Test Class Start:  ProvisionLdapUserTest");

		driver.get("https://192.168.110.213/pme/index.php/");

		Thread.sleep(1000);

		click("actactions");

		Thread.sleep(500);

		click("provisionactions");

		Thread.sleep(1000);

	}

	@Test(priority = 2, dataProvider = "getData")
	public void provisionLdapUser(String huntpilot, String huntlistname, String linegroupname, String cucm, String cuc)
			throws InterruptedException, IOException {

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("ldapuserjob")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(1000);

		click("ldapuserldap");

		Thread.sleep(2000);

		driver.findElement(By.xpath(OR.getProperty("snrinputuser"))).sendKeys("Kenrick");

		Thread.sleep(2000);
		WebElement user = driver.findElement(By.xpath(OR.getProperty("snrinputuser")));
		user.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		type("ldapuserpinldap", "1980");

		Thread.sleep(3000);

		driver.findElement(By.xpath(OR.getProperty("ldapuserselfsignldap"))).clear();
		Thread.sleep(2000);

		type("ldapuserselfsignldap", "18003414111");

		Thread.sleep(1000);

		click("performpro");

		log.debug("Click on perform");

		Thread.sleep(2000);

		boolean errormsgdisplay = (driver.findElement(By.xpath(OR.getProperty("errormsgpro")))).isDisplayed();

		if (errormsgdisplay == true) {

			log.debug("Provision Failed");
		}

		else if (errormsgdisplay == false) {

			driver.get(cucm);

			Thread.sleep(3000);

			WebElement usermanagement = (driver.findElement(By.xpath(OR.getProperty("ciscousermanagement"))));

			action.moveToElement(usermanagement).click().perform();

			Thread.sleep(1000);

			WebElement enduser = (driver.findElement(By.xpath(OR.getProperty("ciscoenduser"))));

			action.moveToElement(enduser).click().perform();

			Thread.sleep(1000);

			Select selectuserid = new Select(driver.findElement(By.xpath(OR.getProperty("ciscoselectbyid"))));

			selectuserid.selectByValue("userid");

			Thread.sleep(1000);

			Select select = new Select(driver.findElement(By.xpath(OR.getProperty("ciscofindexact"))));

			select.selectByValue("isExactly");

			Thread.sleep(1000);

			driver.findElement(By.xpath(OR.getProperty("ciscofindhunt"))).clear();

			Thread.sleep(1000);

			type("ciscofindhunt", "Kchan");

			Thread.sleep(1000);

			click("ciscofindbtn");

			Thread.sleep(1000);

			String status = (driver.findElement(By.xpath(OR.getProperty("ciscorecordfound"))).getText());

			String expected = "1 records found";
			verifyEquals(status, expected);

			if (status.equals(expected)) {

				log.debug("Provision Success! Records find:: " + status);

				click("ciscofindenduser");

				Thread.sleep(1000);

				String selfcucm = (driver.findElement(By.xpath(OR.getProperty("ciscoselfidfield")))
						.getAttribute("value"));

				Thread.sleep(1000);

				if (selfcucm.equals("18003414111")) {

					log.debug("Provision Success! Self service Id matched in Call manager:: ");

				}

				else {

					log.debug("Provision Success! Self service Id not  matched in Call manager:: ");
				}
			}

			else {

				log.debug("Provision Success! Records not find:: " + status);

			}

		}
	}

	@Test(priority = 3)
	public void mainPageOpenDeleteLdapUser() throws InterruptedException {

		driver.get("https://192.168.110.213/pme/index.php/");

		Thread.sleep(1000);

		click("actactions");

		Thread.sleep(500);

		click("provisionactions");

		Thread.sleep(1000);

	}

	@Test(priority = 4, dataProvider = "getData")
	public void provisionDeleteLdapUser(String huntpilot, String huntlistname, String linegroupname, String cucm,
			String cuc) throws InterruptedException, IOException {

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("deleteuldapuser")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(1000);

		click("deleteldapuser");

		Thread.sleep(2000);

		driver.findElement(By.xpath(OR.getProperty("snrinputuser"))).sendKeys("Kenrick");

		Thread.sleep(2000);
		WebElement user = driver.findElement(By.xpath(OR.getProperty("snrinputuser")));
		user.sendKeys(Keys.ENTER);

		Thread.sleep(10000);

		WebElement optionperform = (driver.findElement(By.xpath(OR.getProperty("deleteperform"))));

		action.moveToElement(optionperform);
		action.click().sendKeys(Keys.ENTER);
		action.build().perform();

		log.debug("Click on  Delete job perform");

		Thread.sleep(10000);

		boolean errormsgdisplay = (driver.findElement(By.xpath(OR.getProperty("errormsgpro")))).isDisplayed();

		if (errormsgdisplay == true) {

			log.debug("Provision Failed");
		}

		else if (errormsgdisplay == false) {

			driver.get(cucm);

			Thread.sleep(3000);

			WebElement usermanagement = (driver.findElement(By.xpath(OR.getProperty("ciscousermanagement"))));

			action.moveToElement(usermanagement).click().perform();

			Thread.sleep(1000);

			WebElement enduser = (driver.findElement(By.xpath(OR.getProperty("ciscoenduser"))));

			action.moveToElement(enduser).click().perform();

			Thread.sleep(1000);

			Select selectuserid = new Select(driver.findElement(By.xpath(OR.getProperty("ciscoselectbyid"))));

			selectuserid.selectByValue("userid");

			Thread.sleep(1000);

			Select select = new Select(driver.findElement(By.xpath(OR.getProperty("ciscofindexact"))));

			select.selectByValue("isExactly");

			Thread.sleep(1000);

			driver.findElement(By.xpath(OR.getProperty("ciscofindhunt"))).clear();

			Thread.sleep(1000);

			type("ciscofindhunt", "Kchan");

			Thread.sleep(1000);

			click("ciscofindbtn");

			Thread.sleep(1000);

			String statusdel = (driver.findElement(By.xpath(OR.getProperty("ciscorecordfound"))).getText());

			String expecteddel = "1 records found";
			verifyEquals(statusdel, expecteddel);

			if (statusdel.equals(expecteddel)) {

				log.debug("Provision Success! Records find:: " + statusdel);

				click("ciscofindenduser");

				Thread.sleep(1000);

				String selfcucm = (driver.findElement(By.xpath(OR.getProperty("ciscoselfidfield")))
						.getAttribute("value"));

				Thread.sleep(1000);

				if (selfcucm.equals("18003414111")) {

					log.debug(" Delete Provision Failed! Self service Id matched in Call manager:: ");

				}

				else {

					log.debug(" Delete Provision Success! Self service Id not  matched in Call manager:: ");
				}
			}

			else {

				log.debug("Provision Success! Records not find:: " + statusdel);

			}

		}

		log.debug(" Test Class Finish:  ProvisionLdapUserTest");

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