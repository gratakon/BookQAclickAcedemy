package Commons;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.BaseDriver;

public class CommonUtilities extends BaseDriver {

	private static final Logger LOG = Logger.getLogger(CommonUtilities.class);

	/**
	 * Verify that the passed object Text is present.
	 * 
	 * @param object Web element to be validated
	 * @throws Exception
	 */
	public void verifyTextPresent(final String object) throws Exception {
		try {
			LOG.info("Verifiy text is present in a webPage");
			String Verifytext = driver.findElement(By.tagName("body")).getText().trim();
			Assert.assertTrue(Verifytext.contains(object));
			LOG.info(object);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Typing the text to textbox using the JavaScriptExecutor
	 * 
	 * @param element
	 * @param text
	 * @throws InterruptedException
	 */
	public void jseTypeText(WebElement element, String text) throws InterruptedException {
		LOG.info("Typing text using the JavaScriptExecutor and the text is " + text);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
		Thread.sleep(2000);
		executor.executeScript("arguments[0].value='" + text + "'", element);
		Thread.sleep(1000);
		element.sendKeys(Keys.TAB);
	}

	/**
	 * User enter text in to textField
	 *
	 * 
	 * @author Guru (arkku6)
	 * 
	 */
	public void typeTextToTextBox(WebElement element, String text) throws Exception {
		try {
			LOG.info("Enter text in to textField: " + text);
			clearText(element);
			element.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Element is NOT available " + element);
		}
	}

	/**
	 * User clear text in text field
	 * 
	 */
	public void clearText(WebElement element) throws Exception {
		LOG.info("Clear text in text field");
		element.clear();
	}

	/**
	 * Click on a element
	 * 
	 * @param element
	 */
	public void clickElement(WebElement object) {
		LOG.info("Click " + object);
		try {
			object.click();
		} catch (final Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Verify expected element is displayed.
	 * 
	 * @param object Web element to be validated
	 * @throws Exception
	 */
	public boolean validateElementDisplayed(final WebElement elementName) throws Exception, Exception {
		LOG.info("Verify expected element is displayed");
		boolean actualValue = elementName.isDisplayed();

		if (actualValue) {
			LOG.debug("expected element" + elementName.getText() + " is present");
		} else {
			throw new Exception("Object should be displayed, Object is is not displaying");
		}
		return actualValue;
	}

	/**
	 * Verify expected element is enabled.
	 * 
	 * @param object Web element to be validated
	 * @throws Exception
	 */
	public boolean validateElementEnabled(final WebElement elementName) throws Exception, Exception {
		LOG.info("Verify expected element is Enabled");
		boolean actualValue = elementName.isEnabled();

		if (actualValue) {
			LOG.debug("expected element" + elementName.getText() + " is Enabled");
		} else {
			throw new Exception("Object should be Enabled, Object is is not Enabled");
		}
		return actualValue;
	}

	/**
	 * Verify expected element is selected.
	 * 
	 * @param object Web element to be validated
	 * @throws Exception
	 */

	public boolean validateElementSelected(final WebElement elementName) throws Exception, Exception {
		LOG.info("Verify expected element is displayed");
		boolean actualValue = elementName.isSelected();

		if (actualValue) {
			LOG.debug("expected element" + elementName.getText() + " is Selected");
		} else {
			throw new Exception("Object should be Selected, Object is is not Selected");
		}
		return actualValue;
	}

	/**
	 * Verify expected element is not selected.
	 * 
	 * @param object Web element to be validated
	 * @throws Exception
	 */

	public boolean validateElementNotSelected(final WebElement elementName) throws Exception, Exception {
		LOG.info("Verify expected element is displayed");
		boolean actualValue = elementName.isSelected();

		if (actualValue == false) {
			LOG.debug("expected element" + elementName.getText() + " is not Selected");
		} else {
			throw new Exception("Object should not be Selected, Object is Selected");
		}
		return actualValue;
	}

	/**
	 * Wait till expected element is displayed.
	 * 
	 * @param object Web element to be validated
	 * @return
	 * @throws Exception
	 */
	public void ExplicitWaitForVisiBility(WebElement ele) {
		LOG.info("Explicitly Waiting for Element");
		WebDriverWait Wait = new WebDriverWait(driver, 60);
		Wait.until(ExpectedConditions.visibilityOf(ele));
		LOG.info("Got the Element" + ele);

	}

	/**
	 * Java script executor click.
	 * 
	 * @param object Web element to be validated
	 * @return
	 * @throws Exception
	 */

	public void jseClick(WebElement element) throws Exception {
		try {
			LOG.info("Clicking on the Element " + element);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception("Element is NOT available " + element);
		}

	}

	/**
	 * mouse hover on element.
	 * 
	 * @param object Web element to be validated
	 * @return
	 * @throws Exception
	 */

	public void clickonapoint(WebElement element) {

		Point point = element.getLocation();
		int xcord = point.getX();
		System.out.println("Position of the webelement from left side is " + xcord + " pixels");
		int ycord = point.getY();
		System.out.println("Position of the webelement from top side is " + ycord + " pixels");
		Actions actions = new Actions(driver);
		// actions.moveToElement(element).click().build().perform();
		actions.moveToElement(element, xcord, ycord).click().build().perform();

	}

	public void mousehoverclick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}

	public void ExplicitWaitelementclickable(WebElement ele) {
		LOG.info("Explicitly Waiting for Element to be clickable");
		WebDriverWait Wait = new WebDriverWait(driver, 60);
		Wait.until(ExpectedConditions.elementToBeClickable(ele));
		LOG.info("Got the Element" + ele);

	}

	public void HighlightElement(WebElement ele) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
	}

}
