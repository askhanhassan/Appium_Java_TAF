
import io.appium.java_client.MobileElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
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
import java.util.Random;

public class FacebookWebSignUp {

    AndroidDriver<WebElement> androidDriver;
    File appDirct = new File("src\\main\\resources\\");
    InputStream input = new FileInputStream(appDirct+"\\user.properties");
    Properties properties =new Properties();

    public FacebookWebSignUp() throws FileNotFoundException {
    }

    @Parameters({"deviceName" , "platformVersion","browserName" })
    @BeforeClass
    public void setCapabilities(String deviceName,String platformVersion,String browserName ) throws MalformedURLException{
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("newCommandTimeout", "10000");
        desiredCapabilities.setCapability("platformVersion", platformVersion);
        desiredCapabilities.setCapability("browserName",browserName);
        desiredCapabilities.setCapability("chromedriverExecutable","D:\\Appium_Java_TAF\\Appium_Java_TAF\\src\\main\\resources\\chromedriver.exe");
        desiredCapabilities.setCapability("adbExecTimeout","50000");
        desiredCapabilities.setCapability("deviceName",deviceName);

        androidDriver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);

        System.out.println("Context Type : "+androidDriver.getContext());
        System.out.println("Session id : " + androidDriver.getSessionId());
        androidDriver.get("https://m.facebook.com/");


    }


    @Test
    public void SignUp() throws Exception {

        SignUpPage signUpPage = new SignUpPage(androidDriver);

        properties.load(input);
        String firstName = RandonString();
        String lastName = RandonString();
        long mobileNumber = RandonInteger() ;
        signUpPage.signUp(firstName,lastName,Long.toString(mobileNumber),properties.getProperty("birthDate"),properties.getProperty("birthMonth"),properties.getProperty("birthYear"),properties.getProperty("gender"),properties.getProperty("passWord"));

    }

    @AfterClass
    public void shutDown(){
       androidDriver.quit();
    }


    public String RandonString() {

        int length = 7;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        System.out.println(generatedString);
        return  generatedString;
    }

    public long RandonInteger() {

        return (long)(Math.random()*100000 + 3333300000L);
    }
}



