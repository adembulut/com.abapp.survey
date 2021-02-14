package com.abapp.survey.front.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class FreeMarkerMessageSource {
	private Logger LOG = LoggerFactory.getLogger(getClass());

	private MessageSource messageSource;

	public FreeMarkerMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public String getMessage(String code, Locale locale) {

		String text = null;

		if (locale == null)
			locale = Locale.getDefault();

		try {
			text = messageSource.getMessage(code, null, locale);
		} catch (Exception e) {
			LOG.error("::getMessage code:{} locale:{} e:{}", code, locale, e.getMessage());
			text = code;
		}

		return text;

	}
}
