package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;



import java.util.concurrent.TimeUnit;


public class SignInPage{

    private AndroidDriver<MobileElement> androidDriver;

    public SignInPage(AndroidDriver<MobileElement> androidDriver){
        this.androidDriver=androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(id = "m_login_email")
    @CacheLookup
    private MobileElement email_TextBox;

    @AndroidFindBy(id = "m_login_password")
    @CacheLookup
    private MobileElement password_TextBox;

    @AndroidFindBy(id = "//android.view.ViewGroup[4]")
    @CacheLookup
    private MobileElement login_button;

    @AndroidFindBy(id = "signup-button")
    @CacheLookup
    private MobileElement createNewAccount_button;

    @AndroidFindBy(id = "")
    @CacheLookup
    private MobileElement email_label;

    @AndroidFindBy(id = "")
    @CacheLookup
    private MobileElement next_Button;


    public void clickOnCreateNewAccontButton() throws Exception {

            androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            createNewAccount_button.click();
            System.out.println("Create New Account button clicked");
            androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            next_Button.click();
            System.out.println("Next button clicked");
    }



}
