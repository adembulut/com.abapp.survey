package com.abapp.survey.backend.entity.user;

import com.abapp.survey.backend.entity.auth.Role;
import com.abapp.survey.backend.entity.base.base.BaseEntity;
import com.abapp.survey.backend.model.IUser;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 19/02/2021 14:20
*/
@Entity(name = "users")
public class User extends BaseEntity implements IUser {
    @Id
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "name_surname")
    private String nameSurname;
    @Column
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    @Transient
    private Locale locale;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_code"))
    private Set<Role> userRoleList = new HashSet<>();

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getNameSurname() {
        return nameSurname;
    }

    @Override
    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public Set<Role> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(Set<Role> userRoleList) {
        this.userRoleList = userRoleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
