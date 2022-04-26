package basics.helloworld.action;

import com.opensymphony.xwork2.ActionSupport;
import basics.helloworld.model.MessageStore;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Component
public class HelloAction extends ActionSupport implements SessionAware, ParameterNameAware {
    private MessageStore messageStore;
    private String userName;
    private static int helloCount = 0;
    private Map<String, Object> userSession ;
    private static final String HELLO_COUNT = "helloCount";
    private static final Logger log = LogManager.getLogger(HelloAction.class);


    public String execute() {
        log.debug("In execute method of class Hello");
        messageStore = new MessageStore();
        if (userName != null) {
            messageStore.setMessage( messageStore.getMessage() + " " + userName);
        }
        increaseHelloCount();
        return SUCCESS;
    }


    private void increaseHelloCount() {
        Integer helloCount = (Integer) userSession.get(HELLO_COUNT);
        if (helloCount == null ) {
            helloCount = 1;
        } else {
            helloCount++;
        }
        userSession.put(HELLO_COUNT, helloCount);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session ;
    }

    public boolean acceptableParameterName(String parameterName) {
        boolean allowedParameterName = true ;

        if ( parameterName.contains("session")  || parameterName.contains("request") ) {
            allowedParameterName = false ;
        }

        return allowedParameterName;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }
    public int getHelloCount() {
        return helloCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
