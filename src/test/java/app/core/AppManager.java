package app.core;

import app.helpers.Helper;
import app.helpers.PagesHelper;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by daniil.ryabov on 11.07.2017.
 */
@Data
public class AppManager {
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver,10);
    private Helper helper;
    private PagesHelper pagesHelper;

    public PagesHelper pagesHelper(){
        if(pagesHelper == null){
            pagesHelper = new PagesHelper(this);
        }
        return pagesHelper;
    }
}
