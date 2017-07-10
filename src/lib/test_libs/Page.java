package lib.test_libs;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@Data
public abstract class Page
{
    protected String url = "https://libertex-fxb3-test.web.test.fxclub.org";
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver,10);
    protected abstract void typeLogPass(String login, String password);
}
