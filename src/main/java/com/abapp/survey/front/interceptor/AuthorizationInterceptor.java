package com.abapp.survey.front.interceptor;

import com.abapp.survey.contract.model.auth.Authority;
import com.abapp.survey.contract.model.auth.Page;
import com.abapp.survey.contract.model.user.AdminUser;
import com.abapp.survey.contract.service.AuthorizationService;
import com.abapp.survey.front.exception.UserNotAuthorizedException;
import com.abapp.survey.front.util.ProjectConstant;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 03:33
*/
public class AuthorizationInterceptor implements HandlerInterceptor {
    private AuthorizationService authorizationService;
    private List<Page> pageSet;

    public void init() {
        pageSet = authorizationService.getAllPages();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.isEmpty()) {
            pathInfo = (String) request.getAttribute("org.springframework.web.servlet.HandlerMapping.pathWithinHandlerMapping");
        }
        if(pathInfo==null){
            return true;
        }
//        if(pathInfo.startsWith("/")){
//            pathInfo = pathInfo.substring(1);
//        }
        if(pathInfo.endsWith("/")){
            pathInfo = pathInfo.substring(0,pathInfo.length()-1);
        }
        if("/".equals(pathInfo)||"".equalsIgnoreCase(pathInfo)){
            return true;
        }

        String finalPathInfo = pathInfo;
        Optional<Page> optionalPageAuthority = pageSet.stream().filter(x->x.getUrl().equalsIgnoreCase(finalPathInfo)).findFirst();
        if(!optionalPageAuthority.isPresent()){
            return true;
        }
        Object userObject = request.getParameter(ProjectConstant.APP_USER_SESSION);
        if(userObject==null){
            HttpSession session = request.getSession();
            if(session!=null){
                userObject= session.getAttribute(ProjectConstant.APP_USER_SESSION);
            }
        }

        if(userObject==null || !(userObject instanceof AdminUser)){
            return true;
        }
        AdminUser user = (AdminUser) userObject;
        List<Authority> authorityList = user.getAuthorityList();
        Page page = optionalPageAuthority.get();

        if(page.getAuthorityList()!=null){
            boolean have = false;
            for (Authority authority : page.getAuthorityList()) {
                if(authorityList.contains(authority)){
                    have=true;
                }
            }
            if(!have){
                throw new UserNotAuthorizedException();
            }
        }
        return true;
    }


    public void setAuthorizationService(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }
}
