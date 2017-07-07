import lombok.Data;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
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
    public void before() throws Exception
    {

    }

    @Test
    public void validData() throws Exception
    {
        regPage = new RegPage();
        regPage.setUrl("https://libertex-fxb3-test.web.test.fxclub.org/#modal_register");
        regPage.setFirstName(RandStr()+"");
        regPage.setLastName(RandStr()+"");
        regPage.setLogin(RandStr()+"@mail.com");
        regPage.setPassword(RandStr()+"");
        regPage.setPhone("9999999999");
        regPage.start();

//        regPage = new RegPage("https://libertex-fxb3-test.web.test.fxclub.org/#modal_register", "firstname", "lastname", RandStr()+"@mail.ru","qweqweqw","9999999999");
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
