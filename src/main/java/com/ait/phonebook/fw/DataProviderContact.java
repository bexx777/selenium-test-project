package com.ait.phonebook.fw;

import com.ait.phonebook.model.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {
    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                "Oliver1", "Kan", "838384444893339", "ka44n@gm.com", "Berlin", "k;kok;olkk;"
        });
        list.add(new Object[]{
                "Olive2r", "Kan", "25253252838384893339", "ka33n@gm.com", "Berlin", "k;kok;olkk;"
        });
        list.add(new Object[]{
                "Oliv3er", "Kan", "838384896478783339", "k555an@gm.com", "Berlin", "k;kok;olkk;"
        });
        return list.listIterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewContactForCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader
                (new FileReader(new File("src/test/resources/contact.csv")));

        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");

            list.add(new Object[]{new Contact()
                    .setName(split[0]).setSurName(split[1]).setPhone(split[2]).setEmail(split[3]).setAddress(split[4]).setDesc(split[5])});

            line = reader.readLine();
        }
        return list.iterator();
    }
}
