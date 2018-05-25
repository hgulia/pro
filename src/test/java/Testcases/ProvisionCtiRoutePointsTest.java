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

public class ProvisionCtiRoutePointsTest extends TestBase {

	@Test(priority = 1)
	public void mainPageOpenCtiRoute() throws InterruptedException {
		log.debug(" Test Class Start:  ProvisionCtiRoutePointsTest");
		driver.get("https://192.168.110.213/pme/index.php/");

		Thread.sleep(2000);

		click("actactions");

		Thread.sleep(500);

		click("provisionactions");

		Thread.sleep(1000);
	}

	@Test(priority = 2, dataProvider = "getData")
	public void provisionCtiRoute(String huntpilot, String huntlistname, String linegroupname, String cucm, String cuc)
			throws InterruptedException, IOException {

		String dirNumber;

		String status;
		String expected;

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("addjob7")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(1000);

		click("routepointsuser");

		Thread.sleep(1000);

		driver.findElement(By.xpath(OR.getProperty("snrinputuser"))).sendKeys("kenrick", Keys.ENTER);
		Thread.sleep(4000);

		WebElement option = (driver.findElement(By.xpath(OR.getProperty("snrinputuser"))));

		action.moveToElement(option);
		action.click().sendKeys(Keys.ENTER);
		action.build().perform();

		Thread.sleep(8000);

		click("routepointsdirnumber");

		Thread.sleep(2000);

		dirNumber = (driver.findElement(By.xpath(OR.getProperty("routepointsdirnumberoption"))).getAttribute("value"));

		click("routepointsdirnumberoption");

		Thread.sleep(1000);

		type("routepointsdevicename", "qaups");

		Thread.sleep(4000);

		WebElement optionperformadd = (driver.findElement(By.xpath(OR.getProperty("performpro"))));

		action.moveToElement(optionperformadd);
		action.click().sendKeys(Keys.ENTER);
		action.build().perform();

		Thread.sleep(1000);

		WebElement optionperformaddagain = (driver.findElement(By.xpath(OR.getProperty("performpro"))));

		action.moveToElement(optionperformaddagain);
		action.click().sendKeys(Keys.ENTER);
		action.build().perform();

		log.debug("Click on perform");

		Thread.sleep(2000);

		boolean errormsgdisplay = (driver.findElement(By.xpath(OR.getProperty("errormsgpro")))).isDisplayed();

		if (errormsgdisplay == true) {

			log.debug("Provision Failed");
		}

		else if (errormsgdisplay == false) {

			driver.get(cucm);

			Thread.sleep(4000);

			WebElement callrouting = (driver.findElement(By.xpath(OR.getProperty("ciscoctipointdevice"))));

			action.moveToElement(callrouting).click().perform();
			Thread.sleep(1000);

			WebElement routehunt = (driver.findElement(By.xpath(OR.getProperty("ciscodevicecti"))));

			action.moveToElement(routehunt).click().perform();

			Thread.sleep(1000);

			Select select = new Select(driver.findElement(By.xpath(OR.getProperty("ciscofindexact"))));

			select.selectByValue("isExactly");

			Thread.sleep(1000);

			driver.findElement(By.xpath(OR.getProperty("ciscofindhunt"))).clear();

			Thread.sleep(1000);

			type("ciscofindhunt", "qaups");

			Thread.sleep(1000);

			click("ciscofindbtn");

			Thread.sleep(1000);

			status = (driver.findElement(By.xpath(OR.getProperty("ciscorecordfound"))).getText());

			expected = "1 records found";
			verifyEquals(status, expected);

			if (status.equals(expected)) {

				log.debug("Provision Success! Records find:: " + status);

				click("ciscoctifindentry");

				Thread.sleep(1000);

				dirNumber = (driver.findElement(By.xpath(OR.getProperty("ciscodevicename"))).getAttribute("value"));

				log.debug(dirNumber);

				Thread.sleep(1000);

				if (dirNumber.equals("QAUPS")) {

					log.debug("Provision Success! found expected data");

				} else {
					log.debug("Provision Success! Records not Match ");
				}
			}

			
			else {
				
				log.debug("Provision Failed! Records not find:: " + status);

			}
		}
	}

	@Test(priority = 3)
	public void mainPageOpenDeleteCtiRoute() throws InterruptedException {

		driver.get("https://192.168.110.213/pme/index.php/");

		Thread.sleep(1000);

		click("actactions");

		Thread.sleep(500);

		click("provisionactions");

		Thread.sleep(1000);

	}

	@Test(priority = 4, dataProvider = "getData")
	public void provisionDeleteCtiRoute(String huntpilot, String huntlistname, String linegroupname, String cucm,
			String cuc) throws InterruptedException, IOException {

		String status;
		String expected;

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("deletectiroute")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(1000);

		click("deletepointuser");

		Thread.sleep(1000);

		driver.findElement(By.xpath(OR.getProperty("snrinputuser"))).sendKeys("qaups", Keys.ENTER);

		Thread.sleep(4000);

		WebElement optionqa = (driver.findElement(By.xpath(OR.getProperty("snrinputuser"))));

		action.moveToElement(optionqa);
		action.click().sendKeys(Keys.ENTER);
		action.build().perform();

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

			Thread.sleep(4000);

			WebElement callrouting = (driver.findElement(By.xpath(OR.getProperty("ciscoctipointdevice"))));

			action.moveToElement(callrouting).click().perform();

			Thread.sleep(1000);

			WebElement routehunt = (driver.findElement(By.xpath(OR.getProperty("ciscodevicecti"))));

			action.moveToElement(routehunt).click().perform();

			Thread.sleep(1000);

			Select select = new Select(driver.findElement(By.xpath(OR.getProperty("ciscofindexact"))));

			select.selectByValue("isExactly");

			Thread.sleep(1000);

			driver.findElement(By.xpath(OR.getProperty("ciscofindhunt"))).clear();

			Thread.sleep(1000);

			type("ciscofindhunt", "qaups");

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

		log.debug(" Test Class Finish:  ProvisionAddExtCtiRoutePointsTest");

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