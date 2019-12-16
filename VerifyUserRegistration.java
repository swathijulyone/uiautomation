package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.VacationPageObject;

public class VerifyUserRegistration {

	String driverPath = "C:\\Users\\sasubramaniyan\\jar_files\\geckodriver.exe";

	WebDriver driver;
	VacationPageObject vacationPageObject;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.gecko.driver", driverPath);

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.hotwire.com/");
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}


	@Test(priority = 0)
	public void verifyVacationPage() {
		try {

			// Create Login Page object
			vacationPageObject = new VacationPageObject(driver);

			// Verify login page title
			String homePageTitle = vacationPageObject.getLoginTitle();
			if (homePageTitle.contains("Hotels")) {
				Assert.assertTrue(true, "Verify home page.");
			} else {
				Assert.assertFalse(true, homePageTitle + " page is not loaded.");
			}
			vacationPageObject.clickVacationLink();

			String vacationPageTitle = driver.getTitle();
			// Verify login page

			if (vacationPageTitle.contains("Vacation")) {
				Assert.assertTrue(true, "Verify 'Vacation' Page Title.");
			} else {
				Assert.assertFalse(true, vacationPageTitle + " page is loaded instead of 'Vacation' Page.");
			}

			vacationPageObject.clickFlightLink();
			vacationPageObject.clickCarLink();
			vacationPageObject.clickHotelLink();

			vacationPageObject.setFlyFromText("SFO");
			vacationPageObject.setFlyToText("LAX");

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate localDate = LocalDate.now();
			LocalDate nextDay = localDate.plusDays(1);
			LocalDate threeWeeksDate = localDate.plus(21, ChronoUnit.WEEKS);

			vacationPageObject.setDepartingText((dtf.format(nextDay)).toString());
			vacationPageObject.setReturningText((dtf.format(threeWeeksDate)).toString());

			vacationPageObject.selectDeparting();
			vacationPageObject.selectReturning();

			
			Assert.assertTrue(driver.getTitle().contains("Results"), "Search Result Page is loaded successfully.");
		}

		catch (Exception e) {
			Assert.assertFalse(true, "Exception Occured during the Execution" + e);
		}
	}

	@AfterMethod
	public void shutdown() {

		driver.close();
	}

}
