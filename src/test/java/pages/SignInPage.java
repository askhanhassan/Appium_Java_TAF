package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;



import java.util.concurrent.TimeUnit;


public class SignInPage{

    private AndroidDriver<AndroidElement> androidDriver;

    public SignInPage(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver=androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.MultiAutoCompleteTextView[1]")
    @CacheLookup
    private AndroidElement email_TextBox;

    @AndroidFindBy(xpath = "//android.widget.MultiAutoCompleteTextView[1]")
    @CacheLookup
    private AndroidElement password_TextBox;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[4]")
    @CacheLookup
    private AndroidElement login_button;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[7]")
    @CacheLookup
    private AndroidElement createNewAccount_button;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]")
    @CacheLookup
    private AndroidElement email_label;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Next']")
    @CacheLookup
    private AndroidElement next_Button;


    public void clickOnCreateNewAccontButton() throws Exception {

            androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            createNewAccount_button.click();
            System.out.println("Create New Account button clicked");
            androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            next_Button.click();
            System.out.println("Next button clicked");
    }



}
