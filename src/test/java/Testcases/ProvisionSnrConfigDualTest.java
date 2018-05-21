package Testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class ProvisionSnrConfigDualTest extends TestBase {

	@Test(priority = 1)
	public void mainPageOpen() throws InterruptedException {

		click("main");

		Thread.sleep(500);

		click("unlock");

		Thread.sleep(500);

		click("actactions");

		Thread.sleep(500);

		click("provisionactions");

		Thread.sleep(1000);

	}

	@Test(priority = 2, dataProvider = "getData")
	public void provision(String huntpilot, String huntlistname, String linegroupname,String cucm,String cuc)
			throws InterruptedException, IOException {

		String huntpilotactual;
		String huntlistctual;
		String status;
		String expected;

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("addjob6")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(1000);

		click("snrconfiguser");

		Thread.sleep(1000);

		driver.findElement(By.xpath(OR.getProperty("snrinputuser"))).sendKeys("hgulia", Keys.ENTER);

		Thread.sleep(2000);

		click("snrconfigdirnumber");

		Thread.sleep(1000);

		click("snrconfigdirnumberoption");

		Thread.sleep(1000);

		type("snrconfigrdpname", "SNRQAAUTO");

		type("snrconfigdualname", "SNRRDPQAAUTO");

		click("snrconfigdualphone");

		Thread.sleep(1000);

		click("snrconfigdualphoneoption");

		Thread.sleep(1000);

		click("snrconfigdualdevice");

		Thread.sleep(1000);

		click("snrconfigdualdeviceoption");

		Thread.sleep(1000);

		type("snrconfigdualnumber", huntpilot);

		Thread.sleep(1000);

		click("performpro");

		System.out.println("Click on perform");

		Thread.sleep(2000);

		boolean errormsgdisplay = (driver.findElement(By.xpath(OR.getProperty("errormsgpro")))).isDisplayed();

		if (errormsgdisplay == true) {

			System.out.println("Provision Failed");
		}

		else if (errormsgdisplay == false) {

			driver.get("https://192.168.110.81/ccmadmin/index.jsp");

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

			WebElement huntlist = (driver.findElement(By.xpath(OR.getProperty("ciscolinegroup"))));

			action.moveToElement(huntlist).click().perform();

			Thread.sleep(1000);

			type("ciscofindhunt", linegroupname);

			Thread.sleep(1000);

			click("ciscofindbtn");

			Thread.sleep(1000);

			status = (driver.findElement(By.xpath(OR.getProperty("ciscorecordfound"))).getText());

			expected = "1 records found";
			verifyEquals(status, expected);

			if (status.equals(expected)) {

				System.out.println("Provision Success! Records find:: " + status);

				click("ciscofindentrylinegroup");

				Thread.sleep(1000);

				huntpilotactual = (driver.findElement(By.xpath(OR.getProperty("ciscolinegrouptactual")))
						.getAttribute("value"));

				System.out.println(huntpilotactual);

				Thread.sleep(1000);

				if (huntpilotactual.equals(linegroupname)) {

					Thread.sleep(1000);

					click("ciscodelete");

					Thread.sleep(1000);

					Alert alert = driver.switchTo().alert();

					alert.accept();

					System.out.println("found expected data and delete");

				} else {
					System.out.println("Provision Success! Records not Match:: ");
				}
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