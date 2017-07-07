//import cucumber.api.Scenario;
import lib.TetsLibs.RegPage;
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

    //Scenario: "whensmth"
    @Test
    public void validData() throws Exception
    {
        regPage.setUrl("https://libertex-fxb3-test.web.test.fxclub.org/#modal_register");
        regPage.fillAllFieldsRand();
//        regPage.startOnlyLogPass();
        regPage.start();
        Assertions.assertThat(regPage.parseHelloMessage()).isEqualTo("Hello message");
//        regPage.logout();
    }

    @Test
    public void invalidLogin() throws Exception
    {
        regPage.setUrl("https://libertex-fxb3-test.web.test.fxclub.org/#modal_register");
        regPage.fillAllFieldsRand();
        regPage.setLogin(RegPage.RandStr()+"");
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
