package com.abapp.survey.backend.entity.auth;

import com.abapp.survey.backend.entity.base.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 19/02/2021 13:00
*/
@Entity(name = "authority")
public class Authority extends BaseEntity {
    @Id
    @Column(name = "authority_code", nullable = false, unique = true)
    private String authorityCode;
    @Column
    private String authorityDescription;

    public String getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(String authority_code) {
        this.authorityCode = authority_code;
    }

    public String getAuthorityDescription() {
        return authorityDescription;
    }

    public void setAuthorityDescription(String authority_description) {
        this.authorityDescription = authority_description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authority that = (Authority) o;
        return Objects.equals(authorityCode, that.authorityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorityCode);
    }
}
