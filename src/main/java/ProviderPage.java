import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProviderPage extends PageObject {

    @FindBy(xpath = "//div//span/section/ul/li[1]/span[2]/a/span")
    public WebElement service;

    @FindBy(css = "a[href=\"/zhku-moskva/oplata/\"] span")
    private WebElement providerOplata;

    @FindBy(css = "label div.ui-input__column input[id=\"payerCode\"]")
    private WebElement payerCode;

    @FindBy(css = "label div.ui-input__column input[id=\"period\"]")
    private WebElement period;

    @FindBy(css = "label div.ui-input__column input[id=\"insurance\"]")
    private WebElement sum;

    @FindBy(css = "label  div.ui-input__column b.ui-input__label")
    private WebElement amount;

    @FindBy(css = "h2[class=\"ui-button__text\"]")
    private WebElement btmsubmit;

    @FindBy(css = "div[class=\"ui-form-field-error-message ui-form-field-error-message_ui-form\"]")
    public WebElement error;

    @FindBy(xpath = "//div[text()=\"Поле неправильно заполнено\"]")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[text()=\"Поле заполнено некорректно\"]")
    private WebElement erorrMessage1;

    @FindBy(xpath = "//div[text()=\"Минимальная сумма перевода - 10 \u20BD\"]")
    private WebElement errorMessage3;

    @FindBy(css = "div.ui-page-frame__content a:nth-of-type(1)[href=\"/zhku-moskva/\"]")
    public WebElement checkPage;

    public void errorMessage(){
        if (errorMessage.isDisplayed()){
            System.out.print(errorMessage);
        }else{
            if (erorrMessage1.isDisplayed()){
                System.out.print(erorrMessage1);
            }else{
                if (errorMessage3.isDisplayed()){
                    System.out.print(errorMessage3);
                }
            }
        }
    }

    public void clickProviderOplata(){
        providerOplata.click();
    }

    public void inputFields(String code, String period, String sum, String amount){
        this.payerCode.clear();
        this.payerCode.sendKeys(code);

        this.period.clear();
        this.period.sendKeys(period);

        this.sum.clear();
        this.sum.sendKeys(sum);

        this.amount.clear();
        this.amount.sendKeys(amount);
    }

    public void submit(){
        btmsubmit.click();
    }

    public ProviderPage(WebDriver driver) {
        super(driver);
    }
}
