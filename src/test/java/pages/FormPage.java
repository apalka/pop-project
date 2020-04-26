package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage extends BasePage {

    protected final String FORM_URL = BASE_URL + "input-form-demo.html";

    @FindBy(name = "first_name")
    public WebElement firstNameInput;

    @FindBy(name = "last_name")
    public WebElement lastNameInput;

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(name = "phone")
    public WebElement phoneInput;

    @FindBy(name = "address")
    public WebElement addressInput;

    @FindBy(name = "city")
    public WebElement cityInput;

    @FindBy(name = "state")
    public WebElement stateDropdown;

    @FindBy(name = "zip")
    public WebElement zipInput;

    @FindBy(name = "website")
    public WebElement websiteInput;

    @FindBy(xpath = "//input[@name='hosting'][@value='yes']")
    public WebElement yesHostingButton;

    @FindBy(xpath = "//input[@name='hosting'][@value='no']")
    public WebElement noHostingButton;

    @FindBy(name = "comment")
    public WebElement commentInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(FORM_URL);
    }
}
