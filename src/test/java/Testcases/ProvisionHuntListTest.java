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

public class ProvisionHuntListTest extends TestBase {

	@Test(priority = 1)
	public void mainPageOpenHuntList() throws InterruptedException {

		log.debug(" Test Class Start:  ProvisionHuntListTest");

		log.debug(" This is the First Test Class in project");
		jsclick("main");

		Thread.sleep(500);

		jsclick("unlock");

		Thread.sleep(500);

		jsclick("actactions");

		Thread.sleep(500);

		jsclick("provisionactions");

		Thread.sleep(1000);

	}

	@Test(priority = 2, dataProvider = "getData")
	public void provisionHuntList(String huntpilot, String huntlistname, String linegroupname, String cucm, String cuc)
			throws InterruptedException, IOException {

		String huntpilotactual;

		String status;
		String expected;

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("addstandardforwardprojob4")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(1000);

		type("huntlistnameaddjob4", huntlistname);

		Thread.sleep(4000);

		click("addlinegroupaddjob4");

		Thread.sleep(3000);

		// click("addlinegroupoptionjob4");

		WebElement enter = driver.findElement(By.xpath(OR.getProperty("snrinputuser")));

		enter.click();

		Thread.sleep(500);

		enter.sendKeys("WWWWW");

		Thread.sleep(2000);

		enter.sendKeys(Keys.ENTER);

		// type("snrinputuser", "WWWWW");

		linegroupname = "WWWWW";

		Thread.sleep(4000);

		jsclick("performpro");

		log.debug("Click on perform");

		Thread.sleep(2000);

		boolean errormsgdisplay = (driver.findElement(By.xpath(OR.getProperty("errormsgpro")))).isDisplayed();

		if (errormsgdisplay == true) {

			log.debug("Provision Failed");
		}

		else if (errormsgdisplay == false) {

			driver.get(cucm);

			Thread.sleep(1000);

			type("ciscologin", "admin");

			type("ciscopwd", "fid53103");

			click("ciscologinbtn");

			Thread.sleep(1000);

			WebElement callrouting = (driver.findElement(By.xpath(OR.getProperty("ciscocallrouting"))));

			action.moveToElement(callrouting).click().perform();
			Thread.sleep(1000);

			WebElement routehunt = (driver.findElement(By.xpath(OR.getProperty("ciscoroutehunt"))));

			action.moveToElement(routehunt).click().perform();

			Thread.sleep(1000);

			WebElement huntlist = (driver.findElement(By.xpath(OR.getProperty("ciscohuntlist"))));

			action.moveToElement(huntlist).click().perform();

			Thread.sleep(2000);

			Select select = new Select(driver.findElement(By.xpath(OR.getProperty("ciscofindexact"))));

			select.selectByValue("isExactly");

			Thread.sleep(1000);

			driver.findElement(By.xpath(OR.getProperty("ciscofindhunt"))).clear();

			Thread.sleep(1000);

			type("ciscofindhunt", huntlistname);

			Thread.sleep(1000);

			click("ciscofindbtn");

			Thread.sleep(1000);

			status = (driver.findElement(By.xpath(OR.getProperty("ciscorecordfound"))).getText());

			expected = "1 records found";
			verifyEquals(status, expected);

			if (status.equals(expected)) {

				log.debug("Provision Success! Records find:: " + status);

				click("ciscofindentryhuntlist");

				Thread.sleep(1000);

				huntpilotactual = (driver.findElement(By.xpath(OR.getProperty("ciscohuntlistactual")))
						.getAttribute("value"));

				log.debug(huntpilotactual);

				Thread.sleep(1000);

				if (huntpilotactual.equals(huntlistname)) {

					log.debug("Provision Success! found expected data : Hunt List Name");

				} else {
					log.debug("Provision Success! in Callmanager Records not Match: Hunt List Name ");
				}

				String linegroupctual = driver.findElement(By.xpath(OR.getProperty("ciscolinegroupselect"))).getText();

				if (linegroupname.equalsIgnoreCase(linegroupctual)) {

					log.debug("Provision Success! found expected data : Line  Group");

				} else {
					log.debug("Provision Success! in Callmanager Records not Match Line Group:: ");
				}

			}

		}
	}

	@Test(priority = 3)
	public void mainPageOpenDeleteHuntList() throws InterruptedException {

		driver.get("https://192.168.110.213/pme/index.php/");

		Thread.sleep(1000);

		click("actactions");

		Thread.sleep(500);

		click("provisionactions");

		Thread.sleep(1000);

	}

	@Test(priority = 4, dataProvider = "getData")
	public void provisionDeleteHuntList(String huntpilot, String huntlistname, String linegroupname, String cucm,
			String cuc) throws InterruptedException, IOException {

		String status;
		String expected;

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("deletehuntlistjob")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(1000);

		click("deletehuntlist");

		Thread.sleep(1000);

		click("deletehuntlistoption");

		Thread.sleep(4000);

		WebElement optionperform = (driver.findElement(By.xpath(OR.getProperty("deleteperform"))));

		action.moveToElement(optionperform);
		action.click().sendKeys(Keys.ENTER);
		action.build().perform();

		log.debug("Click on  Delete job perform");

		Thread.sleep(1000);

		boolean errormsgdisplay = (driver.findElement(By.xpath(OR.getProperty("errormsgpro")))).isDisplayed();

		if (errormsgdisplay == true) {

			log.debug("Provision Failed");
		}

		else if (errormsgdisplay == false) {

			driver.get(cucm);

			Thread.sleep(3000);

			WebElement callrouting = (driver.findElement(By.xpath(OR.getProperty("ciscocallrouting"))));

			action.moveToElement(callrouting).click().perform();

			Thread.sleep(1000);

			WebElement routehunt = (driver.findElement(By.xpath(OR.getProperty("ciscoroutehunt"))));

			action.moveToElement(routehunt).click().perform();

			Thread.sleep(1000);

			WebElement huntpiolet = (driver.findElement(By.xpath(OR.getProperty("ciscohuntlist"))));

			action.moveToElement(huntpiolet).click().perform();

			Thread.sleep(1000);

			Select select = new Select(driver.findElement(By.xpath(OR.getProperty("ciscofindexact"))));

			select.selectByValue("isExactly");

			Thread.sleep(1000);

			driver.findElement(By.xpath(OR.getProperty("ciscofindhunt"))).clear();

			Thread.sleep(1000);

			type("ciscofindhunt", huntlistname);

			Thread.sleep(1000);

			click("ciscofindbtn");

			Thread.sleep(1000);

			status = (driver.findElement(By.xpath(OR.getProperty("ciscorecordfound"))).getText());

			expected = "0 records found";
			verifyEquals(status, expected);

			if (status.equals(expected)) {

				log.debug(" Delete job Provision Success! Records not found :: " + status);

			} else {
				log.debug("found expected data, delete job failed to delete data:: " + status);
			}
		}

		log.debug(" Test Class Finish:  ProvisionHuntListTest");

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