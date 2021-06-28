package test.satyadev;

import com.satyadev.BaseTest;
import com.satyadev.page.SalesForceHomePage;
import com.satyadev.page.SalesForceLoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class SalesForceLoginTest_001 extends BaseTest {

    SalesForceLoginPage loginPage = new SalesForceLoginPage();
    SalesForceHomePage homePage;

    public SalesForceLoginTest_001() {
        String url = properties.getProperty("url");
        System.out.println("url: " + url);
        driver.get(url);
    }

    @Test
    public void testEnterUsername() {
        loginPage.getUsername().sendKeys("TestUsername");
        loginPage.getPassword().sendKeys("TestPassword");
        loginPage.getLoginBtn().click();
    }

//    @Test(priority = 1)
//    public void testLoginPageTitle() {
//        String title = loginPage.validateLoginPageTitle();
//        System.out.println("title: " + title);
//        Assert.assertEquals(title, "Facebook");
//    }
//
//    @Test(priority = 2)
//    public void testLogin() {
//        String username = "test";
//        String password = "password";
//        homePage = loginPage.login(username, password);
//        //homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
//    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }
}
