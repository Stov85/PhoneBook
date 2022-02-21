package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> loginValidData(){
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"bobdilan@gmail.com","Bobdil12345$"});
        list.add(new Object[]{"bobdilan@gmail.com","Bobdil12345$"});
        list.add(new Object[]{"bobdilan@gmail.com","Bobdil12345$"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> ContactValidData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Bob","Rob","34225436","bobrob@gmail.com","Haifa","hfgfhbdsjvh"});
        list.add(new Object[]{"Bob","Rob","34225436","bobrob@gmail.com","Haifa","hfgfhbdsjvh"});
        list.add(new Object[]{"Bob","Rob","34225436","bobrob@gmail.com","Haifa","hfgfhbdsjvh"});

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginValidDataModel(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("bobdilan@gmail.com").withPassword("Bobdil12345$")});
        list.add(new Object[]{new User().withEmail("bobdilan@gmail.com").withPassword("Bobdil12345$")});
        list.add(new Object[]{new User().withEmail("bobdilan@gmail.com").withPassword("Bobdil12345$")});


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginValidDataCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/stringslogin.csv")));
String line = reader.readLine();

while (line!=null){
    String[] split = line.split(",");
    list.add(new Object[]{split[0],split[1]});
    line= reader.readLine();
}

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addContactValidDataModel(){
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{Contact.builder().name("John").lastName("Wick").phone("444445555666").email("wick@gmail.com").address("HY").decription("Wick").build()});
        list.add(new Object[]{Contact.builder().name("John").lastName("Wick").phone("444445555664").email("wick1@gmail.com").address("HY").decription("Wick").build()});

       // list.add(new Object[]{new User().withEmail("bobdilan@gmail.com").withPassword("Bobdil12345$")});


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addContactValidDataCSV() throws IOException {

        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line = reader.readLine();

        while(line!=null){
            String[] split=line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(split[0])
                    .lastName(split[1])
                    .decription(split[5])
                    .phone(split[2])
                    .address(split[4])
                    .email(split[3])
                    .build()});
            line=reader.readLine();
        }
        return list.iterator();
    }

    }

