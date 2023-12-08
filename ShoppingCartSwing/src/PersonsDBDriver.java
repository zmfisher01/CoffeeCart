import java.io.*;
import java.util.ArrayList;
import java.util.List;

import models.Person;

public class PersonsDBDriver {

    private final String DATABASE_FILE = "./db/persons.txt";

    private List<Person> persons;

    public PersonsDBDriver() {
        persons = new ArrayList<>();
    }

    public void addPerson(String username, String hashedPassword, boolean isSeller) {
        persons.add(new Person(username, hashedPassword, isSeller));
    }

    public List<Person> getAllPersons() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                persons.add(new Person(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }


    public void deletePerson(String username) {
        persons.removeIf(person -> person.getUsername().equals(username));
        writeAllPersons();
    }

    private void writeAllPersons() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_FILE))) {
            for (Person person : persons) {
                writer.write(person.toSavableString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
