package com.paypal.bfs.test.bookingserv.exceptions;

public class ErrorMessages {
    private ErrorMessages() {
    }
    public static final String EMPTY_OR_NULL_BOOKING_OBJECT = "Booking object can't be null";
    public static final String EMPTY_OR_NULL_ADDRESS_OBJECT = "Address object can't be null";
    public static final String EMPTY_OR_NULL_FIRSTNAME = "FirstName can't be null or empty";
    public static final String EMPTY_OR_NULL_LASTNAME = "LastName can't be null or empty";
    public static final String EMPTY_OR_NULL_LINE1= "Line1 can't be null or empty";
    public static final String EMPTY_OR_NULL_CITY = "City can't be null or empty";
    public static final String EMPTY_OR_NULL_STATE = "State can't be null or empty";
    public static final String EMPTY_OR_NULL_ZIPCODE = "Zipcode can't be null or empty";
    public static final String EMPTY_OR_NULL_DATE= "Date can't be null or empty";
    public static final String INVALID_DATE_PATTERN= "Invalid Date pattern. Date format should be DD-MM-YYYY";
    public static final String NO_BOOKING_OBJECT= "No Booking Till Now...";
    public static final String ZERO_TOTAL_PRICE= "Total Price can't be zero";
    public static final String ZERO_DEPOSIT= "Deposit shouldn't be zero";

}
