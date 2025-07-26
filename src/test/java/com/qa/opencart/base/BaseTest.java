package com.qa.opencart.base;

import com.qa.opencart.factory.DriverManager;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {

    DriverManager driverManager;
    WebDriver driver;
    protected Properties prop;
    protected LoginPage lp;
    protected AccountsPage accountsPage;
    protected RegisterPage registerPage;

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(@Optional String browser) {
        driverManager = new DriverManager();
        prop = driverManager.initProperty();
        String browserName = browser;
        if (browserName != null) {
            prop.setProperty("browser", browserName);
        }
        driver = driverManager.initDriver(prop);
        lp = new LoginPage(driver);
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
