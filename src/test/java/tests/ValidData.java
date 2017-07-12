package tests;

import app.core.TestBase;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * Created by daniil.ryabov on 11.07.2017.
 */
public class ValidData extends TestBase {
    @Test
    public void validData() throws Exception
    {
        getApp().pagesHelper().regPage().fillAllFieldsRand();
        getApp().pagesHelper().regPage().start();
        Assertions.assertThat(getApp().pagesHelper().regPage().parseSignIn()).isEqualTo("SignIn");
        getApp().pagesHelper().regPage().logout();
    }
    @AfterTest
    public void close()
    {
        getApp().getPagesHelper().regPage().close();
    }
}
