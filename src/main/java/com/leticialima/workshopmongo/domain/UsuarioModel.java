package com.leticialima.workshopmongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UsuarioModel {

    @Id
    private String id;
    private String login;
    private String password;

    public UsuarioModel(String id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public UsuarioModel(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
