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

public class ProvisionAddExt9971Test extends TestBase {

	String macid;

	@Test(priority = 1)
	public void mainPageOpenAddExt9971() throws InterruptedException {
		log.debug(" Test Class Start:  ProvisionAddExt9971Test");
		
		driver.get("https://192.168.110.213/pme/index.php/");

		Thread.sleep(1000);

		click("actactions");

		Thread.sleep(500);

		click("provisionactions");

		Thread.sleep(1000);

	}

	@Test(priority = 2, dataProvider = "getData")
	public void provisionAddExt9971(String huntpilot, String huntlistname, String linegroupname, String cucm,
			String cuc) throws InterruptedException, IOException {

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("9971job")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(2000);

		type("9971phonedevice", "7910phone");

		Thread.sleep(1000);

		click("9971cucmuser");
		Thread.sleep(1000);
		driver.findElement(By.xpath(OR.getProperty("ldapdatainput"))).sendKeys("Kenrick", Keys.ENTER);
		Thread.sleep(3000);
		click("ldapfirstoptionuser");
		Thread.sleep(10000);

		click("9971cucmline");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("ldapdatainput"))).sendKeys("1223", Keys.ENTER);
		Thread.sleep(2000);
		click("ldapfirstoptionuser");
		Thread.sleep(2000);

		type("9971deviceprofile", "7901profile");

		Thread.sleep(3000);

		WebElement element = waitExplicit
				.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("9971generatecode"))));

		element.click();
		// click("9971generatecode");

		Thread.sleep(4000);

		macid = driver.findElement(By.xpath(OR.getProperty("9971storecode"))).getAttribute("value");

		Thread.sleep(8000);

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

				click("ciscofindenduser");

				Thread.sleep(1000);

				Select selectdevice = new Select(driver.findElement(By.xpath(OR.getProperty("ciscodevice9971"))));

				selectdevice.selectByVisibleText(macid);

				WebElement option = selectdevice.getFirstSelectedOption();

				String devicecuc = option.getText();

				Thread.sleep(1000);

				if (devicecuc.equals(macid)) {

					log.debug("Mac Device id is matched in CUC");

				}

				else {

					log.debug("Mac Device id is not matched in CUC");
				}

				Select selectpro = new Select(driver.findElement(By.xpath(OR.getProperty("ciscoprofile9971"))));

				selectpro.selectByVisibleText("7901profile");

				WebElement optionpro = selectpro.getFirstSelectedOption();

				String deviceprofile = optionpro.getText();

				if (deviceprofile.equals("7901profile")) {

					log.debug("Device profile is matched in CUC");

				}

				else {

					log.debug("Device profile is not matched in CUC");
				}

			} else {

				log.error("No records");
			}
		}
	}

	@Test(priority = 3)
	public void mainPageOpenDeleteExt9971() throws InterruptedException {

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

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("9971jobdelete")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(2000);

		click("9971cucmuserdelete");
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

			Thread.sleep(4000);

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

				click("ciscofindenduser");

				Select selectdevice = new Select(driver.findElement(By.xpath(OR.getProperty("ciscodevice9971"))));
				try {

					selectdevice.selectByVisibleText(macid);

					WebElement option = selectdevice.getFirstSelectedOption();

					String devicecuc = option.getText();

					Thread.sleep(1000);

					if (devicecuc.equals(macid)) {

						log.debug(" Delete Provision Failed! Mac Device id is matched in CUC");

					}

					else {

						log.debug("Delete Provision Success! Mac Device id is Deleted in CUC");
					}
				} catch (Exception e) {
					log.debug("Delete Provision Success! Mac Device id is Deleted in CUC");
				}

				try {
					Select selectpro = new Select(driver.findElement(By.xpath(OR.getProperty("ciscoprofile9971"))));

					selectpro.selectByVisibleText("7901profile");

					WebElement optionpro = selectpro.getFirstSelectedOption();

					String deviceprofile = optionpro.getText();

					if (deviceprofile.equals("7901profile")) {

						log.debug("Delete Provision Failed! Device profile is matched in CUC");

					}

					else {

						log.debug("Delete Provision Success! Device profile is Deleted in CUC");
					}

				} catch (Exception e) {

					log.debug("Delete Provision Success! Device profile is Deleted in CUC");
				}

			} else {

				log.error("No records");
			}
		}
		log.debug(" Test Class Finish:  ProvisionAddExt9971Test");
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
