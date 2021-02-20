package com.abapp.survey.backend.repository;

import com.abapp.survey.backend.entity.auth.Page;

import java.util.List;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 19/02/2021 23:18
*/
public interface AuthorizationRepository {
    List<Page> getAllPages();
}
