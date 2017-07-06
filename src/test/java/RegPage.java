import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by daniil.ryabov on 06.07.2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegPage extends Page
{
    private String url;
    private String firstName;
    private String lastName;
    private String phone;


    @FindBy(xpath = "//*[@id='modal']//*[@name='firstName']")
    private WebElement firstNameField;
    @FindBy(xpath = "//*[@id='modal']//*[@name='lastName']" )
    private WebElement lastNameField;
    @FindBy(xpath = "//*[@class='modal-content']//input[@name='login']")
    private WebElement loginField;



//    RegPage(String url, String firstName, String lastName, String login, String password, String phone) throws Exception {
//        setUrl(url);
//
//        typeUrl(url);
//        Thread.sleep(5000);
//        typeLogPass(login, password);
//        typeFirstName(firstName);
//        typeLastName(lastName);
//        typePhone(phone);
//        clickDate();
//        clickAgree();
//        Thread.sleep(500);
//        clickReg();
//        Thread.sleep(7000);
//    }
    public void typeUrl(String url)
    {
        driver.get(url);
        this.url = url;
    }
    public void typeFirstName(String firstName)
    {
        firstNameField.sendKeys(firstName);
    }
    public void typeLastName(String lastName)
    {
        lastNameField.sendKeys(lastName);
    }
    public void typeLogin(String login)
    {
        loginField.sendKeys(login);
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

    public void setUrl(String url) {
        this.url = url;
    }
}