package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppiumController {

    protected static Logger logger = LogManager.getLogger(AppiumController.class);

    protected AppiumDriver appiumDriver;
    protected WebDriverWait webDriverWait;
    private DesiredCapabilities desiredCapabilities;
    private StringBuilder driverPath = new StringBuilder()
            .append(System.getProperty("user.dir")).append(File.separator)
            .append("target").append(File.separator).append("classes").append(File.separator).append("binaries")
            .append(File.separator).append("chromedriver.exe");

    //device connect information
    public String server;

    //Device List
    public static List<Object[]> deviceList;


    public  enum OperatingSystem{
        ANDROID,
        IOS
    }
    //Per Test Capabilities
    public OperatingSystem oprtinSystem;
    public String dvcName;
    public String atmnName;
    public String ptfmVersion;
    public String brwsrName;
    public String appURL;

    public void startAppium() throws IOException {
        switch (oprtinSystem){
            case ANDROID:
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("platformName", oprtinSystem.toString());
                desiredCapabilities.setCapability("platformVersion", ptfmVersion);
                desiredCapabilities.setCapability("newCommandTimeout", "10000");
                desiredCapabilities.setCapability("browserName", brwsrName);
                desiredCapabilities.setCapability("adbExecTimeout","50000");
                desiredCapabilities.setCapability("chromedriverExecutable",driverPath.toString());
                desiredCapabilities.setCapability("deviceName", dvcName);
                desiredCapabilities.setCapability("automationName", atmnName);

                appiumDriver = new AndroidDriver<MobileElement>(new URL(server), desiredCapabilities);
                break;

            case IOS:
                desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability("platformName", oprtinSystem.toString());
                desiredCapabilities.setCapability("platformVersion", ptfmVersion);
                desiredCapabilities.setCapability("newCommandTimeout", "10000");
                desiredCapabilities.setCapability("browserName", brwsrName);
                desiredCapabilities.setCapability("adbExecTimeout","50000");
                desiredCapabilities.setCapability("chromedriverExecutable",driverPath.toString());
                desiredCapabilities.setCapability("deviceName", dvcName);
                desiredCapabilities.setCapability("automationName", atmnName);

                appiumDriver = new IOSDriver<MobileElement>(new URL(server), desiredCapabilities);
                break;
        }
        webDriverWait = new WebDriverWait(appiumDriver,10);
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        appiumDriver.get(appURL);
    }

    public void stopAppium(){
        if(appiumDriver != null){
            appiumDriver.quit();

        }
    }



}
