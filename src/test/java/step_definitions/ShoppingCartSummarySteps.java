package step_definitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import helpers.DataHelper;
import modules.VerifyShoppingCartSummaryAction;
import modules.VerifyCartCheckoutSummaryAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.DashboardPage;
import pageobjects.ShoppingCartSummaryPage;

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
//
//    @Then("^I verify details on shoppingCart summary page$")
//    public void i_verify_details_on_shoppingCart_summary_page() throws Throwable {
//
//        PageFactory.initElements(driver, ShoppingCartSummaryPage.class);
//        VerifyShoppingCartSummaryAction.Execute(driver,datamap);
//
//    }

    @And("^I buy and checkout the pillow$")
    public void iBuyAndCheckoutThePillow() throws Exception {
        PageFactory.initElements(driver, DashboardPage.class);
        PageFactory.initElements(driver, DashboardPage.CheckoutModalPage.class);
        VerifyCartCheckoutSummaryAction.Execute(driver);
    }
}
