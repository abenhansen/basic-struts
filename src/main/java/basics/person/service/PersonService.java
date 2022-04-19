package basics.person.service;

import basics.person.model.Person;

public interface PersonService {
        Person getPerson(int id);
        void save(Person personBean);
        void update(Person personBean);
}

