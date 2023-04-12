package com.ait.tests;

import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test(priority = 1)
    public void loginRegisteredUserPositiveTest() {
        //click on Login link
        app.getHeader().clickOnLoginLink();
        //verify Registration form is displayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        //fill registration form
        app.getUser().fillLoginRegForm(new User()
                .setEmail("1234567899999@gmail.com")
                .setPassword("1234567890000$Manual"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //verify User logged in
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
        logger.info("User is logged in. Actual result :" + app.getHeader().isSignOutButtonPresent() + ". Expected result: true");
    }

    @Test(priority = 2)
    public void loginRegisteredUserWithInvalidPasswordNegativeTest() {
        //click on Login link
        app.getHeader().clickOnLoginLink();
        //verify Registration form is displayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        //fill registration form
        app.getUser().fillLoginRegForm(new User()
                .setEmail("1234567899999@gmail.com"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //check alert is appeared
        Assert.assertTrue(app.getUser().isAlertPresent());
        logger.info("User is logged in. Actual result :" + app.getHeader().isAlertPresent() + ". Expected result: true");
    }
}