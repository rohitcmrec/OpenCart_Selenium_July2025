package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.errors.AppErrors;
import com.qa.opencart.utils.CSVUtils;
import com.qa.opencart.utils.ExcelUtil;
import com.qa.opencart.utils.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {

    @BeforeClass
    public void registerSetUp() {
        registerPage = lp.navigateToRegister();
    }

    @DataProvider
    public Object[][] userRegisterData1() {
        return new Object[][]{
                {"tom", "jack", "123456789", "123456@qwerty", "yes"},
                {"tom", "jane", "123456789", "123456@qwerty", "yes"},
                {"tom", "hena", "123456789", "123456@qwerty", "yes"},
                {"tom", "sony", "123456789", "123456@qwerty", "yes"}
        };
    }

    @DataProvider
    public Object[][] userRegisterData2(){
        return ExcelUtil.getData("sheet1");
    }

    @DataProvider
    public Object[][] userRegisterData3(){
        return CSVUtils.getData();
    }

    @Test(dataProvider = "userRegisterData3")
    public void doRegisterTest(String fName, String lName, String phone, String pwd, String subs) {
        boolean flag = registerPage.doRegister(fName, lName, StringUtils.randomEmail(), phone, pwd, subs);
        Assert.assertTrue(flag, AppErrors.REGISTER_UNSUCCESSFUL);
    }
}
