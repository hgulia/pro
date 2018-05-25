package Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class ProvisionCreateHuntListTest extends TestBase {

	@Test(priority = 1)
	public void mainPageOpenLgm() throws InterruptedException {
		log.debug(" Test Class Start:  ProvisionLgmTest");

		driver.get("https://192.168.110.213/pme/index.php/");

		Thread.sleep(1000);

		click("actactions");

		Thread.sleep(500);

		click("provisionactions");

		Thread.sleep(1000);

	}

	@Test(priority = 2, dataProvider = "getData")
	public void provisionHuntList(String huntpilot, String huntlistname, String linegroupname, String cucm, String cuc)
			throws InterruptedException, IOException {

		Actions action = new Actions(driver);

		WebElement jobsource = driver.findElement(By.xpath(OR.getProperty("addstandardforwardprojob4")));

		WebElement jobtarget = driver.findElement(By.xpath(OR.getProperty("jobtargetactions")));

		action.dragAndDrop(jobsource, jobtarget).build().perform();

		Thread.sleep(1000);

		type("huntlistnameaddjob4", huntlistname);

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

		Thread.sleep(2000);
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