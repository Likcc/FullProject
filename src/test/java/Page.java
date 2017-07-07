import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by daniil.ryabov on 06.07.2017.
 */
@Data
public abstract class Page
{
 // test
//    protected String login;
//    protected String password;
    WebDriver driver = new ChromeDriver();
    protected abstract void typeLogPass(String login, String password);
}
