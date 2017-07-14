package app.pages;

import app.core.AppManager;
import app.helpers.Helper;
import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

import static app.helpers.Helper.isDisplayed;
import static app.helpers.Helper.randStr;

@Data
public class RegPage extends Pages
{
    RegData regData = new RegData();
    private ArrayList<WebElement> errors = new ArrayList<WebElement>();

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
    @FindBy(xpath = "//*[@class='msg msg-error msg-firstName']")
    private WebElement invFirstName;
    @FindBy(xpath = "//*[@class='msg msg-error msg-lastName']")
    private WebElement invLastName;
    @FindBy(xpath = "//*[@class='a-event header-boxlink-a']")
    private WebElement littleWindMenu;
    @FindBy(xpath = "//*[@class='active'][1]")
    private WebElement loadOk;


    public RegPage(AppManager app)
    {
        super(app);
        PageFactory.initElements(getApp().getDriver(), this);
        addErrors();
    }
    private void addErrors()
    {
        errors.add(invLogin);
        errors.add(invPassword);
        errors.add(invFirstName);
        errors.add(invLastName);
    }
    public void setFirstName(String firstName) {
        regData.setFirstName(firstName);}
    public void setLastName(String lastName) {
        regData.setLastName(lastName);}
    public void setPhone(String phone) {
        regData.setPhone(phone);}
    public void setLogin(String login) {
        regData.setLogin(login);}
    public void setPassword(String password) {
        regData.setPassword(password);}

    public void typeFirstName(String firstName) {firstNameField.sendKeys(firstName);}
    public void typeLastName(String lastName) {lastNameField.sendKeys(lastName);}
    public void typeLogin(String login) {loginField.sendKeys(login);}
    public void typePassword(String password) {passwordField.sendKeys(password);}
    public void typePhone(String phone) {phoneField.sendKeys(phone);}

    public void clickDate() {birthDay.click();}
    public void clickAgree() {agree.click();}
    public void clickReg() {regkey.click();}
    public void clickOpenRegWindow() {openRegWindowButton.click();}

    public String parseSignIn()
    {
        try
        {
            getApp().getDriver().findElement(By.name("login"));
        }

        catch (NoSuchElementException e)
        {
            return "SignIn";
        }
        return "No SignIn";
    }

    public void start() throws Exception {
        getApp().getDriver().get(url);
        getApp().getWait().until(ExpectedConditions.visibilityOf(loadOk));
        if(Helper.isDisplayed(littleWindMenu))
            littleWindMenu.click();
        getApp().getWait().until(ExpectedConditions.elementToBeClickable(openRegWindowButton));
        clickOpenRegWindow();
        getApp().getWait().until(ExpectedConditions.elementToBeClickable(regkey));
        typeLogPass(regData.getLogin(), regData.getPassword());
        typeFirstName(regData.getFirstName());
        typeLastName(regData.getLastName());
        typePhone(regData.getPhone());
        clickDate();
        clickAgree();
        getApp().getWait().until(ExpectedConditions.invisibilityOf(regWindow));
        clickReg();
        if (isDisplayed(errors))
        {
            return;
        }
        else
        {
            getApp().getWait().until(ExpectedConditions.elementToBeClickable(menu));
        }
    }


    public void startOnlyLogPass() throws Exception
    {
        getApp().getDriver().get(url);
        getApp().getWait().until(ExpectedConditions.elementToBeClickable(regkey));
        typeLogPass(regData.getLogin(), regData.getPassword());
        clickAgree();
        clickReg();
        getApp().getWait().until(ExpectedConditions.invisibilityOf(modal));
    }

    public void typeLogPass(String login, String password)
    {
        typeLogin(login);
        typePassword(password);
    }

    public void logout()
    {
        getApp().getWait().until(ExpectedConditions.elementToBeClickable(menu));
        menu.click();
        getApp().getWait().until(ExpectedConditions.visibilityOf(logoutKey));
        logoutKey.click();
    }

    public void fillAllFieldsRand()
    {
        setFirstName(randStr() + "");
        setLastName(randStr() + "");
        setLogin(randStr() + "@mail.com");
        setPassword(randStr() + "");
        setPhone("9999999999");
    }


    public void close()
    {
        getApp().getDriver().close();
    }
}