package com.fullstack.exceptions;


public class StripeException extends RuntimeException {

    public StripeException(Throwable e) {
        super(e);
    }

}
