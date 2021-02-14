package com.abapp.survey.contract.model.auth;

import java.io.Serializable;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 03:24
*/
public class Role implements Serializable {
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
}
