package movies.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.apache.struts2.rest.RestActionSupport;

public class MovieController extends RestActionSupport {

    private static final Logger log = LogManager.getLogger(MovieController.class);

    /*public HttpHeaders index() {
        log.debug("In execute method of class Hello");
        //MessageStore newStore = new MessageStore();
        String message = model.getMessage();
        if (userName != null) {
            model.setMessage(" " + userName);
        }
        if(userSession.get(HELLO_COUNT) != null)
            message+= "\n I've said hello " + userSession.get(HELLO_COUNT)+ " times!";
        model.setMessage(message);

        //model = newStore;
        increaseHelloCount();
        return new DefaultHttpHeaders("index");
    }*/
}
