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

public class ProvisionLocalVoiceTest extends TestBase {

	@Test(priority = 1)
	public void mainPageOpenLocalVoice() throws InterruptedException {
		
		log.debug(" Test Class Start:  ProvisionLocalVoiceTest");

		driver.get("https://192.168.110.213/pme/index.php/");

		Thread.sleep(1000);

		click("actactions");

		Thread.sleep(500);

		click("provisionactions");

		Thread.sleep(1000);

	}

	@Test(priority = 2, dataProvider = "getData")
	public void provisionLocalVoice(String huntpilot, String huntlistname, String linegroupname, String cucm,
			String cuc) throws InterruptedException, IOException {

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("localvoicemailjob")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(2000);

		type("localaliasentry", "hgulia");

		type("localemailentry", "hgulia@akkadianlabs.com");

		type("localfirstnameentry", "Hitender");

		type("locallastnameentry", "Gulia");

		type("localusernameentry", "hgulialocal");

		type("localpasswordentry", "manu123456");

		type("localpinentry", "1980");

		Thread.sleep(2000);

		click("localcucusername");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("ldapdatainput"))).sendKeys("Kenrick", Keys.ENTER);
		Thread.sleep(2000);
		click("ldapfirstoptionuser");
		Thread.sleep(8000);

		click("localcucmline");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("ldapdatainput"))).sendKeys("1223", Keys.ENTER);
		Thread.sleep(2000);
		click("ldapfirstoptionuser");
		Thread.sleep(2000);

		click("localtemplatedata");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("ldapdatainput"))).sendKeys("NFL Test", Keys.ENTER);
		Thread.sleep(2000);
		click("ldapfirstoptionuser");
		Thread.sleep(8000);

		click("performpro");

		System.out.println("Click on perform");

		Thread.sleep(2000);

		boolean errormsgdisplay = (driver.findElement(By.xpath(OR.getProperty("errormsgpro")))).isDisplayed();

		if (errormsgdisplay == true) {

			System.out.println("Provision Failed");
		}

		else if (errormsgdisplay == false) {

			driver.get(cuc);

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

			type("ciscofindhunt", "hgulia");

			Thread.sleep(1000);

			click("ciscofindbtn");

			Thread.sleep(1000);

			String status = (driver.findElement(By.xpath(OR.getProperty("ciscocucmsg"))).getText());

			String expected = "  Found 1 User(s)";
			verifyEquals(status, expected);

			if (status.equals(expected)) {

				System.out.println("Provision Success! Records find:: " + status);

			}

			else {

				System.out.println("Provision Failed! Records not  found:: " + status);

			}
		}
	}

	@Test(priority = 3)
	public void mainPageOpenDeleteLocalVoice() throws InterruptedException {

		driver.get("https://192.168.110.213/pme/index.php/");

		Thread.sleep(1000);

		click("actactions");

		Thread.sleep(500);

		click("provisionactions");

		Thread.sleep(1000);

	}

	@Test(priority = 4, dataProvider = "getData")
	public void provisionDeleteLocalVoice(String huntpilot, String huntlistname, String linegroupname, String cucm,
			String cuc) throws InterruptedException, IOException {

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("ldapvoicemailjobdelete")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(2000);

		click("ldapvoicecucmusernamedelete");
		Thread.sleep(1000);
		driver.findElement(By.xpath(OR.getProperty("ldapdatainput"))).sendKeys("hgulia", Keys.ENTER);
		Thread.sleep(4000);
		click("ldapoptionuserdelete");

		Thread.sleep(10000);

		click("performpro");

		System.out.println("Click on perform delete");

		Thread.sleep(4000);

		boolean errormsgdisplay = (driver.findElement(By.xpath(OR.getProperty("errormsgpro")))).isDisplayed();

		if (errormsgdisplay == true) {

			System.out.println("Provision Failed");
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

			type("ciscofindhunt", "hgulia");

			Thread.sleep(1000);

			click("ciscofindbtn");

			Thread.sleep(1000);

			String status = (driver.findElement(By.xpath(OR.getProperty("ciscocucmsg"))).getText());

			String expected = "  Found 0 User(s)";
			verifyEquals(status, expected);

			if (status.equals(expected)) {

				System.out.println("Provision Success! Records Deleted:: " + status);

			}

			else {

				System.out.println("Provision Failed! Records find:: " + status);

			}
		}
		
		log.debug(" Test Class Finish:  ProvisionLocalVoiceTest");

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
