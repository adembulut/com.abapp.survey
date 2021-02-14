package com.abapp.survey.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/14/21 22:13
*/
@Controller
public class ErrorController {
    @RequestMapping("error/403")
    public String error403(){
        return "error/403";
    }
}
