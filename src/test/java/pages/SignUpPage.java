package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SignUpPage {

    private AndroidDriver<WebElement> androidDriver;

    public SignUpPage(AndroidDriver<WebElement> androidDriver){
        this.androidDriver=androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @FindBy(how = How.ID, using= "signup-button")
    @CacheLookup
    private WebElement createNewAccount_button;

    @FindBy(how = How.ID, using = "firstname_input")
    @CacheLookup
    private WebElement firstName_TextBox;

    @FindBy(how = How.ID, using = "lastname_input")
    @CacheLookup
    private WebElement lastName_TextBox;

    @FindBy(how = How.XPATH, using = "//button[@data-sigil='touchable multi_step_next']")
    @CacheLookup
    private WebElement next_Button;

    @FindBy(how = How.XPATH, using = "//button[@data-sigil='touchable multi_step_submit']")
    @CacheLookup
    private WebElement sighnUp_Button;

    @FindBy(how = How.ID, using = "contactpoint_step_input")
    @CacheLookup
    private WebElement mobileNumber_TextBox;

    @FindBy(how = How.ID, using = "//android.widget.MultiAutoCompleteTextView[1]")
    @CacheLookup
    private WebElement email_TextBox;

    @FindBy(how = How.ID, using = "day")
    @CacheLookup
    private WebElement birthDate_Dropdown;

    @FindBy(how = How.ID, using = "month")
    @CacheLookup
    private WebElement birthMonth_Dropdown;

    @FindBy(how = How.ID, using = "year")
    @CacheLookup
    private WebElement birthYear_Dropdown;

    @FindBy(how = How.ID, using = "password_step_input")
    @CacheLookup
    private WebElement passWord_TextBox;



    public void signUp(String firstName, String lastName, String mobileNumber, String birthDate,String birthMonth,String birthYear, String gender, String passWord ) throws Exception {

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        createNewAccount_button.click();

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        firstName_TextBox.sendKeys(firstName);
        System.out.println("First Name Set as : "+firstName );
        lastName_TextBox.sendKeys(lastName);
        System.out.println("Last Name Set as : "+lastName );
        next_Button.click();

        Select birthDateDropdown = new Select(birthDate_Dropdown);
        birthDateDropdown.selectByVisibleText(birthDate);
        System.out.println("Birth Date Set as : "+birthDate );

        Select birthMonthDropdown = new Select(birthMonth_Dropdown);
        birthMonthDropdown.selectByVisibleText(birthMonth);
        System.out.println("Birth Month Set as : "+birthMonth );

        Select birthYearDropdown = new Select(birthYear_Dropdown);
        birthYearDropdown.selectByVisibleText(birthYear);
        System.out.println("Birth Year Set as : "+birthYear );
        next_Button.click();

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mobileNumber_TextBox.sendKeys(mobileNumber);
        System.out.println("Mobile Number Set as : "+mobileNumber );
        next_Button.click();

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        androidDriver.findElement(By.id(gender)).click();
        System.out.println("Gender Set as : "+gender );
        next_Button.click();

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        passWord_TextBox.sendKeys(passWord);
        System.out.println("Password Set as : "+passWord );

       androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       sighnUp_Button.click();


    }
}
