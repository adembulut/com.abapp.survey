package com.abapp.survey.front.util;

import com.abapp.survey.backend.entity.user.User;
import com.abapp.survey.backend.model.IUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 01:03
*/
public class UserProfileManager {
    public static void setLoggedUser(HttpServletRequest request, IUser user) {
        HttpSession session = request.getSession(true);
        session.setAttribute(ProjectConstant.APP_USER_SESSION, user);
        request.setAttribute(ProjectConstant.APP_USER_SESSION, user);
    }

    public static void removeLoggedUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.setAttribute(ProjectConstant.APP_USER_SESSION, null);
        }
        request.setAttribute(ProjectConstant.APP_USER_SESSION, null);
    }

    public static User getLoggedUser(HttpServletRequest request) {
        if (request == null) return null;
        Object userObject = request.getAttribute(ProjectConstant.APP_USER_SESSION);
        if (userObject instanceof User) {
            return (User) userObject;
        }

        if (userObject == null) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                userObject = session.getAttribute(ProjectConstant.APP_USER_SESSION);
                if (userObject instanceof User) {
                    return (User) userObject;
                }
            }
        }
        return null;
    }
}
