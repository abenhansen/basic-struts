package basics.helloworld.action;

import com.opensymphony.xwork2.ActionSupport;
import basics.helloworld.model.MessageStore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorldAction extends ActionSupport {
    private MessageStore messageStore;
    private String userName;
    private static int helloCount = 0;

    private static final Logger log = LogManager.getLogger(HelloWorldAction.class);



    public String execute() {
        log.debug("In execute method of class Hello");
        messageStore = new MessageStore();
        if (userName != null) {
            messageStore.setMessage( messageStore.getMessage() + " " + userName);
        }
        helloCount++;
        return SUCCESS;
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
