package com.paypal.bfs.test.bookingserv.transformations;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.jpa.model.AddressEntity;
import com.paypal.bfs.test.bookingserv.jpa.model.BookingEntity;

import static com.paypal.bfs.test.bookingserv.validations.ValidationUtils.VALIDATE_DATE_FORMAT;

public class ModelToDAOTransformer {

    private ModelToDAOTransformer() {
    }

    public static BookingEntity transformModelToBookingEntity(Booking booking){
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setFirstName(booking.getFirstName());
        bookingEntity.setLastName(booking.getLastName());
        bookingEntity.setDateOfBirth(VALIDATE_DATE_FORMAT.apply(booking.getDateOfBirth()));
        bookingEntity.setCheckin(VALIDATE_DATE_FORMAT.apply(booking.getCheckin()));
        bookingEntity.setCheckout(VALIDATE_DATE_FORMAT.apply(booking.getCheckout()));
        bookingEntity.setTotalPrice((Double) booking.getTotalPrice());
        bookingEntity.setDeposit((Double)booking.getDeposit());
        bookingEntity.setAddressEntity(transformModelToAddressEntity(booking.getAddress()));
        return bookingEntity;
    }

    public static AddressEntity transformModelToAddressEntity(Address address){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCity(address.getCity());
        addressEntity.setState(address.getState());
        addressEntity.setZipcode(address.getZipcode());
        addressEntity.setLine1(address.getLine1());
        addressEntity.setLine2(address.getLine2());
        return addressEntity;
    }
}