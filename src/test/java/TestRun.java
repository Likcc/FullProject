import lib.TetsLibs.RegPage;
import org.testng.annotations.BeforeTest;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class TestRun {
    RegPage regPage;
    @BeforeTest
    public void before() throws Exception
    {    }

    @Test
    public void validData() throws Exception
    {
        regPage = new RegPage();
        regPage.setUrl("https://libertex-fxb3-test.web.test.fxclub.org/#modal_register");
        regPage.fillAllFieldsRand();
//        regPage.startOnlyLogPass();
        regPage.start();
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
