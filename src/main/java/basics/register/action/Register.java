package basics.register.action;

import basics.register.exceptions.SecurityBreachException;
import basics.register.model.Person;
import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Person personBean;

    public String execute() throws Exception {
        return SUCCESS;
    }

    public Person getPersonBean() {
        return personBean;
    }

    public void setPersonBean(Person person) {
        personBean = person;
    }

    public void validate(){
        if(personBean == null)
                return;
        if (personBean.getFirstName().length() == 0) {
            addFieldError("personBean.firstName", "First name is required.");
        }

        if (personBean.getEmail().length() == 0) {
            addFieldError("personBean.email", "Email is required.");
        }

        if (personBean.getAge() < 18) {
            addFieldError("personBean.age", "Age is required and must be 18 or older");
        }
    }

    public void throwException() throws Exception {

        throw new Exception("Exception thrown from throwException");

    }

    public void throwNullPointerException() throws NullPointerException {

        throw new NullPointerException("Null Pointer Exception thrown from "
                + Register.class.toString());
    }

    public void throwSecurityException() throws SecurityBreachException {

        throw new SecurityBreachException(
                "Security breach exception thrown from throwSecurityException");
    }

}
