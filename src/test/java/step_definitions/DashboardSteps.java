package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.DataHelper;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;


import java.util.HashMap;
import java.util.List;


public class DashboardSteps {
    public WebDriver driver;
    public List<HashMap<String,String>> datamap;
    public String url;
    
    
    public DashboardSteps()
    {
    	driver = Hooks.driver;
     	datamap = DataHelper.data();
    }


    @When("^I open \"([^\"]*)\" page$")
    public void iOpenPage(String key) throws Throwable {
        url = DataHelper.getPropertiesData(key);
        driver.get(url);
    }

//    @When("^I sign in$")
//    public void i_sign_in() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//    	PageFactory.initElements(driver, AutomationHomePage.class);
//		PageFactory.initElements(driver, LoginPage.class);
//
//		SignInAction.Execute(driver,datamap);
//    }
//
//    @Then("^I sign out$")
//    public void i_sign_out() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//    	SignoutAction.Execute(driver,datamap);
//    }
//
//    @Then("^I perform contact us actions$")
//    public void I_perform_contact_us_actions() throws Throwable {
//        PageFactory.initElements(driver, AutomationHomePage.class);
//        PageFactory.initElements(driver, ContactusPage.class);
//        ContactUsAction.Execute(driver,datamap);
//
//    }
}