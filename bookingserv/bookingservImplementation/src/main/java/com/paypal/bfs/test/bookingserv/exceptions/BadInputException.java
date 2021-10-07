package com.paypal.bfs.test.bookingserv.exceptions;

public class BadInputException extends RuntimeException{
    public BadInputException(String message) {
        super(message);
    }
}
