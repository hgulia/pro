package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.TestBase;

public class CreateLocalUsersTest extends TestBase {

	@Test(priority = 1, dataProvider = "getDataLogin")
	public void loginasPMEAdmin(String uname, String pwd) throws InterruptedException {

		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("unamelogin"))));

		login.sendKeys("pmeadmin");

		log.debug("Inside Login Test");

		// type("pwdlogin","PMEAdmin");

		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("PMEAdmin");

		driver.findElement(By.xpath(".//*[@id='submit']")).click();

	}

	@Test(priority = 2, dataProvider = "getDataUsers")
	public void adduser(String fname, String lname, String uname, String email, String pwd)
			throws InterruptedException {
		Thread.sleep(1000);

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));

		click("system");

		click("useruser");

		Thread.sleep(1000);

		click("adduser");

		Thread.sleep(1000);

		type("nameuser", fname);

		type("lastnameuser", lname);

		type("usernameuser", uname);

		type("emailuser", email);

		click("usertypeuser");
		driver.findElement(By.xpath(OR.getProperty("selectvaluegroups"))).sendKeys("Local", Keys.ENTER);

		Thread.sleep(1000);
		WebElement dropdown = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("groupassociationuser"))));
		dropdown.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='select2-drop']/ul/li[1]/div"))).click();

		click("saveuser");

		Thread.sleep(500);
		
		click("backuser");
		Thread.sleep(500);
		
		if (driver.findElements(By.cssSelector("a[tester-id*='hgulia']")).size() != 0) {

			System.out.println("New User created UserName = " + uname);

		}

	}

	@DataProvider
	public Object[][] getDataUsers() {

		String sheetName = "localUser";

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

	@DataProvider
	public Object[][] getDataLogin() {

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
