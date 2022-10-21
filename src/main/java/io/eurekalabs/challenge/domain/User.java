package io.eurekalabs.challenge.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String username;
    private String password;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "api_key")
    private String apiKey;
    @Column(name = "creation_date")
    private Date creationDate;
    private boolean enabled;

    public User() {
    }

    public User(String username, String password, String name, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.apiKey = UUID.randomUUID().toString();
        this.creationDate = new Date();
        this.enabled = true;
    }
}
