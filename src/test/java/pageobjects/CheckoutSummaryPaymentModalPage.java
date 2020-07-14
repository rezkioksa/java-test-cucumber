package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class CheckoutSummaryPaymentModalPage extends BaseClass {
    public CheckoutSummaryPaymentModalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how= How.ID, using="snap-midtrans")
    public static WebElement iframe_body;

    @FindBy(how= How.CLASS_NAME, using="logo-store")
    public static WebElement modal_title;

    @FindBy(how= How.CLASS_NAME, using="text-page-title-content")
    public static WebElement modal_subtitle;

    @FindBy(how= How.CLASS_NAME, using="text-amount-amount")
    public static WebElement amount_summary;

    public static  class OrderSummary{

        @FindBy(how= How.XPATH, using="//*[@id='application']/div[3]/div/div/div/div[1]/div[2]/div")
        public static WebElement order_id;

//        Tab
        @FindAll({@FindBy(how= How.CLASS_NAME, using="text-actionable")})
        public static List<WebElement> order_summary_tab;

//        Order Details Tab
        @FindBy(how= How.CLASS_NAME, using="item-name")
        public static WebElement item_name;

        @FindBy(how=How.XPATH, using="//*[@id='application']/div[3]/div/div/div/div[2]/div/div/div[1]/div/table/tbody/tr[2]/td[2]")
        public static WebElement finish_amount;

//        Shipping Details page
        @FindBy(how= How.XPATH, using="//*[@id='application']/div[3]/div/div/div/div[2]/div/div/div[2]/div/div[1]/div[1]/div[2]")
        public static WebElement shipping_name;

        @FindBy(how= How.XPATH, using="//*[@id='application']/div[3]/div/div/div/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]")
        public static WebElement shipping_phone_number;

        @FindBy(how= How.XPATH, using="//*[@id='application']/div[3]/div/div/div/div[2]/div/div/div[2]/div/div[1]/div[3]/div[2]")
        public static WebElement shipping_email;

        @FindBy(how= How.XPATH, using="//*[@id='application']/div[3]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div[2]")
        public static WebElement shipping_address;


        @FindBy(how= How.CLASS_NAME, using="button-main-content")
        public static WebElement continue_button;
    }

    public static class SelectPayment{
        @FindBy(how= How.XPATH, using="//*[@id='payment-list']/div[1]/a/div[1]/span")
        public static WebElement payment_credit_card_icon;

        @FindAll({@FindBy(how= How.CLASS_NAME, using="list-title text-actionable-bold")})
        public static List<WebElement> payment_list_name;


    }

    public static class CreditCardPayment{
        @FindBy(how= How.XPATH, using="//*[@id='application']/div[3]/div/div/div/form/div[1]/div/div[2]/div")
        public static WebElement order_id;

        @FindBy(how= How.NAME, using="cardnumber")
        public static WebElement card_number_field;

        @FindBy(how= How.XPATH, using="//*[@id='application']/div[3]/div/div/div/form/div[2]/div[2]/input")
        public static WebElement expiry_date_field;

        @FindBy(how= How.XPATH, using="//*[@id='application']/div[3]/div/div/div/form/div[2]/div[3]/input")
        public static WebElement cvv_field;

        @FindBy(how= How.XPATH, using="//*[@id='application']/div[3]/div/div/div/form/div[5]/div[1]/input")
        public static WebElement email_field;

        @FindBy(how= How.XPATH, using="//*[@id='application']/div[3]/div/div/div/form/div[5]/div[2]/input")
        public static WebElement phone_number_field;

        @FindBy(how= How.XPATH, using="//*[@id='application']/div[1]/a/div[1]")
        public static WebElement pay_now_button;

        @FindBy(how= How.CLASS_NAME, using="input-group col-xs-12 error")
        public static WebElement card_number_error;

    }

    public static class SummaryPayment{
        @FindBy(how= How.XPATH, using="//*[@id='acsMain']/div/div/h1")
        public static WebElement modal_title;

        @FindBy(how= How.ID, using="merchant_name")
        public static WebElement merchant_name;

        @FindBy(how= How.ID, using="txn_amount")
        public static WebElement amount;

        @FindBy(how= How.ID, using="txn_time")
        public static WebElement transaction_time;

        @FindBy(how= How.ID, using="card_number")
        public static WebElement card_number;

        @FindBy(how= How.ID, using="PaRes")
        public static WebElement password;

        @FindBy(how= How.NAME, using="ok")
        public static WebElement ok_button;

        @FindBy(how= How.NAME, using="cancel")
        public static WebElement cancel_button;

        @FindBy(how= How.NAME, using="cancel")
        public static WebElement resend_button;
    }
    public static class FinishPaymentStatus{
        @FindBy(how= How.XPATH, using="//*[@id='application']/div[3]/div/div/div/div/div/div[1]/span")
        public static WebElement transaction_status;

    }

}
