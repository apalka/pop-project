package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;
import pages.FormPage;
import pages.TablePage;
import utils.TestHelpers;

import java.util.List;

public class FormTest extends BaseTest {

    private FormPage formPage;
    private TablePage tablePage;

    private String fakeFirstName;
    private String fakeLastName;
    private String fakeEmail;
    private String fakePhone;
    private String fakeAddress;
    private String fakeCity;
    private String fakeZipCode;
    private String fakeWebsite;

    @BeforeEach
    public void beforeEach() {
        formPage = new FormPage(driver);
        tablePage = new TablePage(driver);

        Faker faker = new Faker();
        fakeFirstName = faker.name().firstName();
        fakeLastName = faker.name().lastName();
        fakeEmail = faker.internet().emailAddress();
        fakePhone = faker.phoneNumber().phoneNumber();
        fakeAddress = faker.address().fullAddress();
        fakeCity = faker.address().city();
        fakeZipCode = faker.address().zipCode();
        fakeWebsite = faker.internet().url();
    }

    @Test
    public void fillContactForm() {
        formPage.open();

        TestHelpers.waitForElement(driver, formPage.firstNameInput);
        formPage.firstNameInput.sendKeys(fakeFirstName);
        formPage.lastNameInput.sendKeys(fakeLastName);
        formPage.emailInput.sendKeys(fakeEmail);
        formPage.phoneInput.sendKeys(fakePhone);
        formPage.addressInput.sendKeys(fakeAddress);
        formPage.cityInput.sendKeys(fakeCity);

        Select dropdown = new Select(formPage.stateDropdown);
        dropdown.getOptions().get(10).click();

        formPage.zipInput.sendKeys(fakeZipCode);
        formPage.websiteInput.sendKeys(fakeWebsite);
        formPage.noHostingButton.click();

        TestHelpers.openNewTab(driver);
        TestHelpers.switchToTab(driver, 1);
        tablePage.open();
        TestHelpers.waitForElements(driver, tablePage.paragraphs);
        String paragraph_text = tablePage.paragraphs.get(0).getText();
        List<String> allMatches = TestHelpers.findAllMatches("\\d+", paragraph_text);
        String extracted_code = allMatches.get(0);
        TestHelpers.switchToTab(driver, 0);

        formPage.commentInput.sendKeys("Extracted code from a paragraph: " + extracted_code);
        formPage.submitButton.click();
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }
}
