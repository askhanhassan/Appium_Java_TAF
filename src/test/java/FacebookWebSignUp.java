import Utils.Support;
import base.AppiumController;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SignUpPage;

import java.io.IOException;


public class FacebookWebSignUp extends AppiumController {

    protected static Logger logger = LogManager.getLogger(FacebookWebSignUp.class);
    protected SignUpPage signUpPage;
    Support support = new Support();


    @BeforeClass
    @Parameters({"deviceName", "platformVersion", "browserName", "platformName", "serverURL", "applicationURL"})
    public void init(String deviceName, String platformVersion, String browserName, String platformName, String serverURL, String applicationURL) throws IOException {

        oprtinSystem = OperatingSystem.valueOf(platformName.toUpperCase());
        logger.info("Operating System Name : ", oprtinSystem);

        server = serverURL;
        logger.info("Appium Server URL :  ", server);
        appURL = applicationURL;
        logger.info("Application URL :  ", appURL);
        brwsrName = browserName;
        logger.info("Browser Name  :  ", appURL);

        if (oprtinSystem.equals(OperatingSystem.ANDROID)) {
            dvcName = deviceName;
            logger.info("Device  Name  :  ", dvcName);

            ptfmVersion = platformVersion;
            logger.info("Platform Version  :  ", ptfmVersion);

            atmnName = "UiAutomator2";
            logger.info("Automation Name  :  ", atmnName);


        } else if (oprtinSystem.equals(OperatingSystem.IOS)) {
            dvcName = deviceName;
            ptfmVersion = platformVersion;
            atmnName = "XCUITest";
        }

        startAppium();

        signUpPage = new SignUpPage(appiumDriver, webDriverWait);


    }


    @Test(priority = 1, description = "Random Details used to Signup Facebook")
    @Severity(SeverityLevel.NORMAL)
    @Description("Random Details used to Sign up Facebook Web")
    @Story("Facebook mobile web signup")
    public void SignUp() throws Exception {

        signUpPage.clickCreateNewAccount();

        signUpPage.setFirstName(support.RandomString(7));

        signUpPage.setLastName(support.RandomString(7));

        signUpPage.clickNext();

        signUpPage.setBirthDate("22");
        signUpPage.setBirthMonth("Jul");
        signUpPage.setBirthYear("1993");

        signUpPage.clickNext();

        signUpPage.setMobileNumber(Long.toString(support.RandonInteger()));

        signUpPage.clickNext();

        appiumDriver.findElement(By.id("Male")).click();
        signUpPage.clickNext();
        signUpPage.setPassword("1qaz2wsx#");
        support.getScreenshot(appiumDriver);
        signUpPage.clickSignUp();


    }


    @AfterClass
    public void shutDown() {
        stopAppium();
    }


}



