package step_definitions;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helpers.DataHelper;
import modules.VerifyCartCheckoutSummaryAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageobjects.CheckoutSummaryPaymentModalPage;
import pageobjects.DashboardPage;

import java.util.HashMap;
import java.util.List;

public class ShoppingCartSummarySteps {

    public WebDriver driver;
    public List<HashMap<String,String>> datamap;


    public ShoppingCartSummarySteps()
    {
        driver = Hooks.driver;
        datamap = DataHelper.data();
    }

    @And("^I buy and checkout the pillow$")
    public void iBuyAndCheckoutThePillow() throws Exception {
        PageFactory.initElements(driver, DashboardPage.class);
        PageFactory.initElements(driver, DashboardPage.CheckoutModalPage.class);
        VerifyCartCheckoutSummaryAction.BuyAndCheckout(driver);
    }

    @And("^I check Order Summary$")
    public void iCheckOrderSummary() {
        PageFactory.initElements(driver, CheckoutSummaryPaymentModalPage.class);
        PageFactory.initElements(driver, CheckoutSummaryPaymentModalPage.OrderSummary.class);
        VerifyCartCheckoutSummaryAction.VerifyOrderSummary(driver);

    }

    @And("^I select \"([^\"]*)\" payment method$")
    public void iSelectPaymentMethod(String paymentMethod) throws Throwable {
        PageFactory.initElements(driver, CheckoutSummaryPaymentModalPage.class);
        PageFactory.initElements(driver, CheckoutSummaryPaymentModalPage.SelectPayment.class);
        VerifyCartCheckoutSummaryAction.SelectPaymentMethod(driver, paymentMethod);
    }


//    @And("^I verify payment checkout with correct credit card number$")
//    public void iVerifyPaymentCheckoutWithCorrectCreditCardNumber() {
//        PageFactory.initElements(driver, CheckoutSummaryPaymentModalPage.class);
//        PageFactory.initElements(driver, CheckoutSummaryPaymentModalPage.CreditCardPayment.class);
//        VerifyCartCheckoutSummaryAction.VerifyPaymentCheckoutData(driver, "creditCardNumberTrue");
//    }

    @And("^I verify the summary payment$")
    public void iVerifyTheSummaryPayment() {
        PageFactory.initElements(driver, CheckoutSummaryPaymentModalPage.class);
        PageFactory.initElements(driver, CheckoutSummaryPaymentModalPage.SummaryPayment.class);
        VerifyCartCheckoutSummaryAction.VerifySummaryPayment(driver);
    }

//    @And("^I verify payment checkout with Wrong credit card number$")
//    public void iVerifyPaymentCheckoutWithWrongCreditCardNumber() {
//        PageFactory.initElements(driver, CheckoutSummaryPaymentModalPage.class);
//        PageFactory.initElements(driver, CheckoutSummaryPaymentModalPage.CreditCardPayment.class);
//        VerifyCartCheckoutSummaryAction.VerifyPaymentCheckoutData(driver, "creditcardNumberFalse");
//    }

    @And("^I verify the summary payment is not exist$")
    public void iVerifyTheSummaryPaymentIsNotExist() {
        PageFactory.initElements(driver, CheckoutSummaryPaymentModalPage.class);
        PageFactory.initElements(driver, CheckoutSummaryPaymentModalPage.SummaryPayment.class);
        PageFactory.initElements(driver, CheckoutSummaryPaymentModalPage.CreditCardPayment.class);
//        VerifyCartCheckoutSummaryAction.VerifySummaryPaymentIsNotExist(driver);
    }

    @Then("^the transaction should be \"([^\"]*)\"$")
    public void theTransactionShouldBe(String status) throws Throwable {
        PageFactory.initElements(driver, CheckoutSummaryPaymentModalPage.class);
        PageFactory.initElements(driver, CheckoutSummaryPaymentModalPage.FinishPaymentStatus.class);
    }

    @And("^I verify payment checkout with \"([^\"]*)\" credit card number$")
    public void iVerifyPaymentCheckoutWithCreditCardNumber(String data) throws Throwable {
        PageFactory.initElements(driver, CheckoutSummaryPaymentModalPage.class);
        PageFactory.initElements(driver, CheckoutSummaryPaymentModalPage.CreditCardPayment.class);
        VerifyCartCheckoutSummaryAction.VerifyPaymentCheckoutData(driver, data);
    }
}
