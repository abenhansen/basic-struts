package basics.register.action;

import basics.helloworld.action.HelloAction;
import basics.register.exceptions.SecurityBreachException;
import basics.register.model.Person;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Results({
        @Result(name="success", location="thankyou.jsp"),
        @Result(name="input", location="registerPerson.jsp"),
        @Result(name="error", location="registerPerson.jsp"),
})
@Component
public class Register extends ActionSupport {
    private static final long serialVersionUID = 1L;

    private Person registerPersonBean;
    private static final Logger log = LogManager.getLogger(Register.class);


    @Action("register")
    public String execute() throws Exception {
        log.debug("In execute method of class Register");
        return SUCCESS;
    }

    @Action("registerPerson")
    @SkipValidation
    public String input() throws Exception {
        log.debug("In input method of class Register");
        return INPUT;
    }

    public Person getRegisterPersonBean() {
        return registerPersonBean;
    }

    public void setRegisterPersonBean(Person person) {
        registerPersonBean = person;
    }

    public void validate(){
        if(registerPersonBean == null)
                return;
        if (registerPersonBean.getFirstName().length() == 0) {
            addFieldError("personBean.firstName", "First name is required.");
        }

        if (registerPersonBean.getEmail().length() == 0) {
            addFieldError("personBean.email", "Email is required.");
        }

        if (registerPersonBean.getAge() < 18) {
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
