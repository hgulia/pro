package Testcases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class ProvisionAddExtAnalogTest extends TestBase {

	String devicename;

	@Test(priority = 1)
	public void mainPageOpenAddExtanalog() throws InterruptedException {
		log.debug(" Test Class Start:  ProvisionAddExtAnalogTest");
		driver.get("https://192.168.110.213/pme/index.php/");

		Thread.sleep(1000);

		click("actactions");

		Thread.sleep(500);

		click("provisionactions");

		Thread.sleep(1000);

	}

	@Test(priority = 2, dataProvider = "getData")
	public void provisionAddExtanalog(String huntpilot, String huntlistname, String linegroupname, String cucm,
			String cuc) throws InterruptedException, IOException {

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("analogjob")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(2000);

		click("analogcucmuser");
		Thread.sleep(1000);
		driver.findElement(By.xpath(OR.getProperty("ldapdatainput"))).sendKeys("Kenrick", Keys.ENTER);
		Thread.sleep(3000);
		click("ldapfirstoptionuser");
		Thread.sleep(10000);

		click("analogcucmline");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("ldapdatainput"))).sendKeys("1223", Keys.ENTER);
		Thread.sleep(2000);
		click("ldapfirstoptionuser");
		Thread.sleep(2000);

		click("analogvcgateway");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("ldapdatainput"))).sendKeys("SKIGW09234FFAA0", Keys.ENTER);
		Thread.sleep(2000);
		click("ldapfirstoptionuser");
		Thread.sleep(6000);

		devicename = driver.findElement(By.xpath(OR.getProperty("analogstorename"))).getAttribute("value");
		Thread.sleep(2000);

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

		Thread.sleep(8000);

		boolean errormsgdisplay = (driver.findElement(By.xpath(OR.getProperty("errormsgpro")))).isDisplayed();

		if (errormsgdisplay == true) {

			log.debug("Provision Failed");
		}

		else if (errormsgdisplay == false) {

			driver.get(cucm);

			Thread.sleep(4000);

			WebElement device = (driver.findElement(By.xpath(OR.getProperty("ciscodevicebutton"))));

			action.moveToElement(device).click().perform();

			Thread.sleep(1000);

			WebElement phone = (driver.findElement(By.xpath(OR.getProperty("ciscodevicephone"))));

			action.moveToElement(phone).click().perform();

			Thread.sleep(1000);

			Select select = new Select(driver.findElement(By.xpath(OR.getProperty("ciscofindexact"))));

			select.selectByValue("contains");

			Thread.sleep(1000);

			driver.findElement(By.xpath(OR.getProperty("ciscofindhunt"))).clear();

			Thread.sleep(1000);

			type("ciscofindhunt", devicename);

			Thread.sleep(1000);

			click("ciscofindbtn");

			Thread.sleep(1000);

			String status = (driver.findElement(By.xpath(OR.getProperty("ciscorecordfound"))).getText());

			String expected = "1 records found";
			verifyEquals(status, expected);

			if (status.equals(expected)) {

				log.debug("Provision Success! Records find:: " + status);

				Thread.sleep(1000);
			}

			else {

				log.debug("Provision failed!  No Records find:: " + status);
			}

		}
	}

	@Test(priority = 3)
	public void mainPageOpenDeleteExtAnalog() throws InterruptedException {

		driver.get("https://192.168.110.213/pme/index.php/");

		Thread.sleep(1000);

		click("actactions");

		Thread.sleep(500);

		click("provisionactions");

		Thread.sleep(1000);

	}

	@Test(priority = 4, dataProvider = "getData")
	public void provisionDeleteExt9971(String huntpilot, String huntlistname, String linegroupname, String cucm,
			String cuc) throws InterruptedException, IOException {

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("analogjobdelete")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(2000);

		click("analogcucmuserdelete");
		Thread.sleep(1000);
		driver.findElement(By.xpath(OR.getProperty("ldapdatainput"))).sendKeys("Kenrick", Keys.ENTER);
		Thread.sleep(3000);
		click("ldapfirstoptionuser");
		Thread.sleep(20000);

		WebElement optionperformadd = (driver.findElement(By.xpath(OR.getProperty("performpro"))));

		action.moveToElement(optionperformadd);
		action.click().sendKeys(Keys.ENTER);
		action.build().perform();

		Thread.sleep(1000);

		WebElement optionperformaddagain = (driver.findElement(By.xpath(OR.getProperty("performpro"))));

		action.moveToElement(optionperformaddagain);
		action.click().sendKeys(Keys.ENTER);
		action.build().perform();

		log.debug("Click on  Delete perform");

		Thread.sleep(8000);

		boolean errormsgdisplay = (driver.findElement(By.xpath(OR.getProperty("errormsgpro")))).isDisplayed();

		if (errormsgdisplay == true) {

			log.debug("Provision Failed");
		}

		else if (errormsgdisplay == false) {

			driver.get(cucm);

			driver.get(cucm);

			Thread.sleep(4000);

			WebElement device = (driver.findElement(By.xpath(OR.getProperty("ciscodevicebutton"))));

			action.moveToElement(device).click().perform();

			Thread.sleep(1000);

			WebElement phone = (driver.findElement(By.xpath(OR.getProperty("ciscodevicephone"))));

			action.moveToElement(phone).click().perform();

			Thread.sleep(1000);

			Select select = new Select(driver.findElement(By.xpath(OR.getProperty("ciscofindexact"))));

			select.selectByValue("contains");

			Thread.sleep(1000);

			driver.findElement(By.xpath(OR.getProperty("ciscofindhunt"))).clear();

			Thread.sleep(1000);

			type("ciscofindhunt", devicename);

			Thread.sleep(1000);

			click("ciscofindbtn");

			Thread.sleep(1000);

			String status = (driver.findElement(By.xpath(OR.getProperty("ciscorecordfound"))).getText());

			String expected = "0 records found";
			verifyEquals(status, expected);

			if (status.equals(expected)) {

				log.debug("Provision Success! Data deleted from CUCM Records find:: " + status);

				Thread.sleep(1000);
			}

			else {

				log.debug("Provision failed!   Records find in CUCM:: " + status);
			}

	
		}
		
		log.debug(" Test Class Finish:  ProvisionAddExtAnalogTest");
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
