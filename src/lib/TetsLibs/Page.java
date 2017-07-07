package lib.TetsLibs;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by daniil.ryabov on 06.07.2017.
 */
// new test
@Data
public abstract class Page
{
    WebDriver driver = new ChromeDriver();
    protected abstract void typeLogPass(String login, String password);
}
