import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
    {    }

    @Test
    public void validData() throws Exception
    {
        regPage = new RegPage();
        regPage.setUrl("https://libertex-fxb3-test.web.test.fxclub.org/#modal_register");
        regPage.setFirstName(RandStr() + "");
        regPage.setLastName(RandStr() + "");
        regPage.setLogin(RandStr() + "@mail.com");
        regPage.setPassword(RandStr() + "");
        regPage.setPhone("9999999999");
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

    @AfterTest(alwaysRun = true)
    public void after(){
        regPage.close();
    }
}
