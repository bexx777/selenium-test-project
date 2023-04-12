package com.ait.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{
    @Test
    public void openHomePageTest() {
        //verify to displayed Home Component form
        //isHomeComponentPresent();
        // System.out.println("Home Component is " + isHomeComponentPresent());
        // isHomeComponentPresent2();
        // isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
        Assert.assertTrue(app.getHome().isHomeComponentPresent());
    }
}
