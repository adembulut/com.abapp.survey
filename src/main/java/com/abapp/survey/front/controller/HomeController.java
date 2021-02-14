package com.abapp.survey.front.controller;

import com.abapp.survey.front.util.ProjectConstant;
import com.abapp.survey.front.util.UserProfileManager;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/13/21 17:22
*/
@Controller
public class HomeController {

    @RequestMapping(value = {"", "/", "/index"})
    public String getIndex(ModelMap map) {
        Locale locale = LocaleContextHolder.getLocale();
        map.put("name","adme bulut");
        return "index";
    }

    @GetMapping(value = {"/login"})
    public String getLogin(HttpServletRequest request,ModelMap map) {
        String errorMessage =(String)request.getAttribute(ProjectConstant.APP_ATTRIBUTE_ERROR);
        if(errorMessage!=null){
            map.put(ProjectConstant.APP_ATTRIBUTE_ERROR,errorMessage);
        }
        return "login";
    }

    @RequestMapping(value = {"/logout"})
    public String logout(HttpServletRequest request){
        UserProfileManager.removeLocalUser(request);
        return "index";
    }

    @RequestMapping(value = {"/authority-test"})
    public String authorityTest(){

        return "authority-test";
    }

}
