package tests;

import app.core.TestBase;
import app.helpers.Helper;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class InvalidLogin extends TestBase {
    @Test
    public void invalidLogin() throws Exception
    {
        getApp().pagesHelper().regPage().fillAllFieldsRand();
        getApp().pagesHelper().regPage().setLogin(Helper.randStr()+"");
        getApp().pagesHelper().regPage().start();
        Assertions.assertThat(getApp().pagesHelper().regPage().parseSignIn()).isEqualTo("No SignIn");
    }
    @AfterTest
    public void close()
    {
        getApp().getPagesHelper().regPage().close();
    }
}
