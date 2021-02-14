package com.abapp.survey.front.config;

import freemarker.template.Configuration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

/*
    Project : com.abapp.survey
    User    : adem.bulut
    Date    : 2/13/21 17:17
*/
public class FreeMarkerConfiguration extends Configuration implements MessageSourceAware, InitializingBean {
    private MessageSource messageSource;

    public FreeMarkerConfiguration() {
        super(VERSION_2_3_26);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//		TemplateLoader templateLoader = super.getTemplateLoader();
        super.setSharedVariable("messageSource", new FreeMarkerMessageSource(messageSource));
        // messageSource.getMessage(code, );
//		TemplateLoader templateLoader;
//		super.setTemplateLoader(templateLoader);
//
//        Map<String, TemplateNumberFormatFactory> customNumberFormats = new HashMap<>();
//        customNumberFormats.put("money", new AliasTemplateNumberFormatFactory("0.##"));
//        setCustomNumberFormats(customNumberFormats);
    }
}

