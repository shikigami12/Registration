package org.ua.deth.entity;

import javax.persistence.*;

@Entity(name = "users")
public class User {
    @Id
    private String login;

    @Column
    private String password;

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
