package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;

public class LoginTest extends TestBase {
	
	@Test(dataProvider = "getData")
	public void loginasPMEAdmin(String uname, String pwd) throws InterruptedException {
		log.debug("Login Class Start");
		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("unamelogin"))));

		login.sendKeys(uname);

		log.debug("Inside Login Test");

		Thread.sleep(200);

		WebElement pwddata = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("pwdlogin"))));

		pwddata.sendKeys(pwd);

		WebElement sign = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("signinlogin"))));

		sign.click();

		Thread.sleep(300);

		log.debug("Login Successfully executed");
		
		log.debug("Login Class Finish");
	}

	@DataProvider
	public Object[][] getData() {

		String sheetName = "LoginProvision";

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
