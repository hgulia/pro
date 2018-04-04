package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestBase;

public class FtpTest extends TestBase {

	@Test
	public void addFtp() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));
		click("system");

		click("ftpftp");

		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("ftpstatic"))), "page not correct");

		Thread.sleep(100);

		click("addftp");
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addstaticftp"))), "page not correct");
		type("nameftp", "QA Automation");
		type("hostnameftp", "192.168.102.24");
		type("pathftp", "/");
		type("unameftp", "Akkadian");
		type("pwdftp", "fid53103");
		click("saveftp");

	}
}
