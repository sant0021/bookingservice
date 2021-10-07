package com.paypal.bfs.test.bookingserv.validators;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.exceptions.BadInputException;
import com.paypal.bfs.test.bookingserv.validations.BookingValidationService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import static com.paypal.bfs.test.bookingserv.exceptions.ErrorMessages.*;
@RunWith(SpringRunner.class)
public class BookingValidationServiceTest {

    @InjectMocks
    private BookingValidationService bookingValidationService;
    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Test
    public void testValidateWithNull() {
        exception.expect(BadInputException.class);
        exception.expectMessage(EMPTY_OR_NULL_BOOKING_OBJECT);
        bookingValidationService.validate(null);
    }

    @Test
    public void testValidateWithAddressNull() {
        exception.expect(BadInputException.class);
        exception.expectMessage(EMPTY_OR_NULL_ADDRESS_OBJECT);
        Booking booking = new Booking();
        booking.setAddress(null);
        bookingValidationService.validate(booking);
    }

    @Test
    public void testValidateWithPositive() {
        Address address = new Address();
        address.setLine1("Line1");
        address.setCity("Bangalore");
        address.setState("Karnataka");
        address.setZipcode("560103");
        Booking booking = new Booking();
        booking.setFirstName("testFirstName1");
        booking.setLastName("testLastName1");
        booking.setDateOfBirth("25-11-1989");
        booking.setCheckin("26-12-2021");
        booking.setCheckout("01-01-2022");
        booking.setAddress(address);
        bookingValidationService.validate(booking);
    }
}