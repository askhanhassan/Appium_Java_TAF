
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.SignInPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import pages.SignUpPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class FacebookLiteSignUp {

    AndroidDriver<AndroidElement> androidDriver;
    File appDirct = new File("src\\main\\resources\\");
    File appPath = new File(appDirct,"facebook_Lite.apk");
    InputStream input = new FileInputStream("src\\main\\resources\\user.properties");
    Properties properties =new Properties();

    public FacebookLiteSignUp() throws FileNotFoundException {
    }

    @Parameters({"deviceName" , "platformVersion" })
    @BeforeClass
    public void setCapabilities(String deviceName , String platformVersion) throws MalformedURLException{
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("newCommandTimeout", "10000");
        desiredCapabilities.setCapability("platformVersion", platformVersion);
        desiredCapabilities.setCapability("deviceName",deviceName);
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("autoAcceptAlerts", true);
        desiredCapabilities.setCapability("app", appPath.getAbsolutePath());

        androidDriver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);

        System.out.println("Context Type : "+androidDriver.getContext());
        System.out.println("Session id : " + androidDriver.getSessionId());


    }


    @Test
    public void SignUp() throws Exception {
        SignInPage signInPage = new SignInPage(androidDriver);
        SignUpPage signUpPage = new SignUpPage(androidDriver);

        signInPage.clickOnCreateNewAccontButton();
        properties.load(input);
        signUpPage.signUp(properties.getProperty("firstName"),properties.getProperty("lastName"),properties.getProperty("mobileNumber"),properties.getProperty("email"),properties.getProperty("birthDate"),properties.getProperty("gender"),properties.getProperty("passWord"));

    }

    @AfterClass
    public void shutDown(){
        androidDriver.quit();
    }

}

