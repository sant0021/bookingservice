package com.paypal.bfs.test.bookingserv.validators;

import com.paypal.bfs.test.bookingserv.exceptions.BadInputException;
import com.paypal.bfs.test.bookingserv.validations.ValidationUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.paypal.bfs.test.bookingserv.exceptions.ErrorMessages.*;
public class ValidationUtilsTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Test
    public void testFirstNameValidation() {
        exception.expect(BadInputException.class);
        exception.expectMessage(EMPTY_OR_NULL_FIRSTNAME);
        ValidationUtils.VALIDATE_FIRSTNAME.accept(null);
    }
    @Test
    public void testLastNameValidation() {
        exception.expect(BadInputException.class);
        exception.expectMessage(EMPTY_OR_NULL_LASTNAME);
        ValidationUtils.VALIDATE_LASTNAME.accept(null);
    }
    @Test
    public void testLine1Validation() {
        exception.expect(BadInputException.class);
        exception.expectMessage(EMPTY_OR_NULL_LINE1);
        ValidationUtils.VALIDATE_LINE1.accept(null);
    }
    @Test
    public void testCityValidation() {
        exception.expect(BadInputException.class);
        exception.expectMessage(EMPTY_OR_NULL_CITY);
        ValidationUtils.VALIDATE_CITY.accept(null);
    }
    @Test
    public void testStateValidation() {
        exception.expect(BadInputException.class);
        exception.expectMessage(EMPTY_OR_NULL_STATE);
        ValidationUtils.VALIDATE_STATE.accept(null);
    }
    @Test
    public void testZipcodeValidation() {
        exception.expect(BadInputException.class);
        exception.expectMessage(EMPTY_OR_NULL_ZIPCODE);
        ValidationUtils.VALIDATE_ZIPCODE.accept(null);
    }
    @Test
    public void testDateOfBirthValidationNull() {
        exception.expect(BadInputException.class);
        exception.expectMessage(EMPTY_OR_NULL_DATE);
        ValidationUtils.VALIDATE_DATE.accept(null);
    }
    @Test
    public void testTotalPriceValidation() {
        exception.expect(BadInputException.class);
        exception.expectMessage(ZERO_TOTAL_PRICE);
        ValidationUtils.VALIDATE_TOTAL_PRICE.accept(null);
    }
    @Test
    public void testDepositValidation() {
        exception.expect(BadInputException.class);
        exception.expectMessage(ZERO_DEPOSIT);
        ValidationUtils.VALIDATE_DEPOSIT.accept(null);
    }
    @Test
    public void testDateOfBirthValidationInvalidDate() {
        exception.expect(BadInputException.class);
        exception.expectMessage(INVALID_DATE_PATTERN);
        ValidationUtils.VALIDATE_DATE_FORMAT.apply("12/03/2021");
        ValidationUtils.VALIDATE_DATE_FORMAT.apply("12-03-2021");
    }
}


