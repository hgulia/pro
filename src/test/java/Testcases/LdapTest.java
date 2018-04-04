package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.TestBase;
import Utilities.TestUtil;

public class LdapTest extends TestBase {

	

	//@Test(dataProvider = "getDataLdap")
	// (dataProviderClass=TestUtil.class,dataProvider= "dp")
	@Test
	public void ldaptest() throws InterruptedException {
		// String configname,String base,String server,String port,String uname,String
		// pwd,String unamebind) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));
		click("system");

		click("ldapldap");
		Thread.sleep(100);

		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("ldapstatic"))), "page not correct");

		click("addldap");

		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addstaticldap"))), "page not correct");

		type("nameldap", "QA Automation");
		type("baseldap", "dc=fidelus,dc=com");
		type("serverldap", "192.168.100.16");
		type("portldap", "389");
		type("unameldap", "CN=QA Service,OU=Service Accounts,OU=Users,OU=Development,OU=Fidelus,DC=fidelus,DC=com");
		type("pwdldap", "Password$!");
		type("unamebind", "sAMAccountName");
		click("saveldap");

	}

	/*
	 * @Test(priority = 2) public void searchname() {
	 * 
	 * type("searchnameldap", "QA Automation");
	 * 
	 * System.out.println(driver.findElement(By.xpath(OR.getProperty(
	 * "showinglistentriesldap"))).getText());
	 * 
	 * }
	 */

	@DataProvider
	public Object[][] getDataLdap() {

		String sheetName = "ServerName";

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