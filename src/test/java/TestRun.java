//import cucumber.api.Scenario;
import lib.test_libs.RegPage;
import lib.help_libs.Helper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class TestRun {
    RegPage regPage;
    @BeforeTest
    public void before() throws Exception
    {
        regPage = new RegPage();
    }

    @Test
    public void validData() throws Exception
    {
        regPage.fillAllFieldsRand();
        regPage.start();
        Assertions.assertThat(regPage.parseHelloMessage()).isEqualTo("Hello message");
        regPage.logout();
    }

    @Test
    public void invalidLogin() throws Exception
    {
        regPage.fillAllFieldsRand();
        regPage.setLogin(Helper.RandStr()+"");
        regPage.start();
        Assertions.assertThat(regPage.parseRegForm()).isEqualTo("RegForm");
    }

    @Test()
    public void invalidPassword() throws Exception
    {
        regPage.fillAllFieldsRand();
        regPage.setPassword("");
        regPage.start();
        Assertions.assertThat(regPage.parseRegForm()).isEqualTo("RegForm");
    }

    @AfterTest(alwaysRun = true)
    public void after(){
        regPage.close();
    }
}
