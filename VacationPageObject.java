package pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class VacationPageObject {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	WebDriver driver;
	@FindBy(partialLinkText = "Vacations")
	WebElement vacationLink;
	
	@FindBy(xpath = "//button[contains(text(),Flight)]")
	WebElement flightLink;
	
	@FindBy(xpath = "//button[contains(text(),Hotel)]")
	WebElement hotelLink;
	
	@FindBy(xpath = "//button[contains(text(),Car)]")
	WebElement carLink;
	
	@FindBy(id = "farefinder-package-origin-location-input")
	WebElement flyFromTextBox;
	
	@FindBy(id = "	farefinder-package-destination-location-input")
	WebElement flyToTextBox;
	
	@FindBy(id = "farefinder-package-startdate-input")
	WebElement departingDateButton;
	
	@FindBy(id = "farefinder-package-enddate-input")
	WebElement returningDateButton;
	
	@FindBy(id = "farefinder-package-dropofftime-input")
	WebElement departing;
	
	@FindBy(id = "farefinder-package-pickuptime-input")
	WebElement returning;
	
	@FindBy(id = "farefinder-package-search-button")
	WebElement searchButton;
	

	
	public VacationPageObject(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

//	//Set string in textbox
	public void setText(String inputSting, WebElement locator) throws ElementNotVisibleException{
		if (locator.isEnabled()) {
			locator.sendKeys(inputSting);
		}
	}

	public void clickVacationLink() {
		if(vacationLink.isEnabled()){
			vacationLink.click();
		}else {
			Assert.assertFalse(true, "Unable to Click on the Locator.");
		}
	}
	
	public void clickFlightLink() {
		if(flightLink.isEnabled()){
			flightLink.click();
		}else {
			Assert.assertFalse(true, "Unable to Click on the Locator.");
		}
	}
	
	public void clickHotelLink() {
		if(hotelLink.isEnabled()){
			hotelLink.click();
		}else {
			Assert.assertFalse(true, "Unable to Click on the Locator.");
		}
	}
	
	public void clickCarLink() {
		if(carLink.isEnabled()){
			carLink.click();
		}else {
			Assert.assertFalse(true, "Unable to Click on the Locator.");
		}
	}
	
	public void setDepartingText(String inputString) throws ElementNotVisibleException{
		if (departingDateButton.isEnabled()) {
			departingDateButton.sendKeys();
		}
	}
	
	public void setReturningText(String inputString) throws ElementNotVisibleException{
		if (returningDateButton.isEnabled()) {
			returningDateButton.sendKeys(inputString);
		}
	}
	
	public void setFlyFromText(String inputString) throws ElementNotVisibleException{
		if (flyFromTextBox.isEnabled()) {
			flyFromTextBox.sendKeys(inputString);
			flyFromTextBox.sendKeys(Keys.ARROW_DOWN);
		}
		
	}
	
	public void setFlyToText(String inputString) throws ElementNotVisibleException{
		if (flyToTextBox.isEnabled()) {
			flyToTextBox.sendKeys(inputString);
			flyToTextBox.sendKeys(Keys.ARROW_DOWN);
		}
	}
	
	public void selectDeparting() throws ElementNotVisibleException{
		if (departing.isEnabled()) {
			Select drpValue = new Select(departing);
			drpValue.deselectByIndex(2);
			
		}
	}
	
	public void selectReturning() throws ElementNotVisibleException{
		if (returning.isEnabled()) {
			Select drpValue = new Select(returning);
			drpValue.deselectByIndex(0);
			
		}
	}
	
	public void clickLink(String inputSting, WebElement locator) throws ElementNotVisibleException{
		if(locator.isEnabled()){
			locator.click();
		}else {
			Assert.assertFalse(true, "Unable to Click on the Locator.");
		}
	}
	
	public void clickRegisterButton() {
		searchButton.click();
	}
	
	// Get the title of Login - My StorePage
	public String getLoginTitle() {
		return driver.getTitle();
	}

}
