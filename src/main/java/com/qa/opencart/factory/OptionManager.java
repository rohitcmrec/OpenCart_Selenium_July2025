package com.qa.opencart.factory;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

public class OptionManager {

    private static Properties prop;

    public OptionManager(Properties prop) {
        this.prop = prop;
    }

    public ChromeOptions getChromeOptions() {
        ChromeOptions co = new ChromeOptions();
        if (Boolean.parseBoolean(prop.getProperty("headless"))) {
           // co.addArguments("--headless");
        }
        if (Boolean.parseBoolean(prop.getProperty("incognito"))) {
           // co.addArguments("--incognito");
        }
        return co;
    }
}
