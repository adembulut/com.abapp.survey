package com.abapp.survey.front.interceptor;

import com.abapp.survey.backend.entity.user.User;
import com.abapp.survey.front.exception.UserNotAuthenticatedException;
import com.abapp.survey.front.exception.UserNotAuthenticatedExceptionJSON;
import com.abapp.survey.front.service.UserLoginService;
import com.abapp.survey.front.util.ProjectConstant;
import com.abapp.survey.front.util.RequestUtils;
import com.abapp.survey.front.util.UserProfileManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Locale;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 00:33
*/
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);
    private String loginPath = null;
    private boolean checkCookie = false;
    private String cookieName = "uuid";

    private boolean securityEnabled;

    private UserLoginService userLoginService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession(false);

        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.isEmpty()) {
            pathInfo = (String) request.getAttribute("org.springframework.web.servlet.HandlerMapping.pathWithinHandlerMapping");
        }

        Object userObject = null;
        if (session != null) {
            userObject = session.getAttribute(ProjectConstant.APP_USER_SESSION);
        }
        if (LOGGER.isDebugEnabled()) {
            String sessionId = null;

            if (session != null) {
                sessionId = session.getId();
            }

            if (userObject instanceof User) {
                User user = (User) userObject;
                LOGGER.debug("::preHandle sessionId:" + sessionId + " path:" + pathInfo + " user.email:" + user.getEmail());
            }
        }

        //security-disabled begin
        if(!securityEnabled) {
            if (userObject == null) {
                User adminUser = new User();
                adminUser.setUsername("adembulut");
                adminUser.setNameSurname("Adem Bulut");
                adminUser.setEmail("adembulutapp@gmail.com");
                adminUser.setLocale(Locale.forLanguageTag("tr_TR"));
                userObject = adminUser;
            }
        }
        //security-disabled end


        String errorMessage = null;
        if ((!(userObject instanceof User)) || isLoginRequest(request, pathInfo)) {

            if (userObject != null)
                session.removeAttribute(ProjectConstant.APP_USER_SESSION);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("::preHandle path:{} username:{} token:{}  userobj:", pathInfo,
                        request.getParameter(ProjectConstant.APP_USERNAME_PARAM),
                        request.getParameter(ProjectConstant.APP_TOKEN_PARAM), userObject);
            }

            User user = checkLogin(session, request);
            String username = RequestUtils.getString(request,ProjectConstant.APP_USERNAME_PARAM,null);
            String password = RequestUtils.getString(request,ProjectConstant.APP_PASSWORD_PARAM,null);
            if(username!=null||password!=null){
                errorMessage = "survey.login.error";
            }

            if (user != null) {
                userObject = user;
            }
        }
        if (userObject == null) {

            if (!"/dashboard".equals(pathInfo) && !"/".equals(pathInfo)) {

                Enumeration parameterNames = request.getParameterNames();

                if (parameterNames.hasMoreElements()) {
                    StringBuilder buf = new StringBuilder();
                    buf.append(pathInfo);
                    buf.append("?");

                    while (parameterNames.hasMoreElements()) {
                        String name = (String) parameterNames.nextElement();

                        if (name.equals(ProjectConstant.APP_USERNAME_PARAM)
                                || name.equals(ProjectConstant.APP_PASSWORD_PARAM)
                                || name.equals(ProjectConstant.APP_TOKEN_PARAM)) {
                            continue;
                        }

                        String value = request.getParameter(name);

                        buf.append(name + "=" + value);
                        if (parameterNames.hasMoreElements())
                            buf.append("&");
                    }
                    request.setAttribute("path2go", buf.toString());
                } else {
                    request.setAttribute("path2go", pathInfo);
                }

            }

            //			String path = pathInfo;
            if (request.getHeader("accept").contains("application/json")) {
                throw new UserNotAuthenticatedExceptionJSON(pathInfo);
            }
            request.setAttribute(ProjectConstant.APP_ATTRIBUTE_ERROR,errorMessage);
            throw new UserNotAuthenticatedException(errorMessage);
        }

        UserProfileManager.setLocalUser(request, (User) userObject);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.isEmpty()) {
            pathInfo = (String) request.getAttribute("org.springframework.web.servlet.HandlerMapping.pathWithinHandlerMapping");
        }
        if("logout".equalsIgnoreCase(pathInfo) || "/logout".equalsIgnoreCase(pathInfo)){
            response.sendRedirect("/");
        }

        Object object = request.getAttribute(ProjectConstant.APP_USER_SESSION);
        if(object==null){
            HttpSession session = request.getSession();
            if(session!=null){
                object=session.getAttribute(ProjectConstant.APP_USER_SESSION);
            }
        }
        if(object!=null){
            modelAndView.addObject(ProjectConstant.APP_USER_SESSION,object);
        }
    }



    private User checkLogin(HttpSession session, HttpServletRequest request)
            throws UserNotAuthenticatedException {

        String username = request.getParameter(ProjectConstant.APP_USERNAME_PARAM);
        String password = request.getParameter(ProjectConstant.APP_PASSWORD_PARAM);

        int token = RequestUtils.getInt(request, ProjectConstant.APP_TOKEN_PARAM, 0);

        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            return null;

        String remoteIP = null;
        remoteIP = request.getHeader(ProjectConstant.HEADER_CLIENT_IP);
        if (remoteIP == null) {
            remoteIP = request.getRemoteAddr();
        }

        String cookieId = null;

        if (checkCookie && cookieName != null) {

            Cookie cookie = WebUtils.getCookie(request, cookieName);

            if (cookie != null) {
                cookieId = cookie.getValue();
            }
        }

        if (cookieId == null && session != null)
            cookieId = session.getId();

        String host = request.getHeader("Host");

        User user = null;

        try {
            user = userLoginService.userLogin(username, password, token, remoteIP, host, cookieId);
        } catch (Exception e) {
            LOGGER.error("::checkAccUserLogin error! username:{} remoteIP:{}", username, remoteIP, e);
        }

        if (user == null) {
            LOGGER.error("::checkAccUserLogin user is Null! username:{} remoteIP:{}", username, remoteIP);
            return null;
        }
        return user;
    }

    private boolean isLoginRequest(HttpServletRequest request, String path) {

        String username = request.getParameter(ProjectConstant.APP_USERNAME_PARAM);
        String password = request.getParameter(ProjectConstant.APP_PASSWORD_PARAM);

        return (path != null && path.equals(loginPath))
                || (username != null && username.length() > 0 && password != null && password.length() > 0);
    }

    public void setUserLoginService(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    public boolean isSecurityEnabled() {
        return securityEnabled;
    }

    public void setSecurityEnabled(boolean securityEnabled) {
        this.securityEnabled = securityEnabled;
    }
}
