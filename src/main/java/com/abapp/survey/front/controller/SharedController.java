package com.abapp.survey.front.controller;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

/*
    project : com.abapp.survey
    user    : adem.bulut
    date    : 20/02/2021 19:52
*/
@Controller
public class SharedController {
    private MessageSource messageSource;

    @PostMapping(value = "/bundle",produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String bundle(@RequestParam String bundle,
                         @RequestParam(required = false) String[] args, Locale locale) {
        return messageSource.getMessage(bundle, args, locale);
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
