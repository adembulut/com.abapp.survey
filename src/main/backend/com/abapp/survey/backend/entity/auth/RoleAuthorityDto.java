//package com.abapp.survey.backend.entity.auth;
//
//import com.abapp.survey.backend.entity.base.base.BaseEntity;
//
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
///*
//    project : com.abapp.survey
//    user    : adem.bulut
//    date    : 19/02/2021 13:24
//*/
//@Entity(name = "role_autohority")
//public class RoleAuthorityDto extends BaseEntity {
//    @ManyToOne
//    @JoinColumn(name = "role_code",referencedColumnName = "role_code",nullable = false)
//    private RoleDto roleDto;
//    @ManyToOne
//    @JoinColumn(name = "authority_code",referencedColumnName = "authority_code",nullable = false)
//    private AuthorityDto authorityDto;
//
//
//}
