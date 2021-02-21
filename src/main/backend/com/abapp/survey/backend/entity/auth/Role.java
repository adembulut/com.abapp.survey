package com.abapp.survey.backend.entity.auth;

import com.abapp.survey.backend.entity.base.base.BaseEntity;
import com.abapp.survey.backend.entity.user.User;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 19/02/2021 12:26
*/
@Entity(name = "role")
public class Role extends BaseEntity {
    @Id
    @Column(name = "role_code",nullable = false, unique = true)
    private String roleCode;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_description")
    private String roleDescription;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "role_authority",
            joinColumns = @JoinColumn(name = "role_code"),
            inverseJoinColumns = @JoinColumn(name = "authority_code"))
    private Set<Authority> authoritySet = new HashSet<>();


    @ManyToMany(mappedBy = "userRoleList",fetch = FetchType.LAZY)
    private Set<User> userSet = new HashSet<>();


    public Set<Authority> getAuthorityDtoSet() {
        return authoritySet;
    }

    public void setAuthorityDtoSet(Set<Authority> authoritySet) {
        this.authoritySet = authoritySet;
    }

    public Set<User> getUserDtoSet() {
        return userSet;
    }

    public void setUserDtoSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public void addAuthority(Authority authority) {
        this.authoritySet.add(authority);
    }

    public void removeAuthority(Authority authority) {
        this.authoritySet.remove(authority);
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String role_name) {
        this.roleName = role_name;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String role_code) {
        this.roleCode = role_code;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String role_description) {
        this.roleDescription = role_description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(roleCode, role.roleCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleCode);
    }

    @PrePersist
    public void toUpperName(){
        this.roleCode=this.roleCode.toUpperCase();
    }
}
