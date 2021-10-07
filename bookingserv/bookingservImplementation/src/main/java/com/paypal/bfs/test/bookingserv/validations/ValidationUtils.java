package com.paypal.bfs.test.bookingserv.validations;

import com.paypal.bfs.test.bookingserv.exceptions.BadInputException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.paypal.bfs.test.bookingserv.exceptions.ErrorMessages.*;
import static org.apache.commons.lang.StringUtils.isEmpty;

public class ValidationUtils {
    private ValidationUtils(){
    }

    public static final String DATE_FORMAT_STRING = "dd-mm-YYYY";
    public static final Consumer<String> VALIDATE_FIRSTNAME = firstName -> {
        if(isEmpty(firstName))
            throw new BadInputException(EMPTY_OR_NULL_FIRSTNAME);
    };
    public static final Consumer<String> VALIDATE_LASTNAME = lastName -> {
        if(isEmpty(lastName))
            throw new BadInputException(EMPTY_OR_NULL_LASTNAME);
    };
    public static final Consumer<String> VALIDATE_LINE1 = line1 -> {
        if(isEmpty(line1))
            throw new BadInputException(EMPTY_OR_NULL_LINE1);
    };
    public static final Consumer<String> VALIDATE_CITY = city -> {
        if(isEmpty(city))
            throw new BadInputException(EMPTY_OR_NULL_CITY);
    };
    public static final Consumer<String> VALIDATE_STATE = state -> {
        if(isEmpty(state))
            throw new BadInputException(EMPTY_OR_NULL_STATE);
    };

    public static final Consumer<String> VALIDATE_ZIPCODE = zipcode -> {
        if(isEmpty(zipcode))
            throw new BadInputException(EMPTY_OR_NULL_ZIPCODE);
    };
    public static final Consumer<String> VALIDATE_DATE = date -> {
        if(isEmpty(date))
            throw new BadInputException(EMPTY_OR_NULL_DATE);
    };

    public static final Function<String, Date> VALIDATE_DATE_FORMAT = date -> {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_STRING);
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new BadInputException(INVALID_DATE_PATTERN);
        }
    };

    public static final Function<Date, String> CONVERT_DATE_STRING = date -> {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_STRING);
        dateFormat.setLenient(false);
        return dateFormat.format(date);
    };

    public static final Consumer<String> VALIDATE_TOTAL_PRICE = totalprice -> {
        if(isEmpty(totalprice))
            throw new BadInputException(ZERO_TOTAL_PRICE);
    };

    public static final Consumer<String> VALIDATE_DEPOSIT = deposit -> {
        if(isEmpty(deposit))
            throw new BadInputException(ZERO_DEPOSIT);
    };
}