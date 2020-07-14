package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.How;

import java.util.List;

public class DashboardPage extends BaseClass {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how= How.LINK_TEXT, using="BUY NOW")
    public static WebElement buy_button;

    @FindBy(how= How.CLASS_NAME, using="btn btn-signup")
    public static WebElement signUp_button;

    @FindBy(how=How.LINK_TEXT, using="Sign out")
    public static WebElement sign_out;

    public static class CheckoutModalPage
    {
        @FindBy(how=How.XPATH, using="//*[@id='container']/div/div/div[2]/div[1]/div[1]/span[1]")
        public static WebElement checkout_modal_title;

        @FindBy(how=How.XPATH, using="//*[@id='container']/div/div/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[3]/input")
        public static WebElement price;

        @FindAll({@FindBy(how=How.CLASS_NAME, using="amount")})
        public static List<WebElement> amount_summary;

        @FindAll({@FindBy(how=How.CLASS_NAME, using="cart-head")})
        public static List<WebElement> cart_customer_title;

        @FindBy(how=How.XPATH, using="//*[@id='container']/div/div/div[2]/div[1]/div[4]/table/tbody/tr[1]/td[2]/input")
        public static WebElement customer_name_field;

        @FindBy(how=How.XPATH, using="//*[@id='container']/div/div/div[2]/div[1]/div[4]/table/tbody/tr[2]/td[2]/input")
        public static WebElement customer_email_field;

        @FindBy(how=How.XPATH, using="//*[@id='container']/div/div/div[2]/div[1]/div[4]/table/tbody/tr[3]/td[2]/input")
        public static WebElement customer_phone_number_field;

        @FindBy(how=How.XPATH, using="//*[@id='container']/div/div/div[2]/div[1]/div[4]/table/tbody/tr[4]/td[2]/input")
        public static WebElement customer_city_field;

        @FindBy(how=How.XPATH, using="//*[@id='container']/div/div/div[2]/div[1]/div[4]/table/tbody/tr[5]/td[2]/textarea")
        public static WebElement customer_address_field;

        @FindBy(how=How.XPATH, using="//*[@id='container']/div/div/div[2]/div[1]/div[4]/table/tbody/tr[6]/td[2]/input")
        public static WebElement customer_postal_code_field;

        @FindAll({@FindBy(how=How.CLASS_NAME, using="cart-checkout")})
        public static List<WebElement> cart_button;


    }


}
