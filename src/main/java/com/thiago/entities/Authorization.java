package com.thiago.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_authorization")
public class Authorization implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nameAuthorization;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "tb_authorization_user", // Nome da tabela
            joinColumns = @JoinColumn(name = "authorization_id"), // Chave da tabela
            inverseJoinColumns = @JoinColumn(name = "users_id")) // Chave da tabela estrangeira
    private List<User> users = new ArrayList<>();

    public Authorization(){}

    public Authorization(Long id, String nameAuthorization) {
        this.id = id;
        this.nameAuthorization = nameAuthorization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameAuthorization() {
        return nameAuthorization;
    }

    public void setNameAuthorization(String nameAuthorization) {
        this.nameAuthorization = nameAuthorization;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authorization that = (Authorization) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
