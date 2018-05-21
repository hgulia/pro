package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.ExcelReader;
import Utilities.ExtentManager;
import Utilities.TestUtil;

public class TestBase {

	public static WebDriver driver;

	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\TestDataLocalTemplates.xlsx");
	public static WebDriverWait wait;
	public static WebDriverWait waitExplicit;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;

	@BeforeSuite
	public void setUp() {

		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\Config.properties");
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

			try {
				config.load(fis);
				log.debug("Config file is loaded!!!");
			} catch (IOException e1) {

				e1.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\OR.properties");
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

			try {
				OR.load(fis);
				log.debug("OR file is loaded!!!");
			} catch (IOException e) {

				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\hgulia\\eclipse-workspace\\PmeProvisionJobs\\src\\test\\resources\\Executables\\geckodriver.exe");

				driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\hgulia\\eclipse-workspace\\PmeProvisionJobs\\src\\test\\resources\\Executables\\chromedriver.exe");

				driver = new ChromeDriver();
				log.debug("Chrome launched!!!");

			} else if (config.getProperty("browser").equals("ie")) {
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\hgulia\\eclipse-workspace\\PmeProvisionJobs\\src\\test\\resources\\Executables\\IEDriverServer.exe");

				driver = new InternetExplorerDriver();

			}

			driver.get(config.getProperty("testingurl"));
			log.debug("Navigated to : " + config.getProperty("testingurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 20);

			waitExplicit = new WebDriverWait(driver, 30);
		}

	}

	public void click(String locator) {

		driver.findElement(By.xpath(OR.getProperty(locator))).click();

		test.log(LogStatus.INFO, "Clicking on : " + locator);

	}

	public void type(String locator, String value) {

		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);

		test.log(LogStatus.INFO, "Typing in : " + locator + "Entered Value as " + value);
	}

	public boolean isElementPresent(By by) {
		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}

	static WebElement dropedown;

	public void select(String locator, String value) {

		dropedown = driver.findElement(By.xpath(OR.getProperty(locator)));

		Select select = new Select(dropedown);
		select.selectByVisibleText(value);
		test.log(LogStatus.INFO, "Selecting from dropedown : " + locator + "Value as " + value);
	}

	public void softAssert() {
		SoftAssert softAssertion = new SoftAssert();
		// softAssertion.assertTrue(false);

	}

	public static void verifyEquals(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			TestUtil.captureScreenshot();
			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\"href=" + TestUtil.screenshotName + ")img src=" + TestUtil.screenshotName
					+ " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			// ExtentReport

			test.log(LogStatus.FAIL, "Verification failed with exception : " + t.getMessage() + "<br>");
			test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		}
	}

	/*
	 * @AfterSuite public void tearDown() { if (driver != null) { driver.quit();
	 * 
	 * }
	 * 
	 * log.debug("Test execution completed!!!");
	 */

}
