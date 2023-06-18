package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups= {"Regression","Master"}) //Step8 groups added
	public void test_account_Registration() throws InterruptedException {

		logger.info("*** Starting TC_001_AccountRegistrationTest ***");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MY AccountLink");
			hp.clickRegister();
			logger.info("Clicked on RegisterLink");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			logger.info("Providing CustomerData");
			regpage.setFirstName(randomString().toUpperCase());

			regpage.setLastName(randomString().toUpperCase());

			regpage.setEmail(randomString() + "@gmail.com");// randomly generated the email

			// regpage.setTelephone(randomNumber());

			String password = randomAlphaNumeric();
			regpage.setPassword(password);
			// regpage.setConfirmPassword(password);

			//Thread.sleep(5000);

			regpage.setPrivacyPolicy();

			//Thread.sleep(5000);

			regpage.clickContinue();
			logger.info("Clicked on ContinueButton");

			//Thread.sleep(5000);

			String confmsg = regpage.getConfirmationMsg();

			logger.info("Validating the ConfirmationMessage");
			Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Not getting expected message");

		} catch (Exception e) {
			logger.error("TestFailed");
			Assert.fail();

		}
		logger.info("*** Finished TC_001_AccountRegistrationTest ***");
	}
}
