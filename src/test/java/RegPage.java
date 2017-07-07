import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by daniil.ryabov on 06.07.2017.
 */
@Data
//@NoArgsConstructor
@AllArgsConstructor
public class RegPage extends Page
{
    private String url;
    private String firstName;
    private String lastName;
    private String phone;

    public RegPage()
    {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id='modal']//*[@name='firstName']")
    private WebElement firstNameField;
    @FindBy(xpath = "//*[@id='modal']//*[@name='lastName']" )
    private WebElement lastNameField;
    @FindBy(xpath = "//*[@class='modal-content']//input[@name='login']")
    private WebElement loginField;
    @FindBy(xpath="//*[@class='modal-content']//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id='modal']//*[@name='phone']")
    private WebElement phoneField;
    @FindBy(id= "birthDay")
    private WebElement birthDay;
    @FindBy(xpath = "//*[@for='agreement']")
    private WebElement agree;
    @FindBy(xpath = "//*[@class='modal-footer']//*[@type='submit']")
    private WebElement regkey;

    public void typeFirstName(String firstName) {firstNameField.sendKeys(firstName);}
    public void typeLastName(String lastName) {lastNameField.sendKeys(lastName);}
    public void typeLogin(String login) {loginField.sendKeys(login);}
    public void typePassword(String password) {passwordField.sendKeys(password);}
    public void typePhone(String phone) {phoneField.sendKeys(phone);}

    public void clickDate() {birthDay.click();}
    public void clickAgree() {agree.click();}
    public void clickReg() {regkey.click();}

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
        driver.get(url);
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