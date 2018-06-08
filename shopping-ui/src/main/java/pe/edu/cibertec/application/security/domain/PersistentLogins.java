package pe.edu.cibertec.application.security.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by CHRISTIAN on 07/06/2018.
 */
@Entity
@Table(name = "LOGINS_PERSISTENT")
public class PersistentLogins {

    @Id
    @Column(name = "SERIES")
    private String series;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "TOKEN", nullable = false)
    private String token;

    @Column(name = "LAST_USED", nullable = false)
    private Date lastUsed;
}