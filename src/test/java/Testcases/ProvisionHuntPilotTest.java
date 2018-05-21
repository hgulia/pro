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

public class ProvisionHuntPilotTest extends TestBase {

	@Test(priority = 1)
	public void mainPageOpenHuntPilot() throws InterruptedException {

		driver.get("https://192.168.110.213/pme/index.php/");

		Thread.sleep(1000);

		click("actactions");

		Thread.sleep(500);

		click("provisionactions");

		Thread.sleep(1000);

	}

	@Test(priority = 2, dataProvider = "getData")
	public void provision(String huntpilot, String huntlistname, String linegroupname, String cucm,String cuc)
			throws InterruptedException, IOException {

		String huntpilotactual;
		String huntlistctual;
		String status;
		String expected;
		String dirNumber;

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("addlinegrouppro")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(1000);

		WebElement huntpioletname = (driver.findElement(By.xpath(OR.getProperty("huntpilotpro"))));

		action.moveToElement(huntpioletname);
		action.click().sendKeys(huntpilot, Keys.ENTER);
		action.build().perform();
		Thread.sleep(1500);

		type("addlinegrouphuntnamepro", huntlistname);

		Thread.sleep(1000);

		click("addlinegroupaddpro");

		Thread.sleep(1000);

		click("huntlinegroupoptionpro");

		Thread.sleep(1000);

		type("addlinegroupnamepro", linegroupname);

		Thread.sleep(1000);

		click("addlinegroupdirectorypro");

		Thread.sleep(2000);
		
		dirNumber = driver.findElement(By.xpath(OR.getProperty("dirnumberselectoption"))).getText();

		Thread.sleep(1000);
		
		click("addlinedirectoryoptionpro");

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

			WebElement callrouting = (driver.findElement(By.xpath(OR.getProperty("ciscocallrouting"))));

			action.moveToElement(callrouting).click().perform();
			Thread.sleep(1000);

			WebElement routehunt = (driver.findElement(By.xpath(OR.getProperty("ciscoroutehunt"))));

			action.moveToElement(routehunt).click().perform();

			Thread.sleep(1000);

			WebElement huntpiolet = (driver.findElement(By.xpath(OR.getProperty("ciscohuntpiolet"))));

			action.moveToElement(huntpiolet).click().perform();

			Thread.sleep(1000);

			Select select = new Select(driver.findElement(By.xpath(OR.getProperty("ciscofindexact"))));

			select.selectByValue("isExactly");

			Thread.sleep(1000);

			driver.findElement(By.xpath(OR.getProperty("ciscofindhunt"))).clear();

			Thread.sleep(1000);

			type("ciscofindhunt", huntpilot);

			Thread.sleep(1000);

			click("ciscofindbtn");

			Thread.sleep(1000);

			status = (driver.findElement(By.xpath(OR.getProperty("ciscorecordfound"))).getText());

			expected = "1 records found";
			verifyEquals(status, expected);

			if (status.equals(expected)) {

				log.debug("Provision Success! Records find:: " + status);

				click("ciscofindentry");

				Thread.sleep(1000);

				huntpilotactual = (driver.findElement(By.xpath(OR.getProperty("ciscohuntpilotentry")))
						.getAttribute("value"));

				Thread.sleep(1000);

				Select selectact = new Select(driver.findElement(By.xpath(OR.getProperty("ciscohuntlistentry"))));

				WebElement option = selectact.getFirstSelectedOption();

				huntlistctual = option.getText();

				Thread.sleep(1000);

				if (huntpilotactual.equals(huntpilot)) {

					Thread.sleep(1000);

					log.debug("Provision Success! found expected data");

				} else {
					log.debug("Provision Success! Expected does not match in callmanager:: ");
				}

				if (huntlistctual.equals(huntlistname)) {
					Thread.sleep(1000);

					log.debug("Provision Success! found expected Hunt List Name");

				} else {
					log.debug("Provision Success! Hunt List Name does not match in callmanager:: ");
				}

			}

			else {
				log.debug("Provision Success! Records not found:: " + status);
			}

			WebElement callroutingline = (driver.findElement(By.xpath(OR.getProperty("ciscocallrouting"))));

			action.moveToElement(callroutingline).click().perform();
			Thread.sleep(1000);

			WebElement routehuntline = (driver.findElement(By.xpath(OR.getProperty("ciscoroutehunt"))));

			action.moveToElement(routehuntline).click().perform();

			Thread.sleep(1000);

			WebElement huntlistline = (driver.findElement(By.xpath(OR.getProperty("ciscolinegroup"))));

			action.moveToElement(huntlistline).click().perform();

			Thread.sleep(1000);

			Select selectline = new Select(driver.findElement(By.xpath(OR.getProperty("ciscofindexact"))));

			selectline.selectByValue("isExactly");

			Thread.sleep(1000);

			driver.findElement(By.xpath(OR.getProperty("ciscofindhunt"))).clear();

			Thread.sleep(1000);

			type("ciscofindhunt", linegroupname);

			Thread.sleep(1000);

			click("ciscofindbtn");

			Thread.sleep(1000);

			status = (driver.findElement(By.xpath(OR.getProperty("ciscorecordfound"))).getText());

			expected = "1 records found";
			verifyEquals(status, expected);

			if (status.equals(expected)) {

				log.debug("Provision Success! Records find:: " + status);

				click("ciscofindentrylinegroup");

				Thread.sleep(1000);

			String	huntpilotactualline = (driver.findElement(By.xpath(OR.getProperty("ciscolinegrouptactual")))
						.getAttribute("value"));

				Thread.sleep(1000);
				
				System.out.println(huntpilotactualline);
				System.out.println(linegroupname);

				if (huntpilotactualline.equals(linegroupname)) {

					log.debug("Provision Success! found expected Line Group Name in Callmanager");

				} else {
					log.debug("Provision Success!Line Group Name does not match in callmanager:: ");
				}

				Thread.sleep(1000);

				
				
				String diractual=(driver.findElement(By.xpath(OR.getProperty("ciscodirnumber")))).getText();

				Thread.sleep(1000);
				
				
				System.out.println(dirNumber);
				System.out.println(diractual);

				if (diractual.equals(dirNumber)) {

					log.debug("Provision Success! found expected Directory Number in Callmanager");

				} else {
					log.debug("Provision Success!Directory Number does not match in callmanager:: ");
				}

			}

		}
	}

	@Test(priority = 3)
	public void mainPageOpenDeleteHuntPilot() throws InterruptedException {

		driver.get("https://192.168.110.213/pme/index.php/");

		Thread.sleep(1000);

		click("actactions");

		Thread.sleep(500);

		click("provisionactions");

		Thread.sleep(1000);

	}

	@Test(priority = 4, dataProvider = "getData")
	public void provisionDeleteHuntPilot(String huntpilot, String huntlistname, String linegroupname, String cucm,String cuc)
			throws InterruptedException, IOException {

		String status;
		String expected;

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("deletejobhuntpilot")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(1000);

		click("deletecucmhuntpilot");

		Thread.sleep(1000);

		driver.findElement(By.xpath(OR.getProperty("snrinputuser"))).sendKeys(huntpilot, Keys.ENTER);

		Thread.sleep(1000);

		WebElement option = (driver.findElement(By.xpath(OR.getProperty("snrinputuser"))));

		action.moveToElement(option);
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

			Thread.sleep(2000);

			WebElement callrouting = (driver.findElement(By.xpath(OR.getProperty("ciscocallrouting"))));

			action.moveToElement(callrouting).click().perform();

			Thread.sleep(1000);

			WebElement routehunt = (driver.findElement(By.xpath(OR.getProperty("ciscoroutehunt"))));

			action.moveToElement(routehunt).click().perform();

			Thread.sleep(1000);

			WebElement huntpiolet = (driver.findElement(By.xpath(OR.getProperty("ciscohuntpiolet"))));

			action.moveToElement(huntpiolet).click().perform();

			Thread.sleep(1000);

			Select select = new Select(driver.findElement(By.xpath(OR.getProperty("ciscofindexact"))));

			select.selectByValue("isExactly");

			Thread.sleep(1000);

			driver.findElement(By.xpath(OR.getProperty("ciscofindhunt"))).clear();

			Thread.sleep(1000);

			type("ciscofindhunt", huntpilot);

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