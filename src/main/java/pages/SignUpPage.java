package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {

    public AppiumDriver driver;
    public WebDriverWait wait;
    @FindBy(how = How.ID, using = "signup-button")
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
    private WebElement password_TextBox;

    public SignUpPage(AppiumDriver appiumDriver, WebDriverWait wait) {
        this.driver = appiumDriver;
        this.wait = wait;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(15)), this);
    }

    @Step("Click on create New Account ")
    public void clickCreateNewAccount() {
        createNewAccount_button.click();
    }

    @Step("Enter First Name: {0}")
    public void setFirstName(String firstName) {
        firstName_TextBox.sendKeys(firstName);
    }

    @Step("Enter Second Name: {0}")
    public void setLastName(String secondName) {
        lastName_TextBox.sendKeys(secondName);
    }

    @Step("Click on Next Button")
    public void clickNext() {
        next_Button.click();
    }

    @Step("Click on Sign Up Button")
    public void clickSignUp() {
        sighnUp_Button.click();
    }

    @Step("Enter Mobile Number: {0}")
    public void setMobileNumber(String mobileNumber) {
        mobileNumber_TextBox.sendKeys(mobileNumber);
    }

    @Step("Enter Email Address: {0}")
    public void setEmail(String email) {
        email_TextBox.sendKeys(email);
    }

    @Step("Enter Birth Date: {0}")
    public void setBirthDate(String birthDate) {
        Select birthDateDropdown = new Select(birthDate_Dropdown);
        birthDateDropdown.selectByVisibleText(birthDate);
    }

    @Step("Enter Birth Month: {0}")
    public void setBirthMonth(String birthMonth) {
        Select birthMonthDropdown = new Select(birthMonth_Dropdown);
        birthMonthDropdown.selectByVisibleText(birthMonth);
    }

    @Step("Enter Birth Year: {0}")
    public void setBirthYear(String birthYear) {
        Select birthYearDropdown = new Select(birthYear_Dropdown);
        birthYearDropdown.selectByVisibleText(birthYear);
    }

    @Step("Enter Passowrd: {0}")
    public void setPassword(String password) {
        password_TextBox.sendKeys(password);
    }


}
