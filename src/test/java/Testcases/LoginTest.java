package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class LoginTest extends TestBase {

	@Test(dataProvider = "getData")
	public void loginasPMEAdmin(String uname, String pwd) throws InterruptedException {

		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("unamelogin"))));

		login.sendKeys(uname);

		log.debug("Inside Login Test");

		type("pwdlogin", pwd);

		click("signinlogin");

		// Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("system"))),
		// "Login not successful");

		//driver.findElement(By.xpath(OR.getProperty("main"))).click();

		Thread.sleep(300);
		//driver.findElement(By.xpath(OR.getProperty("unlock"))).click();
		Thread.sleep(100);
		click("system");

		log.debug("Login Successfully executed");
	}

	@DataProvider
	public Object[][] getData() {

		String sheetName = "LoginTest";

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
