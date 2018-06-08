package pe.edu.cibertec.application.security.domain;

import javax.persistence.*;

/**
 * Created by CHRISTIAN on 07/06/2018.
 */
@Entity
@Table(name = "AUTHORITIES")
public class Authorities {

    @Id
    @Column(name = "AUTHORITY")
    private String authority;

    @ManyToOne
    @JoinColumn(name = "USERNAME")
    private User user;
}
