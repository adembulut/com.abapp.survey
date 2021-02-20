package com.abapp.survey.backend.repository;

import com.abapp.survey.backend.entity.auth.Role;
import com.abapp.survey.backend.entity.base.base.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 19/02/2021 15:29
*/
public class AuthorityRepositoryImpl implements AuthorityRepository {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }


    @Override
    public void saveOrUpdateRole(Role role) {
        hibernateTemplate.saveOrUpdate(role);
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.saveOrUpdate(role);
//        transaction.commit();
//        session.close();
    }

    @Override
    public Role getRole(String code) {
        Role role = hibernateTemplate.get(Role.class, code);
//        Session session = sessionFactory.openSession();
//        Role role = (Role) session.get(code, Role.class);
        return role;
    }

    @Override
    public List<Role> listAllRoles() {
        Session session = hibernateTemplate.getSessionFactory().openSession();
//        Session session = sessionFactory.openSession();
        String sql = "select a from role a where a.status=:status order by a.roleName";
        Query<Role> query = session.createQuery(sql);
        query.setParameter("status", Status.ACTIVE);
        List<Role> list = query.list();
        session.close();
        return list;
    }
}
