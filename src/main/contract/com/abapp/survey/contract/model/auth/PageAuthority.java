package com.abapp.survey.contract.model.auth;

import java.io.Serializable;
import java.util.List;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 03:29
*/
public class PageAuthority implements Serializable {
    private String url;
    private String description;
    private List<Authority> authorityList;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }
}
