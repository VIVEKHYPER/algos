package com.learn.algos.rest.exception;

public class TreeSearchNotFoundException extends RuntimeException {

    public TreeSearchNotFoundException() {
    }

    public TreeSearchNotFoundException(String message) {
	super(message);
    }

    public TreeSearchNotFoundException(Throwable cause) {
	super(cause);
    }

    public TreeSearchNotFoundException(String message, Throwable cause) {
	super(message, cause);
    }

    public TreeSearchNotFoundException(String message, Throwable cause, boolean enableSuppression,
	    boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

}
