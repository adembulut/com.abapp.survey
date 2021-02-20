package com.abapp.survey.backend.entity.auth;

import com.abapp.survey.backend.entity.base.base.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 19/02/2021 15:08
*/
@Entity(name = "page")
@Table(name = "page", uniqueConstraints = {})
public class Page extends BaseEntity {
    @Id
    @Column(name = "url", nullable = false, unique = true)
    private String url;
    private String method;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "authority_code")
    private Authority authority;

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }


}
