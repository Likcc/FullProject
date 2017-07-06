import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import java.util.stream.Collectors;

/**
 * Created by daniil.ryabov on 05.07.2017.
 */
public class TestRun {
    RegPage regPage;
    private StringBuilder RandStr()
    {
        String symbols = "qwertyabcdefgj";
        StringBuilder randString = new StringBuilder();
        int count = (int)(Math.random()*50);
        for(int i=0;i<count;i++)
            randString.append(symbols.charAt((int)(Math.random()*symbols.length())));
        return randString;
    }

    @BeforeTest
    public void before() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\daniil.ryabov\\Downloads\\chromedriver_win32\\chromedriver.exe");

    }

    @Test
    public void validData() throws Exception
    {
        regPage = new RegPage("https://libertex-fxb3-test.web.test.fxclub.org/#modal_register", "firstname", "lastname", RandStr()+"@mail.ru","qweqweqw","9999999999");
        Assertions.assertThat(regPage.parseHelloMessage()).isEqualTo("Hello message");
    }

//    @Test(dependsOnMethods = {"validData"})
//    public void invalidLogin() throws Exception
//    {
//        regPage.setLogin(RandStr()+"");
//        regPage.start();
//        Assertions.assertThat(regPage.parseHelloMessage()).isEqualTo("Hello message");
//    }



//    @AfterTest(alwaysRun = true)
//    public void after(){
//        regPage.close();
//    }
}
