package com.abapp.survey.contract.model.auth;

import java.io.Serializable;
import java.util.Objects;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 03:24
*/
public class Authority implements Serializable {
    private String code;
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authority authority = (Authority) o;
        return code.equals(authority.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
