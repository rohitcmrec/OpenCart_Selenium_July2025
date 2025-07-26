package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void getLoginPageTitleTest(){
        String accTitle= lp.getLoginPageTitle();
        Assert.assertEquals(accTitle, AppConstants.LOGINPAGE_TITLE);
    }

    @Test(priority = 2)
    public void getLoginPageUrlTest(){
        String accUrl= lp.getLoginPageUrl();
        Assert.assertTrue(accUrl.contains(AppConstants.LOGINPAGE_URL));
    }

    @Test(priority = 3)
    public void doLoginTest(){
        lp.doLogin(prop.getProperty("username"),prop.getProperty("password"));
    }
}
