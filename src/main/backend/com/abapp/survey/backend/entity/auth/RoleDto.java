package com.abapp.survey.backend.entity.auth;

import com.abapp.survey.backend.entity.base.base.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 19/02/2021 12:26
*/
@Entity(name = "role")
public class RoleDto extends BaseEntity {
    @Id
    @Column(name = "role_code", nullable = false, unique = true)
    private String role_code;
    @Column
    private String role_description;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "role_authority",
            joinColumns = @JoinColumn(name = "role_code"),
            inverseJoinColumns = @JoinColumn(name = "authority_code"))
    private Set<AuthorityDto> authorityDtoSet = new HashSet<>();


    public void addAuthority(AuthorityDto authorityDto) {
        this.authorityDtoSet.add(authorityDto);
    }

    public void removeAuthority(AuthorityDto authorityDto) {
        this.authorityDtoSet.remove(authorityDto);
    }


    public String getRole_code() {
        return role_code;
    }

    public void setRole_code(String role_code) {
        this.role_code = role_code;
    }

    public String getRole_description() {
        return role_description;
    }

    public void setRole_description(String role_description) {
        this.role_description = role_description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDto roleDto = (RoleDto) o;
        return Objects.equals(role_code, roleDto.role_code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role_code);
    }
}
