package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Commons.CommonUtilities;
import cucumber.api.java.After;

public class Editpageobjects extends BaseDriver {

	public CommonUtilities cm = new CommonUtilities();
	private static final Logger LOG = Logger.getLogger(Editpageobjects.class);

	By notifybox = By.xpath("//input[@name='preference_attributes[comment_responses]' and @type='checkbox']");

	public WebElement getnotifybox() {
		return driver.findElement(notifybox);
	}

	By savechangebtn = By.xpath("//button[@id='edit-user-submit' and @type='submit']");

	public WebElement getsavechangebtn() {
		return driver.findElement(savechangebtn);
	}

	By sucessmessage = By.xpath("//div[@id='form-success' and @role='alert']");

	public WebElement getsucessmessage() {
		return driver.findElement(sucessmessage);
	}

	By navbackbutton = By.xpath("//i[contains(@class,'fa-angle-left')]");

	public WebElement getnavbackbutton() {
		return driver.findElement(navbackbutton);
	}

	public void notifycheckbox_selected() throws Exception {
		cm.validateElementSelected(getnotifybox());
	}

	public void savechanges() {
		cm.clickElement(getsavechangebtn());
		LOG.info("Changes are saved");
	}

	public void verifysucessmessage() throws Exception {

		String sccmsg = getsucessmessage().getText();
		cm.verifyTextPresent(sccmsg);
		LOG.info("Save changes sucess message displayed");

	}

	public void click_on_backnavbtn() {
		cm.mousehoverclick(getnavbackbutton());
		LOG.info("Navigate back button clicked");

	}

	public void closewindow() {

		LOG.info("Browser will close now");
		driver.close();
		// driver=null;

	}

}
