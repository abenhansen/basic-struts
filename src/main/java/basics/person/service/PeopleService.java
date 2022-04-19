package basics.person.service;

import basics.person.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.TreeMap;

public class PeopleService implements PersonService {
    private static Person person;
    private static SortedMap<Integer, Person> people = new TreeMap<>();
    private static final Logger log = LogManager.getLogger(PersonService.class);

    public PeopleService() {
        if (people.size() == 0) {
            people.put(1, new Person(1, "Bruce", "Phillips", "basketball", "not sure",
                    "KS", true, new String[]{"Ford", "Nissan"}, "bphillips@ku.edu", "123-456-9999", 30));
            people.put(2, new Person(2, "Svend", "Erik", "Table Tennis", "male",
                    "NY", true, new String[]{"Mercedes", "Tesla"}, "svend@ny.dk", "123-456-8888", 25));
        }
    }

    public static SortedMap<Integer, Person> getPeople() {
        return people;
    }

    public Person getPerson(int id) {
        return people.get(id);
    }


    public void save(Person person) {
        int newId = getNewId();
        person.setId(newId);
        people.put(newId, person);
        //rebuildPersonList();
    }

    public  void update(Person person) {
        people.replace(person.getId(), person);
        //rebuildPersonList();
    }

    public void deletePerson(int ID) {
        people.remove(ID);
        //rebuildPersonList();
    }


    private int getNewId() {
        int newId = 0;

        try {
            newId = people.lastKey() + 1;
        } catch (NoSuchElementException ex) {
            log.info("Id value set to 0");
        }

        return newId;
    }

}

