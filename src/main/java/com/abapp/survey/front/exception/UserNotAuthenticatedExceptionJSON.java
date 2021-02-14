package com.abapp.survey.front.exception;

public class UserNotAuthenticatedExceptionJSON extends Exception {
	private static final long serialVersionUID = 1L;

	public UserNotAuthenticatedExceptionJSON(String path) {
		super(path);
	}
}
