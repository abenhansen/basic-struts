package basics.person.service;

import basics.person.model.Person;

public class PersonServiceInMemory {
    private static Person person;
    private static String [] carModels = {"Ford","Nissan"};

    public PersonServiceInMemory() {
        if(person == null) {
            person = new Person();
            person.setFirstName("Bruce");
            person.setLastName("Phillips");
            person.setEmail("bphillips@ku.edu");
            person.setSport("basketball");
            person.setGender("not sure");
            person.setResidency("KS");
            person.setOver21(true);
            person.setCarModels(carModels);
            person.setPhoneNumber("123-456-9999");
            person.setAge(30);
        }
    }

    public Person getPerson() {
        return PersonServiceInMemory.person;
    }

    public void save(Person personBean) {
        PersonServiceInMemory.person.setFirstName(personBean.getFirstName());
        PersonServiceInMemory.person.setLastName(personBean.getLastName());
        PersonServiceInMemory.person.setSport(personBean.getSport());
        PersonServiceInMemory.person.setGender(personBean.getGender());
        PersonServiceInMemory.person.setResidency(personBean.getResidency());
        PersonServiceInMemory.person.setOver21(personBean.isOver21());
        PersonServiceInMemory.person.setCarModels(personBean.getCarModels());
        PersonServiceInMemory.person.setEmail(personBean.getEmail());
        PersonServiceInMemory.person.setPhoneNumber(personBean.getPhoneNumber());
        PersonServiceInMemory.person.setAge(personBean.getAge());

    }

}
