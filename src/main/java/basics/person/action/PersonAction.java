package basics.person.action;

import basics.person.model.Person;
import basics.person.model.State;
import basics.person.service.CarModelsService;
import basics.person.service.CarModelsServiceHardCoded;
import basics.person.service.PeopleService;
import basics.person.service.PersonService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.validation.SkipValidation;

import java.util.*;

public class PersonAction extends ActionSupport implements Preparable {

    private static final long serialVersionUID = 1L;

    private PersonService peopleService;

    private Person personBean;
    int id;
    private static SortedMap<Integer, Person> people = PeopleService.getPeople();

    private String[] sports = {"football", "baseball", "basketball", "Table Tennis"};

    private String[] genders = {"male", "female", "not sure"};

    private List<State> states;

    private CarModelsService carModelsService = new CarModelsServiceHardCoded();

    private String[] carModelsAvailable;

    private static final Logger log = LogManager.getLogger(PersonAction.class);

    @SkipValidation
    public String execute() throws Exception {
        log.debug("In execute method");
        System.out.println("People" + people);
        //personService.savePerson( getPersonBean() );
        return SUCCESS;
    }

    @Override
    public void prepare() throws Exception {
        log.debug("In prepare method...");
        carModelsAvailable = carModelsService.getCarModels();
        if (id != 0)
            personBean = peopleService.getPerson(id);
        else personBean = new Person();
    }

    public void prepareExecute() {
        log.debug("In prepareExecute method...");
    }

/*    public String input() throws Exception {
        log.debug("In input method");
        if(id != 0)
            personBean = peopleService.getPerson(id);
        else personBean = new Person();
        return INPUT;
    }*/

    @SkipValidation
    public String edit() throws Exception {
        log.debug("In edit method");
        if (id != 0)
            personBean = peopleService.getPerson(id);
        else personBean = new Person();
        return INPUT;
    }

    public String saveOrUpdate() {
        log.debug("In saveOrUpdate method");
        if (personBean.getId() != 0) {
            log.debug("Updating :" + personBean.getId());
            peopleService.update(personBean);
        } else {
            log.debug("New");
            peopleService.save(personBean);
        }
        people = PeopleService.getPeople();
        System.out.println("People" + people);
        return SUCCESS;
    }

    public Person getPersonBean() {
        return personBean;

    }

    public void setPersonBean(Person personBean) {
        this.personBean = personBean;

    }


    public List<String> getSports() {
        return Arrays.asList(sports);
    }

    public List<String> getGenders() {
        return Arrays.asList(genders);
    }

    public List<Person> getPeople() {
        return new ArrayList<Person>(people.values());
    }

    public List<State> getStates() {
        states = new ArrayList<State>();
        states.add(new State("AZ", "Arizona"));
        states.add(new State("CA", "California"));
        states.add(new State("FL", "Florida"));
        states.add(new State("KS", "Kansas"));
        states.add(new State("NY", "New York"));
        return states;
    }

    public String[] getCarModelsAvailable() {
        return carModelsAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPersonService(PersonService peopleService) {
        this.peopleService = peopleService;
    }
}