package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import Commons.CommonUtilities;

public class Homepageobjects extends BaseDriver {

	private static final Logger LOG = Logger.getLogger(Loginpageobjects.class);

	public CommonUtilities cm = new CommonUtilities();

	By profileimage = By.xpath("//*[@id='navbar']/div/div/div/ul/li[3]/a/img");

	public WebElement getprofileimage() {
		return driver.findElement(profileimage);
	}

	By editprofile = By.xpath("//*[@id='navbar']/div/div/div/ul/li[3]/ul/li[1]/a");

	public WebElement geteditprofile() {
		return driver.findElement(editprofile);
	}

	By logoutbtn = By.xpath("//a[contains(@href,'sign_out')]");

	public WebElement getlogoutbtn() {
		return driver.findElement(logoutbtn);
	}

	public void click_profileimage_editprofile() {
		cm.clickElement(getprofileimage());
		cm.clickElement(geteditprofile());
		LOG.info("User clicked on edit profile");
	}

	public void click_profileimage_logout() throws InterruptedException {
		LOG.info("Now validating image");
		cm.clickElement(getprofileimage());
		cm.clickElement(getlogoutbtn());
		Thread.sleep(5000);
		LOG.info("User logged out sucessfully");
	}

}
