package com.abapp.survey.front.util;

import com.abapp.survey.backend.model.IAdminUser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 01:03
*/
public class UserProfileManager {
    public static void setLocalUser(HttpServletRequest request, IAdminUser user){
        HttpSession session = request.getSession(true);
        session.setAttribute(ProjectConstant.APP_USER_SESSION, user);
        request.setAttribute(ProjectConstant.APP_USER_SESSION, user);
    }

    public static void removeLocalUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session!=null){
            session.setAttribute(ProjectConstant.APP_USER_SESSION,null);
        }
        request.setAttribute(ProjectConstant.APP_USER_SESSION,null);
    }
}
