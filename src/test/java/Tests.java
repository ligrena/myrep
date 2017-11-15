import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class Tests extends FunctionalTest {

    HomePage homePage = new HomePage(driver);
    PaymentsPage paymentsPage = new PaymentsPage(driver);
    ServicePayments servicePayments = new ServicePayments(driver);
    ProviderPage providerPage = new ProviderPage(driver);

    @Test
    public void checkFieldstest(){
        homePage.goPaymentsSection();
        paymentsPage.selectService();

        if (servicePayments.checkRegion.isDisplayed()){
            servicePayments.selectRegion("Москва");
        }
        servicePayments.selectProvider();
        providerPage.clickProviderOplata();

        /* check the error message when click the button on an empty form */
        providerPage.submit();
        assertTrue(providerPage.error.isDisplayed());

        /* check fields on null*/
        providerPage.inputFields(null, null, null, null);
        providerPage.submit();
        assertTrue(providerPage.error.isDisplayed());

        /* check fields on value = 0*/
        providerPage.inputFields("0","0","0","0");
        providerPage.submit();
        if (providerPage.error.isDisplayed()) providerPage.errorMessage();

        /* check fields on value = 100 */
        providerPage.inputFields("100","100","100","100");
        providerPage.submit();
        if (providerPage.error.isDisplayed()) providerPage.errorMessage();

        /* check fields on value = 100000000 */
        providerPage.inputFields("100","100","100","100");
        providerPage.submit();
        if (providerPage.error.isDisplayed()) providerPage.errorMessage();
    }

    @Test
    public void checkServiceOne(){
        homePage.goPaymentsSection();
        paymentsPage.selectService();
        paymentsPage.searchService("ЖКУ-Москва");
        assertTrue(paymentsPage.resSearch.isDisplayed());
    }

    @Test
    public void checkPageEquals(){
        homePage.goPaymentsSection();
        paymentsPage.selectService();
        paymentsPage.searchService("ЖКУ-Москва");
        paymentsPage.inputSubmit();
        providerPage.clickProviderOplata();
        assertTrue(providerPage.checkPage.isDisplayed());
    }

    @Test
    public void checkAnotherCity(){
        homePage.goPaymentsSection();
        paymentsPage.selectService();
        assertTrue(servicePayments.checkServiceCategory.isDisplayed());
        servicePayments.selectRegion("Санкт-Петербург");
        assertFalse(providerPage.service.isDisplayed());
    }

}
