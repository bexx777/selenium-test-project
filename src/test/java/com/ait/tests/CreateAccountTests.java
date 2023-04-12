package com.ait.tests;

import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{
    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        //click on Login link
        app.getHeader().clickOnLoginLink();
        //verify Registration form is displayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        //fill registration form
        app.getUser().fillLoginRegForm(new User()
                .setEmail("1234567899999@gmail.com")
                .setPassword("1234567890000$Manual"));
        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        //verify Log out button is displayed
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }
}


