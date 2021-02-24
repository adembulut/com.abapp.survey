package com.abapp.survey.backend.repository.impl;

import com.abapp.survey.backend.entity.auth.Role;
import com.abapp.survey.backend.entity.base.base.Status;
import com.abapp.survey.backend.repository.AuthorityRepository;
import com.abapp.survey.contract.model.exception.SurveyException;
import com.abapp.survey.contract.model.exception.TechnicalException;
import com.abapp.survey.contract.model.exception.UserMessageException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 19/02/2021 15:29
*/
public class AuthorityRepositoryImpl implements AuthorityRepository {
    private final Logger logger = LoggerFactory.getLogger(AuthorityRepositoryImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void addRole(Role role) throws SurveyException {
        Role temp = getRole(role.getRoleCode());
        if (temp != null) {
            throw new UserMessageException("survey.error.role.role_duplicate");
        }
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            role.setRoleCode(role.getRoleCode().toUpperCase());
            session.save(role);
            transaction.commit();
        } catch (Exception e) {
            logger.error("an error occurred while saveRole", e);
            throw new TechnicalException(e);
        }
    }

    @Override
    public void updateRole(Role role) throws SurveyException {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            role.setRoleCode(role.getRoleCode().toUpperCase());
            Role temp = getRole(role.getRoleCode());
            if (temp == null) {
                session.close();
                throw new UserMessageException("survey.error.role.role_not_found");
            }
            session.update(role);
            transaction.commit();
        } catch (Exception e) {
            logger.error("an error occurred while updateRole", e);
            throw new TechnicalException(e);
        }
    }

    @Override
    public Role getRole(String code) throws SurveyException {
        try (Session session = sessionFactory.openSession()) {
            Role role = session.get(Role.class, code);
            return role;
        } catch (Exception e) {
            logger.error("an error occurred while getRole", e);
            throw new TechnicalException("survey.error.general.not_found", e);
        }
    }

    @Override
    @Transactional
    public void removeRole(Role role) throws SurveyException {
        try (Session session = sessionFactory.openSession()) {
            Role mainRole = session.get(Role.class, role.getRoleCode());
            if (mainRole == null) {
                throw new UserMessageException("survey.error.role_not_found");
            }
            Transaction transaction = session.beginTransaction();
            session.delete(mainRole);
            transaction.commit();
        } catch (Exception e) {
            logger.error("an error occurred while removeRole", e);
            throw new TechnicalException("survey.error.general.remove", e);
        }
    }

    @Override
    public List<Role> listAllRoles() throws SurveyException {
        try (Session session = sessionFactory.openSession()) {
            String sql = "select a from role a where a.status=:status order by a.roleName";
            Query<Role> query = session.createQuery(sql);
            query.setParameter("status", Status.ACTIVE);
            return query.list();
        } catch (Exception e) {
            logger.error("an error occurred while listAllRoles", e);
            throw new TechnicalException(e);
        }
    }
}
