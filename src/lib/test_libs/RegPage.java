package lib.test_libs;

import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;

import static lib.help_libs.Helper.RandStr;
import static lib.help_libs.Helper.isDisplayed;


@Data
@AllArgsConstructor
public class RegPage extends Page
{
    RegData regData = new RegData();
    @FindBy(xpath = "//*[@class='a-btn a-btn-trans sign-up-btn']")
    private WebElement openRegWindowButton;
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
    @FindBy(id="ui-datepicker-div")
    private WebElement regWindow;
    @FindBy(id= "birthDay")
    private WebElement birthDay;
    @FindBy(xpath = "//*[@for='agreement']")
    private WebElement agree;
    @FindBy(xpath = "//*[@class='modal-footer']//*[@type='submit']")
    private WebElement regkey;
    @FindBy(xpath = "//*[@class='profile-nav-inner']//*[@class='a-event drop-down-link']")
    private WebElement menu;
    @FindBy(xpath = "//*[@id='region-header-profile']//*[@class='box-row profile-logout']//*[@class='a']")
    private WebElement logoutKey;
    @FindBy(id="modal")
    private WebElement modal;
    @FindBy(xpath = "//*[@class='a-event header-boxlink-a drop-down-link']")
    private WebElement mail;
    @FindBy(xpath = "//*[@class='msg msg-error msg-login']")
    private WebElement invLogin;
    @FindBy(xpath = "//*[@class='msg msg-error msg-password']")
    private WebElement invPassword;


    public RegPage()
    {
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();

    }
    public void setFirstName(String firstName) {regData.setFirstName(firstName);}
    public void setLastName(String lastName) {regData.setLastName(lastName);}
    public void setPhone(String phone) {regData.setPhone(phone);}
    public void setLogin(String login) {regData.setLogin(login);}
    public void setPassword(String password) {regData.setPassword(password);}

    public void typeFirstName(String firstName) {firstNameField.sendKeys(firstName);}
    public void typeLastName(String lastName) {lastNameField.sendKeys(lastName);}
    public void typeLogin(String login) {loginField.sendKeys(login);}
    public void typePassword(String password) {passwordField.sendKeys(password);}
    public void typePhone(String phone) {phoneField.sendKeys(phone);}

    public void clickDate() {birthDay.click();}
    public void clickAgree() {agree.click();}
    public void clickReg() {regkey.click();}
    public void clickOpenRegWindow() {openRegWindowButton.click();}

    public String parseHelloMessage()
    {
        try
        {
            driver.findElement(By.name("login"));
        }

        catch (org.openqa.selenium.NoSuchElementException e)
        {
            return "Hello message";
        }
        return "No Hello message";
    }

    public String parseRegForm()
    {
        try
        {
            driver.findElement(By.id("modal"));
        }
        catch (NoSuchElementException e)
        {
            return "No RegForm";
        }
        return "RegForm";
    }

    public void start() throws Exception {
        driver.get(url);
        wait.until(ExpectedConditions.elementToBeClickable(openRegWindowButton));
        clickOpenRegWindow();
        wait.until(ExpectedConditions.elementToBeClickable(regkey));
        typeLogPass(regData.getLogin(), regData.getPassword());
        typeFirstName(regData.getFirstName());
        typeLastName(regData.getLastName());
        typePhone(regData.getPhone());
        clickDate();
        clickAgree();
        wait.until(ExpectedConditions.invisibilityOf(regWindow));
        clickReg();
        if (isDisplayed(invPassword) || isDisplayed(invLogin))
        {
            return;
        }
        else
            wait.until(ExpectedConditions.elementToBeClickable(menu));
    }


    public void startOnlyLogPass() throws Exception
    {
        driver.get(url);
        wait.until(ExpectedConditions.elementToBeClickable(regkey));
        typeLogPass(regData.getLogin(),regData.getPassword());
        clickAgree();
        clickReg();
        wait.until(ExpectedConditions.invisibilityOf(modal));
    }

    @Override
    public void typeLogPass(String login, String password)
    {
        typeLogin(login);
        typePassword(password);
    }

    public void logout()
    {
        wait.until(ExpectedConditions.elementToBeClickable(menu));
        menu.click();
        wait.until(ExpectedConditions.visibilityOf(logoutKey));
        logoutKey.click();
    }

    public void fillAllFieldsRand()
    {
        setFirstName(RandStr() + "");
        setLastName(RandStr() + "");
        setLogin(RandStr() + "@mail.com");
        setPassword(RandStr() + "");
        setPhone("9999999999");
    }


    public void close()
    {
        driver.close();
    }
}