package pageObjects;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Commons.CommonUtilities;
import cucumber.api.java.Before;

public class Loginpageobjects extends BaseDriver {

	private static final Logger LOG = Logger.getLogger(Loginpageobjects.class);

	public WebDriver driver;
	public CommonUtilities cm = new CommonUtilities();

	By PopupNoThanks = By.xpath("//button[text()='NO THANKS']");

	public WebElement getpopupNoThanks() {
		return driver.findElement(PopupNoThanks);
	}

	By Homeinfo = By.xpath("//span[text()='(+1) 323-744-6780']//following::span[text()='info@qaclickacademy.com']");

	public WebElement getHomeinfolink() {
		return driver.findElement(Homeinfo);
	}
	
	By phonelink = By.xpath("//span[text()='info@qaclickacademy.com']//preceding::span[text()='(+1) 323-744-6780']");

	public WebElement getphonelink() {
		return driver.findElement(phonelink);
	}
	

	By Title = By.xpath("//h2[text()='Featured Courses']");

	public WebElement getTitle() {
		return driver.findElement(Title);
	}

	By Header = By.xpath("//*[@id='homepage']/header/div[2]/div/nav/ul");

	public WebElement getHeader() {
		return driver.findElement(Header);
	}

	By Loginbutton = By.xpath("//span[text()='Login']");

	public WebElement getLoginButton() {
		return driver.findElement(Loginbutton);
	}

	By username = By.xpath("//input[@id='user_email']");

	public WebElement getusername() {
		return driver.findElement(username);
	}

	By password = By.xpath("//input[@id='user_password']");

	public WebElement getpassword() {
		return driver.findElement(password);
	}

	By submit_btn = By.xpath("//input[@name='commit']");

	public WebElement getsubmitbutton() {
		return driver.findElement(submit_btn);
	}

	By mycourses = By.xpath("//a[contains(@href,'enrolled')]");

	public WebElement getmycourses() {
		return driver.findElement(mycourses);
	}

	By allcourses = By.xpath("//a[@href='/courses']");

	public WebElement getallcourses() {
		return driver.findElement(allcourses);
	}

	public void browserup() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("URL"));
		LOG.info("Broswer is open and running");

	}

	public void loginpage_popup() throws IOException {

		try {
			cm.clickElement(getpopupNoThanks());
			LOG.info("Homepage POPUP closed sucessfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void validate_QaclickHomeinfo() throws Exception {

		cm.ExplicitWaitForVisiBility(getHomeinfolink());

		if (cm.validateElementDisplayed(getHomeinfolink())) {
			LOG.info("Home page Info link is displaying");
			cm.HighlightElement(getHomeinfolink());
		}

		else {

			LOG.error("Home page Info link is not displaying");

		}
	}

	public void validate_telephonelink() throws Exception {

		cm.ExplicitWaitForVisiBility(getphonelink());

		if (cm.validateElementDisplayed(getphonelink())) {
			LOG.info("Home page Info link is displaying");
			cm.HighlightElement(getphonelink());
		}

		else {

			LOG.error("Phone link is not displaying");

		}
	}
	
	public void validate_mycourses() throws Exception {

		cm.ExplicitWaitForVisiBility(getmycourses());

		if (cm.validateElementDisplayed(getmycourses())) {
			LOG.info("My courses link is displaying");
			cm.HighlightElement(getmycourses());
		}

		else {

			LOG.error("My courses link is not displaying");

		}
	}

	public void validate_allcourses() throws Exception {

		cm.ExplicitWaitForVisiBility(getallcourses());

		if (cm.validateElementDisplayed(getallcourses())) {
			LOG.info("All courses link is displaying");
			cm.HighlightElement(getallcourses());
		}

		else {

			LOG.error("All courses link is not displaying");

		}
	}

	public void loginTo_QAclick(String username, String password) throws Exception {
		cm.clickElement(getLoginButton());
		cm.typeTextToTextBox(getusername(), username);
		cm.typeTextToTextBox(getpassword(), password);
		cm.validateElementEnabled(getsubmitbutton());
		cm.clickElement(getsubmitbutton());
		LOG.info("User Logged in sucessfully");
	}

}
