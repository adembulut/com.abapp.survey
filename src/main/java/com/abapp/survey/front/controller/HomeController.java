package com.abapp.survey.front.controller;

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
    public String getLogin() {
        return "login";
    }

    @RequestMapping(value = {"/logout"})
    public String logout(HttpServletRequest request){
        UserProfileManager.removeLocalUser(request);
        return "index";
    }

    @RequestMapping(value = {"/error/403"})
    public String error403(){
        return "error/403";
    }

    @RequestMapping(value = {"/authority-test"})
    public String authorityTest(){

        return "authority-test";
    }

}
