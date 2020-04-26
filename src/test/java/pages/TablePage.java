package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TablePage extends BasePage {

    protected final String TABLE_URL = BASE_URL + "table-pagination-demo.html";

    @FindBy(xpath = "//div[@class='col-md-6 text-left']//p")
    public List<WebElement> paragraphs;

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(TABLE_URL);
    }
}
