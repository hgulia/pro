package Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import Base.TestBase;

public class ConfigurationTest extends TestBase {

	@Test(priority = 1)
	public void emailconfiguration() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("system"))));
		click("system");

		click("config");
		Thread.sleep(100);

		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("emailstatic"))), "page not correct");

		driver.findElement(By.xpath(OR.getProperty("smtpdomain"))).clear();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("smtpdomain"))));

		type("smtpdomain", "https://www.fidelus.com/");

		System.out.println(driver.findElement(By.xpath(OR.getProperty("smtpdomain"))).getAttribute("value"));

		/*
		 * WebElement savebtn = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(
		 * "savebtnconfig")))); savebtn.click();
		 * 
		 * WebElement elementemailmsg = wait
		 * .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(
		 * "successmsgconfig")))); System.out.println("Email config successfully saved"
		 * +
		 * (driver.findElement(By.xpath(OR.getProperty("successmsgconfig"))).getText()))
		 * ;
		 */

	}

	@Test(priority = 2)
	public void singlesignon() throws InterruptedException, IOException {
		Thread.sleep(100);
		click("singlesignon");

		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("singlesignstatic"))), "page not correct");

		WebElement elementcheckbox = (driver.findElement(By.xpath(OR.getProperty("activesso"))));

		if (!elementcheckbox.isSelected()) {
			elementcheckbox.click();
		}

		else {
			WebElement elementmetaradio = (driver.findElement(By.xpath(OR.getProperty("metadataurlradio"))));

			if (!elementmetaradio.isSelected()) {
				elementmetaradio.click();
			}

		}

		type("metadataurltext", "https://192.168.110.185/pme/index.php/user/metadata");

		// WebElement elementmetamsg = wait
		// .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("successmsgmeta"))));

		// System.out.println("Metadata URL successfully saved"
		// +
		// (driver.findElement(By.xpath(OR.getProperty("successmsgmeta"))).getText()));

		WebElement elementmetaradio = (driver.findElement(By.xpath(OR.getProperty("manualradio"))));
		if (!elementmetaradio.isSelected()) {

			elementmetaradio.click();
		}
		Thread.sleep(100);

		String actualString = driver.findElement(By.xpath(OR.getProperty("idpurl"))).getAttribute("value");

		System.out.println(actualString);

		verifyEquals(actualString, "https://sso.jumpcloud.com/saml2/saml2");

	}

	@Test(priority = 3)
	public void branding() throws InterruptedException {
		Thread.sleep(100);
		click("branding");

		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("brandingstatic"))), "page not correct");
		driver.findElement(By.xpath(OR.getProperty("companyname"))).clear();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("companyname"))));

		type("companyname", "AkkadianLabs Automation");

		driver.findElement(By.xpath(OR.getProperty("helpurl"))).clear();

		type("helpurl", "http://akkadianlabs.com");
		// driver.findElement(By.xpath(OR.getProperty("image"))).getAttribute("value");

		// WebElement image = (WebElement)
		// if(!driver.findElements(By.xpath(OR.getProperty("image"))).isEmpty()) {

		// WebElement deletecheckbox =
		// (driver.findElement(By.xpath(OR.getProperty("deletecheckbox"))));

		// if (!deletecheckbox.isSelected()) {
		// deletecheckbox.click();

		// }

		// }

		// else {

		// WebElement uploadFile
		// =(driver.findElement(By.xpath(OR.getProperty("browse"))));

		// uploadFile.sendKeys("C:\Users\hgulia\eclipse-workspace\PME\src\test\resources\Testfiles\seimage.jpeg");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("companyname"))));
		click("companyname");

		/*
		 * WebElement elemenbulkmsg = wait
		 * .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(
		 * "successmsgbranding")))); System.out.println("Branding successfully saved" +
		 * (driver.findElement(By.xpath(OR.getProperty("successmsgbranding"))).getText()
		 * ));
		 */
	}

	@Test(priority = 4)
	public void bulkProvisioningConfig() throws InterruptedException {
		Thread.sleep(100);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("bulkpro"))));
		click("bulkpro");

		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("bulkstatic"))), "page not correct");
		driver.findElement(By.xpath(OR.getProperty("batchsize"))).clear();
		Thread.sleep(1000);
		// Hard code
		type("batchsize","500");
		Thread.sleep(1000);
		click("savebulk");
		
		Thread.sleep(1000);
		
		

	}
}
