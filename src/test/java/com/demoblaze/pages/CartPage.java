package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{

    public WebElement deleteButton(String productName){
        String productDeletePath ="//tbody//tr/td[2][text()='"+productName+"']/following-sibling::td[2]/a";
        return Driver.getDriver().findElement(By.xpath(productDeletePath));
    }

    public WebElement productPreise(String productName){
        String productPricePath ="//tbody//tr/td[2][text()='"+productName+"']/following-sibling::td[1]";
        return Driver.getDriver().findElement(By.xpath(productPricePath));
    }
    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> productList;
    @FindBy(css= ".btn.btn-success")
    public WebElement orderButton;
    @FindBy(id= "name")
    public WebElement nameInput;
    @FindBy(id= "country")
    public WebElement countryInput;
    @FindBy(id= "city")
    public WebElement cityInput;
    @FindBy(id= "card")
    public WebElement cardInput;
    @FindBy(id= "month")
    public WebElement monthInput;

    @FindBy(id= "year")
    public WebElement yearInput;

    @FindBy(xpath= "//button[@onclick='purchaseOrder()']")
    public WebElement purchaseButton;

    @FindBy(xpath= "//p[@class='lead text-muted ']")
    public WebElement confirmationInfo;

    @FindBy(xpath= "//button[text()='OK']")
    public WebElement okButton ;

    @FindBy(xpath= "//a[text()='Delete']")
    public List<WebElement> deleteButton ;

    public int removeProductFromCart(String productName){
        menu("Cart").click();
        int price = Integer.parseInt(productPreise(productName).getText());
        BrowserUtils.waitFor(2);
        int firstSize = productList.size();
        deleteButton(productName).click();
        BrowserUtils.waitFor(3);
        int lastSize = productList.size();
        Assert.assertEquals(firstSize-1,lastSize);
        return price;
    }

    public void fillOutForm(){
        Faker faker = new Faker();
        nameInput.sendKeys(faker.name().fullName());
        countryInput.sendKeys(faker.country().name());
        cityInput.sendKeys(faker.country().capital());
        cardInput.sendKeys(faker.finance().creditCard());
        monthInput.sendKeys(String.valueOf(faker.number().numberBetween(1,12)));
        yearInput.sendKeys(String.valueOf(faker.number().numberBetween(2024,2033)));
    }

    public int productPreise(){
        String amount = confirmationInfo.getText().split("\n")[1];
       int price = Integer.parseInt(amount.split(" ")[1]);
        return price;
    }

    public int placeOrderAndLogAmount(){
        orderButton.click();
        fillOutForm();
        purchaseButton.click();
        okButton.click();
        return productPreise();
    }

    public void cartControl(){
        try {
            menu("Cart").click();
        } catch (Exception e) {
            menu("Cart").click();
        }
        BrowserUtils.waitFor(2);
        if (deleteButton.size()>0){
            for (WebElement deleteBtn : deleteButton){
                deleteBtn.click();
            }
            BrowserUtils.waitFor(4);
        }

        menu("Home").click();


    }











}
