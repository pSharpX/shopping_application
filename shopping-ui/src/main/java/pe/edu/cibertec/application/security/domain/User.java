package pe.edu.cibertec.application.security.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CHRISTIAN on 07/06/2018.
 */
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Authorities> authorities = new HashSet<>();

}
