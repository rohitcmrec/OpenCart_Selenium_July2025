package com.qa.opencart.factory;

import com.qa.opencart.errors.AppErrors;
import com.qa.opencart.exceptions.BrowserException;
import com.qa.opencart.exceptions.FrameworkException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverManager {

    private WebDriver driver;
    public Properties prop;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public OptionManager op;
    public static String highlight;

    public WebDriver initDriver(Properties prop) {
        String browser = prop.getProperty("browser");
        op = new OptionManager(prop);
        highlight = prop.getProperty("highlight");
        System.out.println("Name of the browser is " + browser+Thread.currentThread().getName());
        switch (browser) {
            case "chrome":
                tlDriver.set(new ChromeDriver(op.getChromeOptions()));
                //driver = new ChromeDriver();
                break;
            case "firefox":
                tlDriver.set(new FirefoxDriver());
                //driver = new FirefoxDriver();
                break;
            case "safari":
                tlDriver.set(new SafariDriver());
                //driver = new SafariDriver();
                break;
            case "edge":
                tlDriver.set(new EdgeDriver());
                //driver = new EdgeDriver();
                break;
            default:
                System.out.println("Entered browser is invalid");
                throw new BrowserException(AppErrors.BROWSER_NOT_FOUND);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get(prop.getProperty("url"));
        return getDriver();
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public Properties initProperty() {
        prop = new Properties();
        FileInputStream fp;
        String env = System.getProperty("env");
        if (env == null) {
            env = "qa";
            System.out.println("Environment name is null, hence assigning to QA env");
        }
        try {
            switch (env) {
                case "qa":
                    System.out.println("Environment name is " + env);
                    fp = new FileInputStream("./src/test/resources/config/qaConfig.properties");
                    break;
                case "dev":
                    System.out.println("Environment name is " + env);
                    fp = new FileInputStream("./src/test/resources/config/devConfig.properties");
                    break;
                case "uat":
                    System.out.println("Environment name is " + env);
                    fp = new FileInputStream("./src/test/resources/config/uatConfig.properties");
                    break;
                default:
                    System.out.println("Environment name is null");
                    throw new FrameworkException("Invalid env name");
            }
            prop.load(fp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return prop;
    }

    public static String getScreenshot(String methodName){
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        File src = ts.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir")+"/screenshots/"+methodName+System.currentTimeMillis()+".png";
        File dest = new File(path);
        try {
            FileHandler.copy(src,dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }
}
