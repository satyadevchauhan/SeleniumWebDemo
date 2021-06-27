package com.satyadev.page;

import com.satyadev.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class FacebookLoginPage extends BaseTest {

    @FindBy(css="#email")
    WebElement username;

    @FindBy(xpath="//*[@id=\"pass\"]")
    WebElement password;

    @FindBy(xpath="//*[@id=\"u_0_d_Ja\"]")
    WebElement loginBtn;

    public FacebookLoginPage(){
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public FacebookHomePage login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginBtn.click();

        return new FacebookHomePage();
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
}
