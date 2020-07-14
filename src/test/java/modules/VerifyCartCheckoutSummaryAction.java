package modules;

import helpers.DataHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import pageobjects.DashboardPage;
import pageobjects.CheckoutSummaryPaymentModalPage;

import javax.xml.crypto.Data;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class VerifyCartCheckoutSummaryAction {
    public static void BuyAndCheckout(WebDriver driver) throws Exception {
        DashboardPage.buy_button.click();

        assertEquals(DataHelper.getPropertiesData("shoppingCartModalTitle"), DashboardPage.CheckoutModalPage.checkout_modal_title.getText());
        assertEquals(DataHelper.getPropertiesData("summaryAmount"), DashboardPage.CheckoutModalPage.amount_summary.get(1).getText());
        assertEquals(DataHelper.getPropertiesData("price"), DashboardPage.CheckoutModalPage.price.getAttribute("value"));
        assertEquals(DataHelper.getPropertiesData("customerModalTitle"), DashboardPage.CheckoutModalPage.cart_customer_title.get(1).getText());
        assertTrue(DashboardPage.CheckoutModalPage.customer_name_field.getAttribute("value") != null);
        assertTrue(DashboardPage.CheckoutModalPage.customer_email_field.getAttribute("value") != null);
        assertTrue(DashboardPage.CheckoutModalPage.customer_phone_number_field.getAttribute("value") != null);
        assertTrue(DashboardPage.CheckoutModalPage.customer_city_field.getAttribute("value") != null);
        assertTrue(DashboardPage.CheckoutModalPage.customer_address_field.getAttribute("value") != null);
        assertTrue(DashboardPage.CheckoutModalPage.customer_postal_code_field.getAttribute("value") != null);
        DashboardPage.CheckoutModalPage.cart_button.get(0).click();
        Reporter.log("Successfully click buy and checkout button");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void VerifyOrderSummary(WebDriver driver) {
        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        assertEquals(DataHelper.getPropertiesData("merchantName"), CheckoutSummaryPaymentModalPage.modal_title.getText());
        assertEquals(DataHelper.getPropertiesData("orderSummarytext"), CheckoutSummaryPaymentModalPage.modal_subtitle.getText());
        assertEquals(DataHelper.getPropertiesData("summaryAmount"), CheckoutSummaryPaymentModalPage.amount_summary.getText());
        assertTrue(CheckoutSummaryPaymentModalPage.OrderSummary.order_id.getText() != null);

//        Order Details tab
        assertEquals(DataHelper.getPropertiesData("itemName"), CheckoutSummaryPaymentModalPage.OrderSummary.item_name.getText());
        assertEquals(DataHelper.getPropertiesData("summaryAmount"), CheckoutSummaryPaymentModalPage.OrderSummary.finish_amount.getText());

//        Shipping Details Tab
        CheckoutSummaryPaymentModalPage.OrderSummary.order_summary_tab.get(1).click();
        assertTrue(CheckoutSummaryPaymentModalPage.OrderSummary.shipping_name.getText() != null);
        assertTrue(CheckoutSummaryPaymentModalPage.OrderSummary.shipping_phone_number.getText() != null);
        assertTrue(CheckoutSummaryPaymentModalPage.OrderSummary.shipping_email.getText() != null);
        assertTrue(CheckoutSummaryPaymentModalPage.OrderSummary.shipping_address.getText() != null);

        CheckoutSummaryPaymentModalPage.OrderSummary.continue_button.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void SelectPaymentMethod(WebDriver driver, String paymentMethod) {
//        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        assertEquals(DataHelper.getPropertiesData("merchantName"), CheckoutSummaryPaymentModalPage.modal_title.getText());
        assertEquals(DataHelper.getPropertiesData("selectPaymentText"), CheckoutSummaryPaymentModalPage.modal_subtitle.getText());
        assertTrue(CheckoutSummaryPaymentModalPage.SelectPayment.payment_credit_card_icon.isDisplayed());
        String payment = DataHelper.getPropertiesData(paymentMethod);
        WebElement selectedPayment = driver.findElement(By.xpath("//*[text()='" + payment + "']"));
        selectedPayment.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void VerifyPaymentCheckoutData(WebDriver driver,String creditCardNumber) {
//        driver.switchTo().frame(driver.findElement(By.id("snap-midtrans")));
        assertEquals(DataHelper.getPropertiesData("merchantName"), CheckoutSummaryPaymentModalPage.modal_title.getText());
        assertEquals(DataHelper.getPropertiesData("creditCard"), CheckoutSummaryPaymentModalPage.modal_subtitle.getText());
        assertEquals(DataHelper.getPropertiesData("amountAfterPromo"), CheckoutSummaryPaymentModalPage.amount_summary.getText());
        assertTrue(CheckoutSummaryPaymentModalPage.CreditCardPayment.order_id.getText() != null);

        CheckoutSummaryPaymentModalPage.CreditCardPayment.card_number_field.sendKeys(DataHelper.getPropertiesData(creditCardNumber));
        CheckoutSummaryPaymentModalPage.CreditCardPayment.expiry_date_field.sendKeys(DataHelper.getPropertiesData("ExpiryDate"));
        CheckoutSummaryPaymentModalPage.CreditCardPayment.cvv_field.sendKeys(DataHelper.getPropertiesData("cvvNumber"));

        Actions actions = new Actions(driver);
        actions.moveToElement(CheckoutSummaryPaymentModalPage.CreditCardPayment.phone_number_field);
        actions.perform();
        assertTrue(CheckoutSummaryPaymentModalPage.CreditCardPayment.email_field.getAttribute("placeholder") != null);
        assertTrue(CheckoutSummaryPaymentModalPage.CreditCardPayment.phone_number_field.getAttribute("placeholder") != null);

        actions.moveToElement(CheckoutSummaryPaymentModalPage.CreditCardPayment.pay_now_button).click().build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void VerifySummaryPayment(WebDriver driver) {
        assertEquals(DataHelper.getPropertiesData("merchantName"), CheckoutSummaryPaymentModalPage.modal_title.getText());
        assertEquals(DataHelper.getPropertiesData("creditCard"), CheckoutSummaryPaymentModalPage.modal_subtitle.getText());

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='application']/div[3]/div/div/div/iframe")));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(DataHelper.getPropertiesData("summaryPaymentText"), CheckoutSummaryPaymentModalPage.SummaryPayment.modal_title.getText());
        assertTrue(CheckoutSummaryPaymentModalPage.SummaryPayment.merchant_name.getText() != null);
        assertTrue(CheckoutSummaryPaymentModalPage.SummaryPayment.amount.getText().equals(DataHelper.getPropertiesData("amountSummaryAfterPromo")));
        assertTrue(CheckoutSummaryPaymentModalPage.SummaryPayment.transaction_time.getText() != null);
        assertTrue(CheckoutSummaryPaymentModalPage.SummaryPayment.card_number.getText().replace(" ", "").replace("-","") != DataHelper.getPropertiesData("creditCardNumberTrue"));
        assertTrue(CheckoutSummaryPaymentModalPage.SummaryPayment.password.getText() != null);

        assertTrue(CheckoutSummaryPaymentModalPage.SummaryPayment.ok_button.isDisplayed());
        assertTrue(CheckoutSummaryPaymentModalPage.SummaryPayment.cancel_button.isDisplayed());
        assertTrue(CheckoutSummaryPaymentModalPage.SummaryPayment.resend_button.isDisplayed());
        CheckoutSummaryPaymentModalPage.SummaryPayment.ok_button.click();

    }

    public static void VerifyTransactionStatus(WebDriver driver, String status){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(CheckoutSummaryPaymentModalPage.FinishPaymentStatus.transaction_status.equals(DataHelper.getPropertiesData(status)));
    }


}
