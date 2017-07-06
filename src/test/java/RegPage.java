import org.openqa.selenium.By;

/**
 * Created by daniil.ryabov on 06.07.2017.
 */
public class RegPage extends Page
{
    private String url;
    private String firstName;
    private String lastName;
    private String phone;

    public void setUrl(String url)
    {
        this.url=url;
    }
    public void setFirstName(String firstName)
    {
        this.firstName=firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName=lastName;
    }
    public void setPhone(String phone)
    {
        this.phone=phone;
    }
    public void setLogin(String login)
    {
        this.login=login;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }

    RegPage()
    {
    }
    RegPage(String url,String firstName, String lastName,String login,String password,String phone) throws Exception
    {
        typeUrl(url);
        Thread.sleep(5000);
        typeLogPass(login,password);
        typeFirstName(firstName);
        typeLastName(lastName);
        typePhone(phone);
        clickDate();
        clickAgree();
        Thread.sleep(500);
        clickReg();
        Thread.sleep(7000);
    }
    public void typeUrl(String url)
    {
        driver.get(url);
        this.url = url;
    }
    public void typeFirstName(String firstName)
    {
        driver.findElement(By.xpath("//*[@id='modal']//*[@name='firstName']")).sendKeys(firstName);
        this.firstName=firstName;
    }
    public void typeLastName(String lastName)
    {
        driver.findElement(By.xpath("//*[@id='modal']//*[@name='lastName']")).sendKeys(lastName);
        this.lastName=lastName;
    }
    public void typeLogin(String login)
    {
        driver.findElement(By.xpath( "//*[@class='modal-content']//input[@name='login']")).sendKeys(login);
        this.login=login;
    }
    public void typePassword(String password)
    {
        driver.findElement(By.xpath( "//*[@class='modal-content']//input[@name='password']")).sendKeys(password);
        this.password=password;
    }
    public void typePhone(String phone)
    {
        driver.findElement(By.xpath("//*[@id='modal']//*[@name='phone']")).sendKeys(phone);
        this.phone=phone;
    }

    public void clickDate() {driver.findElement(By.id("birthDay")).click();}
    public void clickAgree() {driver.findElement(By.xpath("//*[@for='agreement']")).click();}
    public void clickReg() {driver.findElement(By.xpath("//*[@class='modal-footer']//*[@type='submit']")).click();}

    public String parseHelloMessage()
    {
        try
        {
            driver.findElement(By.xpath("//*[@class='modal-welcome white-side']"));
        }
        catch (org.openqa.selenium.NoSuchElementException e)
        {
            return "No hello message";
        }
        return "Hello message";
    }

    public void start() throws Exception
    {
        typeUrl(url);
        Thread.sleep(5000);
        typeLogPass(login,password);
        typeFirstName(firstName);
        typeLastName(lastName);
        typePhone(phone);
        clickDate();
        clickAgree();
        Thread.sleep(500);
        clickReg();
        Thread.sleep(7000);
    }
    @Override
    public void typeLogPass(String login, String password)
    {
        typeLogin(login);
        typePassword(password);
    }
    public void close()
    {
        driver.close();
    }
}
