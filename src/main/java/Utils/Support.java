package Utils;

import base.AppiumController;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Support extends AppiumController {
    protected static Logger logger = LogManager.getLogger(Support.class);

    public String RandomString(int length) {

        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        System.out.println(generatedString);
        return generatedString;
    }

    public long RandonInteger() {

        return (long) (Math.random() * 100000 + 3333300000L);
    }


    @Attachment
    public byte[] getScreenshot(AppiumDriver appiumDriver) throws Exception {
        return ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.BYTES);
    }
}



