//import cucumber.api.Scenario;
import lib.test_libs.RegPage;
import lib.help_libs.Helper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.assertj.core.api.Assertions;


public class TestRun {
    RegPage regPage = new RegPage();
//    @BeforeTest
//    public void before() throws Exception
//    {}
//    @BeforeMethod
//    public void before() throws Exception
//    {
//        regPage = new RegPage();
//    }

    @Test
    public void validData() throws Exception
    {
        regPage.fillAllFieldsRand();
        regPage.start();
        Assertions.assertThat(regPage.parseSignIn()).isEqualTo("SignIn");
        regPage.logout();
    }

    @Test
    public void invalidLogin() throws Exception
    {
        regPage.fillAllFieldsRand();
        regPage.setLogin(Helper.randStr()+"");
        regPage.start();
        Assertions.assertThat(regPage.parseSignIn()).isEqualTo("No SignIn");
    }

    @Test()
    public void shortPassword() throws Exception
    {
        regPage.fillAllFieldsRand();
        regPage.setPassword("");
        regPage.start();
        Assertions.assertThat(regPage.parseSignIn()).isEqualTo("No SignIn");
    }

//    @Test
//    public void longPassword() throws Exception
//    {
//        regPage.fillAllFieldsRand();
//        regPage.setPassword(Helper.randStr(70));
//        regPage.start();
//        Assertions.assertThat(regPage.parseSignIn()).isEqualTo("No SignIn");
//    }

//    @AfterTest(alwaysRun = true)
//    public void after(){
//        regPage.close();
//    }
}
