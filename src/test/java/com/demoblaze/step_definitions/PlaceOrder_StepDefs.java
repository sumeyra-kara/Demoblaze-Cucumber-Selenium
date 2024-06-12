package com.demoblaze.step_definitions;

import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.HomePage;
import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PlaceOrder_StepDefs {
    HomePage homePage=new HomePage();
    CartPage cartPage = new CartPage();
    int expectedAmount=0;
    int actualAmount=0;
    @When("user adds {string} product from {string} category")
    public void user_adds_product_from_category(String product, String category) {
        expectedAmount += homePage.addProductFromCategory(product,category);
    }
    @When("user removes {string} product from cart page")
    public void user_removes_product_from_cart_page(String product) {
        expectedAmount-=cartPage.removeProductFromCart(product);
    }
    @When("user places order and capture and log amount")
    public void user_places_order_and_capture_and_log_amount() {
        actualAmount = cartPage.placeOrderAndLogAmount();
    }
    @Then("verify the purchase order")
    public void verify_the_purchase_order() {
        Assert.assertEquals(expectedAmount,actualAmount);
    }



}
