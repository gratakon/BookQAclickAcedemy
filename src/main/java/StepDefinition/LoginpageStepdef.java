package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Editpageobjects;
import pageObjects.Homepageobjects;
import pageObjects.Loginpageobjects;

public class LoginpageStepdef {

	public Loginpageobjects LPO = new Loginpageobjects();
	public Homepageobjects HPO = new Homepageobjects();
	public Editpageobjects EPO = new Editpageobjects();

	@Given("^User Enter \"([^\"]*)\" and \"([^\"]*)\" to Login to QAclick$")
	public void user_Enter_and_to_Login_to_QAclickGiven_User_Login_to_QAclick(String username, String password)
			throws Throwable {
		LPO.browserup();
		LPO.loginpage_popup();
		LPO.loginTo_QAclick(username, password);

	}

	@And("^Verify QAclick Info link is displaying$")
	public void Verify_QAclick_Info_link_is_displaying() throws Exception {
		LPO.validate_QaclickHomeinfo();

	}
	
	@And ("^Verify phone link is displaying$")
	public void Verify_phone_link_is_displaying() throws Exception {
		LPO.validate_telephonelink();

	}

	@Then("^click on profile Image and edit profile$")
	public void click_on_profile_Image_and_edit_profile() {
		HPO.click_profileimage_editprofile();
	}

	@And("^Verify the Notification Preferences checkbox one is selected$")
	public void Verify_the_Notification_Preferences_checkbox_one_is_selected() throws Exception {

		EPO.notifycheckbox_selected();

	}

	@When("^User save changes$")
	public void User_save_changes() {
		EPO.savechanges();

	}

	@And("^Verify the save changes success message is displayed$")
	public void Verify_the_save_changes_success_message_is_displayed() throws Exception {
		EPO.verifysucessmessage();

	}

	@Then("^Click on profile Image and Logout$")
	public void navback_logout() throws InterruptedException {
		// EPO.getnavbackbutton();
		HPO.click_profileimage_logout();

	}

	@Then("^User will close the window$")
	public void closewind() {
		EPO.closewindow();
	}

	@And("^Verify My courses link is displaying$")
	public void verify_mycourseslink() throws Exception {
		LPO.validate_mycourses();
	}

	@And("^Verify all courses link is displaying$")
	public void verify_allcourseslink() throws Exception {
		LPO.validate_allcourses();
	}

}
