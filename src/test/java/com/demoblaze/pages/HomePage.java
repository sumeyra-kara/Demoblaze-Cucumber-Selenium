package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public WebElement category(String categoryName){
        String categoryPath= "//a[text()='"+categoryName+"']";
        return Driver.getDriver().findElement(By.xpath(categoryPath));
    }


    public WebElement product (String productName){
        String productPath= "//a[text()='"+productName+"']";
        return Driver.getDriver().findElement(By.xpath(productPath));
    }
    @FindBy(tagName= "h3")
    public WebElement productPrice;

    @FindBy(xpath = "//a[.='Add to cart']")
    public WebElement addToCartButton;


    public int addProductFromCategory(String productName,String categoryName){
        try {
            category(categoryName).click();
            product(productName).click();
        } catch (Exception e) {
            category(categoryName).click();
            product(productName).click();
        }
        String fullPrice = productPrice.getText().split(" ")[0];
        int price = Integer.parseInt(fullPrice.substring(1));
        addToCartButton.click();
        BrowserUtils.waitFor(2);
        BrowserUtils.waitForAlertPresent(5);
        Driver.getDriver().switchTo().alert().accept();
        menu("Home").click();

        return price;

    }




}
