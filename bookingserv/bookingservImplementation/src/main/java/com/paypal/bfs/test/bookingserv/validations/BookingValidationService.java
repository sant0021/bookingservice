package com.paypal.bfs.test.bookingserv.validations;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.exceptions.BadInputException;
import com.paypal.bfs.test.bookingserv.jpa.BookingRepository;
import com.paypal.bfs.test.bookingserv.jpa.model.BookingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import static com.paypal.bfs.test.bookingserv.exceptions.ErrorMessages.EMPTY_OR_NULL_ADDRESS_OBJECT;
import static com.paypal.bfs.test.bookingserv.exceptions.ErrorMessages.EMPTY_OR_NULL_BOOKING_OBJECT;
import static com.paypal.bfs.test.bookingserv.validations.ValidationUtils.*;

import java.util.Date;

@Service
public class BookingValidationService {
    @Autowired
    private BookingRepository bookingRepository;

    public void validate(Booking booking) {
        if(booking == null)
            throw new BadInputException(EMPTY_OR_NULL_BOOKING_OBJECT);
        if(booking.getAddress() == null)
            throw new BadInputException(EMPTY_OR_NULL_ADDRESS_OBJECT);
        validateBookingFields(booking);
    }

    private void validateBookingFields(Booking booking) {
        VALIDATE_FIRSTNAME.accept(booking.getFirstName());
        VALIDATE_LASTNAME.accept(booking.getLastName());
        VALIDATE_DATE.accept(booking.getDateOfBirth());
        VALIDATE_DATE_FORMAT.apply(booking.getDateOfBirth());
        VALIDATE_DATE.accept(booking.getCheckin());
        VALIDATE_DATE_FORMAT.apply(booking.getCheckin());
        VALIDATE_DATE.accept(booking.getCheckout());
        VALIDATE_DATE_FORMAT.apply(booking.getCheckout());
        VALIDATE_TOTAL_PRICE.accept(String.valueOf(booking.getTotalPrice()));
        VALIDATE_DEPOSIT.accept(String.valueOf(booking.getDeposit()));
        VALIDATE_LINE1.accept(booking.getAddress().getLine1());
        VALIDATE_CITY.accept(booking.getAddress().getCity());
        VALIDATE_STATE.accept(booking.getAddress().getState());
        VALIDATE_ZIPCODE.accept(booking.getAddress().getZipcode());
    }

    public void checkIfbookingAlreadyExist(Booking booking) {
        Optional<BookingEntity> bookingEntity = bookingRepository.findByFirstNameAndLastName(booking.getFirstName(), booking.getLastName());
        if (bookingEntity.isPresent()) {
            throw new BadInputException("Booking already exist with firstname: " + booking.getFirstName() + " lastname: " + booking.getLastName());
        }
    }
}