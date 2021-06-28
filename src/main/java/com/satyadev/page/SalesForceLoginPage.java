package com.satyadev.page;

import com.satyadev.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class SalesForceLoginPage extends BaseTest {

    @FindBy(id="username")        //id
    //@FindBy(name="username")      //name
    //@FindBy(classname="username") //class
    //@FindBy(css="#username")      //css selector - id
    //@FindBy(css=".username")      //css selector - class
    //@FindBy(css="input[id='username']")        //css selector id
    //@FindBy(css="input[name='username']")      //css selector name name
    //@FindBy(css="input[class*='username']")      //css selector class with wild card - *
    //@FindBy(xpath="//input[@id='username']")   //xpath with type - input
    //@FindBy(xpath="//*[@id='username']")       //xpath with wild card - *
    WebElement username;

    @FindBy(id="password")
    //@FindBy(css="#password")
    WebElement password;

    @FindBy(id="Login")
    //@FindBy(css="#Login")
    WebElement loginBtn;

    @FindBy(css="#error")
    WebElement error;

    public SalesForceLoginPage(){
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public SalesForceHomePage login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginBtn.click();

        return new SalesForceHomePage();
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }
    public WebElement getError() {
        return error;
    }
}
