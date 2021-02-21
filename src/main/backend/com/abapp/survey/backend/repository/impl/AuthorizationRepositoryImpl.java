package com.abapp.survey.backend.repository.impl;

import com.abapp.survey.backend.entity.auth.Page;
import com.abapp.survey.backend.entity.base.base.Status;
import com.abapp.survey.backend.repository.AuthorizationRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 19/02/2021 23:18
*/
public class AuthorizationRepositoryImpl implements AuthorizationRepository {
    private SessionFactory sessionFactory;

    @Override
    public List<Page> getAllPages() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from page p where p.status=:status");
        query.setParameter("status", Status.ACTIVE);
        List<Page> pageList = (List<Page>) query.list();
        session.close();
        return pageList;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
