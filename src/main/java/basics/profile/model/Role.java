package basics.profile.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "roles", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Role {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    private UUID id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleType name;
    public Role() {
    }
    public Role(RoleType name) {
        this.name = name;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public RoleType getName() {
        return name;
    }
    public void setName(RoleType name) {
        this.name = name;
    }
}

