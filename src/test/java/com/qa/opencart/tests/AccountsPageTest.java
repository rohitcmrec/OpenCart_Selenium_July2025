package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppErrors;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AccountsPageTest extends BaseTest {

    @BeforeClass
    public void acSetUp(){
        accountsPage = lp.doLogin(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test(alwaysRun = true)
    public void getAccountsPageTitleTest(){
        String accTitle= accountsPage.getAccountsPageTitle();
        Assert.assertEquals(accTitle, AppConstants.ACCOUNTSPAGE_TITLE, AppErrors.TITLE_NOT_FOUND);
    }

    @Test(alwaysRun = true)
    public void getAccountsPageUrlTest(){
        String accUrl = accountsPage.getAccountsPageUrl();
        Assert.assertTrue(accUrl.contains(AppConstants.ACCOUNTSPAGE_URL),AppErrors.URL_NOT_MATCHED);
    }

    @Test
    public void getAccountsPageHeadersTest(){
        List<String> accHeaders = accountsPage.getAccountsPageHeaders();
        Assert.assertEquals(accHeaders, AppConstants.ACCOUNTSPAGE_HEADERLIST);
    }
}
