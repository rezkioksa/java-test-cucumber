package modules;

import helpers.DataHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import pageobjects.DashboardPage;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Delayed;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class VerifyCartCheckoutSummaryAction {
    public static void Execute(WebDriver driver) throws Exception{
        DashboardPage.buy_button.click();

        assertEquals("Shopping Cart  ", DashboardPage.CheckoutModalPage.checkout_modal_title.getText());
        assertEquals(DashboardPage.CheckoutModalPage.amount_summary.get(1).getText(), DataHelper.getPropertiesData("summaryAmount"));
        assertEquals(DashboardPage.CheckoutModalPage.price.getAttribute("value"), DataHelper.getPropertiesData("price"));

        assertEquals(DashboardPage.CheckoutModalPage.cart_customer_title.get(1).getText(),DataHelper.getPropertiesData("customerModalTitle"));
        assertTrue(DashboardPage.CheckoutModalPage.customer_name_field.getAttribute("value") != null);
        assertTrue(DashboardPage.CheckoutModalPage.customer_email_field.getAttribute("value") != null);
        assertTrue(DashboardPage.CheckoutModalPage.customer_phone_number_field.getAttribute("value") != null);
        assertTrue(DashboardPage.CheckoutModalPage.customer_city_field.getAttribute("value") != null);
        assertTrue(DashboardPage.CheckoutModalPage.customer_address_field.getAttribute("value") != null);
        assertTrue(DashboardPage.CheckoutModalPage.customer_postal_code_field.getAttribute("value") != null);
        DashboardPage.CheckoutModalPage.cart_button.get(0).click();
        Reporter.log("Shopping Cart Summary action verify and proceed successful");
    }
}
