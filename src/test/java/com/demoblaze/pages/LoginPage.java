package com.demoblaze.pages;

import com.demoblaze.utilities.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id = "loginusername")
    public WebElement loginUsernameInput;

    @FindBy(id = "loginpassword")
    public WebElement loginPasswordInput;

    @FindBy(xpath = "//button[@onclick='logIn()']")
    public WebElement loginButton;

    public void login(){
        loginUsernameInput.sendKeys(ConfigReader.get("username"));
        loginPasswordInput.sendKeys(ConfigReader.get("password"));
        loginButton.click();
    }

    public void login(String username,String password){
        loginUsernameInput.sendKeys(username);
        loginPasswordInput.sendKeys(password);
        loginButton.click();
    }




}
