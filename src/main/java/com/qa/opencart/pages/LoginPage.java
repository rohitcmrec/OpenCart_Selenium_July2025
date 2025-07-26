package com.qa.opencart.pages;

import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    // private webDriver instance
    private WebDriver driver;
    private ElementUtil elementUtil;

    // public constructor to initialize the privtae driver instance
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtil(driver);
    }

    //By locators
    By userName = By.id("input-email");
    By password = By.id("input-password");
    By loginBtn = By.xpath("//input[@value='Login']");
    By register = By.linkText("Register");

    // public action methods
    public String getLoginPageTitle() {
        String title = driver.getTitle();
        System.out.println("Title of the login page is " + title);
        return title;
    }

    public String getLoginPageUrl() {
        String url = driver.getCurrentUrl();
        System.out.println("Current url of login page is " + url);
        return url;
    }

    public AccountsPage doLogin(String userName, String password) {
        elementUtil.doSendKeys(this.userName, userName, TimeUtil.DEFAULT_TIME);
        elementUtil.doActionsSendKeys(this.password, password);
        elementUtil.doClick(this.loginBtn);
        return new AccountsPage(driver);
    }

    public RegisterPage navigateToRegister(){
        elementUtil.doClick(register,TimeUtil.DEFAULT_TIME);
        return new RegisterPage(driver);
    }

}
