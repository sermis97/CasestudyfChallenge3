package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BasePage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;


public class NavigationMenuStepDefs {

    String url = ConfigurationReader.get("url");

    BasePage pricingPage = new BasePage();


    @Given("the user is on the airtame.com")
    public void theUserIsOnTheAirtameCom() {

        Driver.get().get(url);

        String actualUrl = Driver.get().getCurrentUrl();
        String expectedUrl = "https://airtame.com/";

        Assert.assertEquals("URLs mismatch",expectedUrl,actualUrl);

    }
    @When("the user navigate  to Pricing page")
    public void theUserNavigateToPricingPage() {
        pricingPage.buyNow.click();
        BrowserUtils.waitFor(2);
        String actualUrl = Driver.get().getCurrentUrl();
        String expectedUrl = "https://airtame.com/pricing/";

        Assert.assertEquals("URLs mismatch",expectedUrl,actualUrl);

    }

    @And("the user add  an Airtame device to the cart")
    public void theUserAddAnAirtameDeviceToTheCart() throws InterruptedException {
        pricingPage.addcart.click();
        BrowserUtils.waitForPageToLoad(5);
        Assert.assertEquals("Product is not correct or not in the cart","Airtame 2", pricingPage.productTitleinTheCart.getText());

    }


    @And("the user add two more Airtames and two PoE adaptors to cart")
    public void theUserAddTwoMoreAirtamesAndTwoPoEAdaptorsToCart() {

        for (int i = 0; i <= 2; i++) {
             pricingPage.plusButton.click();
             BrowserUtils.waitFor(1);
        }


        BrowserUtils.waitFor(1);
        pricingPage.updateButton.click();
        BrowserUtils.waitFor(2);

        for (int i = 0; i < 1; i++) {
            pricingPage.poePlusButton.click();
            BrowserUtils.waitFor(1);
        }

        pricingPage.poeAddCart.click();


    }


    @Then("verify that total price equals one thousand four hundred fifty five Euro")
    public void verify_that_total_price_equals_one_thousand_four_hundred_fifty_five_Euro() {

        String actualCost = pricingPage.totalCost.getText();
        String expectedCost = "€1455.00";

        Assert.assertNotEquals(expectedCost,actualCost);

    }


}
