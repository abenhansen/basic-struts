package basics.helloworld.action;

import basics.helloworld.model.MessageStore;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.apache.struts2.rest.RestActionSupport;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HelloController extends RestActionSupport implements SessionAware, ParameterNameAware, ModelDriven<MessageStore> {

    private MessageStore model = new MessageStore();
    ;
    private String userName;
    private static int helloCount = 0;
    private Map<String, Object> userSession;
    private static final String HELLO_COUNT = "helloCount";
    private static final Logger log = LogManager.getLogger(HelloController.class);


    public HttpHeaders index() {
        log.debug("In execute method of class Hello");
        //MessageStore newStore = new MessageStore();
        String message = model.getMessage();
        if (userName != null) {
            model.setMessage(" " + userName);
        }
        if (userSession.get(HELLO_COUNT) != null)
            message += "\n I've said hello " + userSession.get(HELLO_COUNT) + " times!";
        model.setMessage(message);

        //model = newStore;
        increaseHelloCount();
        return new DefaultHttpHeaders("index");
    }


    private void increaseHelloCount() {
        Integer helloCount = (Integer) userSession.get(HELLO_COUNT);
        if (helloCount == null) {
            helloCount = 1;
        } else {
            helloCount++;
        }
        userSession.put(HELLO_COUNT, helloCount);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
    }

    public boolean acceptableParameterName(String parameterName) {
        boolean allowedParameterName = true;

        if (parameterName.contains("session") || parameterName.contains("request")) {
            allowedParameterName = false;
        }

        return allowedParameterName;
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

    public void setModel(MessageStore model) {
        this.model = model;
    }

    @Override
    public MessageStore getModel() {
        return model;
    }
}