import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ServicePayments extends PageObject {

    WebDriverWait wait = new WebDriverWait(driver, 5);

    @FindBy(css = "span[class=\"ui-link payment-page__title_inner\"]")
    private WebElement region;

    @FindBy(css = "input[class=\"ui-input__field\"][value=\"\"]")
    private WebElement searchInput;

    @FindBy(css = "div.ui-regions__layout div span")
    private WebElement city;

    @FindBy(css = "a[href=\"/zhku-moskva/\"]")
    private WebElement provider;

    @FindBy(css = "a[href=\"/payments/provider-gorvodokanalnovosi-9/\"]")
    public WebElement checkRegion;

    @FindBy(css = "span a span div span")
    public WebElement checkServiceCategory;

    public void selectRegion(String regionCity){
        this.region.click();
        this.searchInput.click();
        this.searchInput.clear();
        this.searchInput.sendKeys(regionCity);
        this.city.click();
    }

    public void selectProvider(){
        this.provider.click();
    }

    public ServicePayments(WebDriver driver) {
        super(driver);
    }
}
