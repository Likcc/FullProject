package app.core;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.URL;

public class TestBase {

    private AppManager appManager;

    @BeforeClass(alwaysRun = true)
    public void init() throws Exception{
        appManager = new AppManager();
        appManager.setDriver(new ChromeDriver());
        appManager.setWait(new WebDriverWait(appManager.getDriver(),10));
    }
    public AppManager getApp(){
        return appManager;
    }
}
