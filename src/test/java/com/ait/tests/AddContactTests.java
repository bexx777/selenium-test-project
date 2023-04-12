package com.ait.tests;

import com.ait.phonebook.model.Contact;
import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase {



    //precondition: 1. User is logged out, 2. log in
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            app.getHeader().clickOnLoginLink();

            app.getUser().fillLoginRegForm(new User()
                    .setEmail("1234567899999@gmail.com")
                    .setPassword("1234567890000$Manual"));
            app.getUser().clickOnLoginButton();
        }
    }

    @Test
    public void addContactPositiveTests() {
        //click on Add link
        app.getHeader().clickOnAddLink();
        //fill add contact form
        app.getContact().addContact(new Contact().setName("Karl")
                .setSurName("Adam")
                .setPhone("1234567899999")
                .setEmail("adam@gm.com")
                .setAddress("Koblenz")
                .setDesc("torwart"));

        //click on Save button
        app.getContact().clickOnSaveButton();

        //verify new contact is added
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));
    }

    @Test(dataProvider = "addNewContactForCSV",dataProviderClass = DataProvider.class)
    public void addContactPositiveFormCSVProviderTests(Contact contact) {
        //click on Add link
        app.getHeader().clickOnAddLink();
        //fill add contact form
        app.getContact().addContact(contact);

        //click on Save button
        app.getContact().clickOnSaveButton();

        //verify new contact is added
        app.getContact().isContactCreated("Karl");
    }
    @Test(dataProvider = "addNewContact",dataProviderClass = DataProvider.class)
    public void addContactPositiveFormDataProviderTests(String name, String surName, String phone, String email, String address, String desc) {
        //click on Add link
        app.getHeader().clickOnAddLink();
        //fill add contact form
        app.getContact().addContact(new Contact()
                .setName(name)
                .setSurName(surName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDesc(desc));

        //click on Save button
        app.getContact().clickOnSaveButton();

        //verify new contact is added
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));
    }
}