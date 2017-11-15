import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;


public class HomePage extends PageObject{

    WebDriverWait wait = new WebDriverWait(driver, 5);

    @FindBy(xpath = "//*[@id=\"mainMenu\"]/li[3]/span/a/span")
    private WebElement menuPayments;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void goPaymentsSection(){
        driver.get("https://www.tinkoff.ru/");
        wait.until(ExpectedConditions.elementToBeClickable(menuPayments)).click();
    }
}
