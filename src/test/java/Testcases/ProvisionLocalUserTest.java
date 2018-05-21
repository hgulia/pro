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

public class ProvisionLocalUserTest extends TestBase {

	@Test(priority = 1)
	public void mainPageOpenLocalUser() throws InterruptedException {

		driver.get("https://192.168.110.213/pme/index.php/");

		Thread.sleep(1000);

		click("actactions");

		Thread.sleep(500);

		click("provisionactions");

		Thread.sleep(1000);

	}

	@Test(priority = 2, dataProvider = "getData")
	public void provisionLocalUser(String huntpilot, String huntlistname, String linegroupname, String cucm,String cuc)
			throws InterruptedException, IOException {

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("localuserjob")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(1000);

		type("firstnamelocaluser", "Hitender");
		Thread.sleep(1000);
		type("lastnamelocaluser", "Gulia");
		Thread.sleep(1000);
		type("localusernameuser", "hgulia");
		Thread.sleep(1000);
		type("pinusernameuser", "1980");
		Thread.sleep(1000);
		type("selfserviceusernameuser", "18009879876");
		Thread.sleep(1000);
		type("telephonenumberusernameuser", "6466708540");

		Thread.sleep(3000);

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

			type("ciscofindhunt", "hgulia");

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

				if (selfcucm.equals("18009879876")) {

					log.debug("Provision Success! Self service Id matched in Call manager:: ");

				}

				else {

					log.debug("Provision Success! Self service Id not  matched in Call manager:: ");
				}

				String fnamecucm = (driver.findElement(By.xpath(OR.getProperty("ciscofirstnamelocaluser")))
						.getAttribute("value"));

				Thread.sleep(1000);

				if (fnamecucm.equals("Hitender")) {

					log.debug("Provision Success! First Name matched in Call manager:: ");

				}

				else {

					log.debug("Provision Success! First Name not  matched in Call manager:: ");
				}

				String lnamecucm = (driver.findElement(By.xpath(OR.getProperty("ciscolastnamelocaluser")))
						.getAttribute("value"));

				Thread.sleep(1000);

				if (lnamecucm.equals("Gulia")) {

					log.debug("Provision Success! Last Name matched in Call manager:: ");

				}

				else {

					log.debug("Provision Success! Last Name not  matched in Call manager:: ");
				}

				String tnumbercucm = (driver.findElement(By.xpath(OR.getProperty("ciscotelephonelocaluser")))
						.getAttribute("value"));

				Thread.sleep(1000);

				if (tnumbercucm.equals("6466708540")) {

					log.debug("Provision Success! Telephone Number matched in Call manager:: ");

				}

				else {

					log.debug("Provision Success! Telephone Number not  matched in Call manager:: ");
				}
			}

			else {

				log.debug("Provision Success! Records not find:: " + status);

			}

		}
	}

	@Test(priority = 3)
	public void mainPageOpenDeleteLocalUser() throws InterruptedException {

		driver.get("https://192.168.110.213/pme/index.php/");

		Thread.sleep(1000);

		click("actactions");

		Thread.sleep(500);

		click("provisionactions");

		Thread.sleep(1000);

	}

	@Test(priority = 4, dataProvider = "getData")
	public void provisionDeleteLocalUser(String huntpilot, String huntlistname, String linegroupname, String cucm,String cuc)
			throws InterruptedException, IOException {

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("deleteuldapuser")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		click("deleteldapuser");

		Thread.sleep(2000);

		driver.findElement(By.xpath(OR.getProperty("snrinputuser"))).sendKeys("Hitender");

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

			type("ciscofindhunt", "hgulia");

			Thread.sleep(1000);

			click("ciscofindbtn");

			Thread.sleep(1000);

			String status = (driver.findElement(By.xpath(OR.getProperty("ciscorecordfound"))).getText());

			String expected = "0 records found";
			verifyEquals(status, expected);

			if (status.equals(expected)) {

				log.debug("Provision Success!Delete job Failed Records find:: " + status);
			}

			else {

				log.debug("Provision Success!Delete job Success  No Records find:: " + status);
			}
		}
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