package com.demoblaze.pages;

import com.demoblaze.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "login2")
    public WebElement loginMenu;

    @FindBy(id = "nameofuser")
    public WebElement nameOfUser;

    public  WebElement menu(String menuName){
        String menuPath="//a[normalize-space(text())='"+menuName+"']";
        return Driver.getDriver().findElement(By.xpath(menuPath));
    }


}
