package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SignUpPage {

    private AndroidDriver<AndroidElement> androidDriver;

    public SignUpPage(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver=androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }


    @AndroidFindBy(xpath = "//android.widget.MultiAutoCompleteTextView[1]")
    @CacheLookup
    private AndroidElement firstName_TextBox;

    @AndroidFindBy(xpath = "//android.widget.MultiAutoCompleteTextView[2]")
    @CacheLookup
    private AndroidElement lastName_TextBox;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Next']")
    @CacheLookup
    private AndroidElement next_Button;

    @AndroidFindBy(xpath = "//android.widget.MultiAutoCompleteTextView[1]")
    @CacheLookup
    private AndroidElement mobileNumber_TextBox;

    @AndroidFindBy(xpath = "//android.widget.MultiAutoCompleteTextView[1]")
    @CacheLookup
    private AndroidElement email_TextBox;

    @AndroidFindBy(xpath = "//android.widget.MultiAutoCompleteTextView[1]")
    @CacheLookup
    private AndroidElement birthDate_TextBox;

    @AndroidFindBy(xpath = "//android.widget.MultiAutoCompleteTextView[1]")
    @CacheLookup
    private AndroidElement passWord_TextBox;



    public void signUp(String firstName, String lastName, String mobileNumber, String email, String birthDate, String gender, String passWord ) throws Exception {

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        firstName_TextBox.sendKeys(firstName);
        System.out.println("First Name Set as : "+firstName );

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        lastName_TextBox.sendKeys(lastName);
        System.out.println("Last Name Set as : "+lastName );

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        next_Button.click();

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mobileNumber_TextBox.clear();
        mobileNumber_TextBox.sendKeys(mobileNumber);
        System.out.println("Mobile Number Set as : "+mobileNumber );

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        next_Button.click();

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        email_TextBox.clear();
        androidDriver.hideKeyboard();
        email_TextBox.sendKeys(email);
        System.out.println("Email Set as : "+email );

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        next_Button.click();

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        androidDriver.hideKeyboard();
        email_TextBox.clear();
        birthDate_TextBox.sendKeys(birthDate);
        System.out.println("Birth Date Set as : "+birthDate );

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        next_Button.click();

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        androidDriver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc='"+gender+"'])[1]")).click();
        System.out.println("Gender Set as : "+gender );

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        next_Button.click();

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        passWord_TextBox.sendKeys(passWord);
        System.out.println("Password Set as : "+passWord );

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        next_Button.click();


    }
}
