package Testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Base.TestBase;

public class SecurityServiceGroupTest extends TestBase {

	@Test
	public void serviceGroup() throws InterruptedException {
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));
		// click("system");

		click("security");

		Thread.sleep(300);

		click("mainservicegroupsecurity");

		if (driver.findElements(By.xpath(OR.getProperty("admingroupsgroupsecurity"))).size() != 0) {

			click("admingroupsgroupsecurity");

			Thread.sleep(500);

			click("editgroupsecurity");

			click("servicegroup");

			Thread.sleep(500);

			click("leftsignservicegroupsecurity");

			Thread.sleep(500);

			click("savegroupsecurity");

			Thread.sleep(300);

		}

	}

}
