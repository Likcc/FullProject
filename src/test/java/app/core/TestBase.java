package app.core;

import app.pages.Pages;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

/**
 * Created by daniil.ryabov on 11.07.2017.
 */
public class TestBase {

    private AppManager appManager;

    @BeforeSuite(alwaysRun = true)
    public void init(){
        appManager = new AppManager();
        appManager.setDriver(new ChromeDriver());
        appManager.setWait(new WebDriverWait(appManager.getDriver(),10));
    }

    public AppManager getApp(){
        return appManager;
    }
}
