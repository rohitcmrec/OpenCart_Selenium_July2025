package com.qa.opencart.pages;

import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    public AccountsPage(WebDriver driver){
        this.driver = driver;
        this.elementUtil = new ElementUtil(driver);
    }

    private By headers = By.xpath("//div[@id='content']//h2");
    private By searchBox = By.xpath("//input[@name='search']");

    public String getAccountsPageTitle(){
        String title = driver.getTitle();
        System.out.println("Accounts page title is "+title);
        return title;
    }

    public String getAccountsPageUrl(){
        String url = driver.getCurrentUrl();
        System.out.println("Accounts page url is "+url);
        return url;
    }

    public List<String> getAccountsPageHeaders(){
        List<WebElement> headers= elementUtil.waitForPresenceOfElemenetsLocated(this.headers, TimeUtil.DEFAULT_TIME);
        List<String> headerText = new ArrayList<>();
        for(WebElement e:headers){
            String text = e.getText();
            headerText.add(text);
        }
        return headerText;
    }

}
