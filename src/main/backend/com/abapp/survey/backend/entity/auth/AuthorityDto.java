package com.abapp.survey.backend.entity.auth;

import com.abapp.survey.backend.entity.base.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 19/02/2021 13:00
*/
@Entity(name = "authority")
public class AuthorityDto extends BaseEntity {
    @Id
    @Column(name = "authority_code", nullable = false, unique = true)
    private String authority_code;
    @Column
    private String authority_description;

    @ManyToMany(mappedBy = "authorityDtoSet")
    private Set<RoleDto> roleDtoSet = new HashSet<>();

    public String getAuthority_code() {
        return authority_code;
    }

    public void setAuthority_code(String authority_code) {
        this.authority_code = authority_code;
    }

    public String getAuthority_description() {
        return authority_description;
    }

    public void setAuthority_description(String authority_description) {
        this.authority_description = authority_description;
    }

    public Set<RoleDto> getRoleDtoSet() {
        return roleDtoSet;
    }

    public void setRoleDtoSet(Set<RoleDto> roleDtoSet) {
        this.roleDtoSet = roleDtoSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorityDto that = (AuthorityDto) o;
        return Objects.equals(authority_code, that.authority_code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authority_code);
    }
}
