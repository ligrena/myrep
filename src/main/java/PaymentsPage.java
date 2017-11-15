import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class PaymentsPage extends PageObject {

    WebDriverWait wait = new WebDriverWait(driver, 10);

    @FindBy(xpath = "//*[@id=\"search-and-pay-container\"]//label")
    private WebElement searchInput;

    @FindBy(xpath = "//div/ul/li[2]/span[2]/a/span")
    private WebElement homePayments;

    @FindBy(css = "div._2y2k5 div:nth-of-type(1) div:nth-of-type(1)")
    public WebElement resSearch;

    public PaymentsPage(WebDriver driver){
        super(driver);
    }

    public void searchService(String service){
        this.searchInput.clear();
        this.searchInput.sendKeys(service);
    }

    public void inputSubmit(){
        this.searchInput.sendKeys(Keys.ENTER);
    }

    public void selectService(){
        wait.until(ExpectedConditions.elementToBeClickable(homePayments)).click();
    }
}