package basics.profile.action;

import basics.profile.model.Profile;
import basics.profile.model.ProfileDTO;
import basics.profile.repositories.ProfileRepository;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.apache.struts2.rest.RestActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class ProfileController extends RestActionSupport implements ModelDriven<Object>, SessionAware {
    private static final Logger log = LogManager.getLogger(ProfileController.class);

    private ProfileDTO model = new ProfileDTO();
    private String id;
    private String username;
    private Collection<Profile> profileList = null;
    private Map<String, Object> userSession;
    private static final String CURRENT_USER = "currentUser";

    @Autowired
    ProfileRepository profileRepository;

  /* public HttpHeaders show() {
        log.debug("Finding User: {}", model);
       System.out.println("ID IS: "+ id);
       Optional<Profile> foundProfile = profileRepository.findById(UUID.fromString(id));
       setModel(foundProfile.get().toProfileDto());
        return new DefaultHttpHeaders("show");
    }*/


    public HttpHeaders show() {
            log.debug("Finding User: {}", model);
           Optional<Profile> foundProfile = profileRepository.findById(UUID.fromString(id));
           setModel(foundProfile.get().toProfileDto());
            return new DefaultHttpHeaders("show");
        }

    @Action("/user/{username}")
    public HttpHeaders findByUsername() {
        log.debug("Finding User: {}", model);
        Optional<Profile> foundProfile = profileRepository.findByUsername(username);
        setModel(foundProfile.get().toProfileDto());
        return new DefaultHttpHeaders("show");
    }

    public HttpHeaders index() {
        log.debug("Finding User: {}", model);
        profileList = profileRepository.findAll();
        return new DefaultHttpHeaders("index");
    }

    @Action("/signup")
    public HttpHeaders create() {
        log.debug("Create new User: {}", model);
        userSession.put(CURRENT_USER, model);
        System.out.println("New model : " + model.getUsername());
        return new DefaultHttpHeaders("success").disableCaching();
    }


    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
    }

    @Override
    public Object getModel() {
        if (profileList != null) {
            return profileList;
        } else {
            return model;
        }
    }

    public void setModel(ProfileDTO model) {
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getUsername() {
        return username;
    }

}
