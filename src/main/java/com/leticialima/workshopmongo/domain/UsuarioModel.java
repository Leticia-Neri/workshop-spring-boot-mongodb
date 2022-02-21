package com.leticialima.workshopmongo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Document
public class UsuarioModel {

    @Id
    private String id;
    private String login;
    private String password;
    //private Role role;
    @JsonIgnore
    private Set<Integer> role = new HashSet<>();







    public UsuarioModel(String id, String login, String password, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        setRole(Role.ADMIN);

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

    public Set<Role> getRole() {
        return role.stream().map(Role::toEnum).collect(Collectors.toSet());
    }

    public void setRole(Role roles) {
        role.add(roles.getCode());
    }
}
