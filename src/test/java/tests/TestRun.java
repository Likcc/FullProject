package tests;
import app.core.AppManager;
import app.core.TestBase;
import app.helpers.Helper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;


public class TestRun extends TestBase {

//    @BeforeTest
//    public void before() throws Exception
//    {
//        getApp().pagesHelper().regPage();
//    }
//    @BeforeMethod
//    public void before() throws Exception
//    {
//        regPage = new RegPage();
//    }

    @Test
    public void validData() throws Exception
    {
        getApp().pagesHelper().regPage().fillAllFieldsRand();
        getApp().pagesHelper().regPage().start();
        Assertions.assertThat(getApp().pagesHelper().regPage().parseSignIn()).isEqualTo("SignIn");
        getApp().pagesHelper().regPage().logout();
    }

    @Test
    public void invalidLogin() throws Exception
    {
        getApp().pagesHelper().regPage().fillAllFieldsRand();
        getApp().pagesHelper().regPage().setLogin(Helper.randStr()+"");
        getApp().pagesHelper().regPage().start();
        Assertions.assertThat(getApp().pagesHelper().regPage().parseSignIn()).isEqualTo("No SignIn");
    }

    @Test()
    public void shortPassword() throws Exception
    {
        getApp().pagesHelper().regPage().fillAllFieldsRand();
        getApp().pagesHelper().regPage().setPassword("");
        getApp().pagesHelper().regPage().start();
        Assertions.assertThat(getApp().pagesHelper().regPage().parseSignIn()).isEqualTo("No SignIn");
    }

    @Test
    public void noFirstName() throws Exception
    {
        getApp().pagesHelper().regPage().fillAllFieldsRand();
        getApp().pagesHelper().regPage().setFirstName("");
        getApp().pagesHelper().regPage().start();
        Assertions.assertThat(getApp().pagesHelper().regPage().parseSignIn()).isEqualTo("No SignIn");
    }

    @Test
    public void noLastName() throws Exception
    {
        getApp().pagesHelper().regPage().fillAllFieldsRand();
        getApp().pagesHelper().regPage().setLastName("");
        getApp().pagesHelper().regPage().start();
        Assertions.assertThat(getApp().pagesHelper().regPage().parseSignIn()).isEqualTo("No SignIn");
    }
    //    @AfterTest(alwaysRun = true)
//    public void after(){
//        getApp().pagesHelper().regPage().close();
//    }
}
