package basics.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ProfileDTO {


    private String id;


    private String username;

    private String password;

    private String email;

    private Set<Role> roles = new HashSet<>();
    public ProfileDTO() {
    }

    public ProfileDTO(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile toProfile(){
        Profile profile = new Profile();
        profile.setId(UUID.fromString(id));
        profile.setUsername(username);
        profile.setPassword(password);
        profile.setEmail(email);
        profile.setRoles(roles);
        return profile ;
    }

   /* public String name;

    public LocalDate birthOfDate;*/



}
