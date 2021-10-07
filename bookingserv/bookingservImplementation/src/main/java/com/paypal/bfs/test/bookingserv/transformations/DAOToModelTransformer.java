package com.paypal.bfs.test.bookingserv.transformations;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.jpa.model.AddressEntity;
import com.paypal.bfs.test.bookingserv.jpa.model.BookingEntity;

import static com.paypal.bfs.test.bookingserv.validations.ValidationUtils.CONVERT_DATE_STRING;

public class DAOToModelTransformer {

    private DAOToModelTransformer() {
    }

    public static Booking transformDAOToBooking(BookingEntity bookingEntity){
        Booking booking = new Booking();
        booking.setId(bookingEntity.getId());
        booking.setFirstName(bookingEntity.getFirstName());
        booking.setLastName(bookingEntity.getLastName());
        booking.setDateOfBirth(CONVERT_DATE_STRING.apply(bookingEntity.getDateOfBirth()));
        booking.setCheckin(CONVERT_DATE_STRING.apply(bookingEntity.getCheckin()));
        booking.setCheckout(CONVERT_DATE_STRING.apply(bookingEntity.getCheckout()));
        booking.setTotalPrice(bookingEntity.getTotalPrice());
        booking.setDeposit(bookingEntity.getDeposit());
        booking.setAddress(transformDAOToAddress(bookingEntity.getAddressEntity()));
        return booking;
    }


    public static Address transformDAOToAddress(AddressEntity addressEntity){
        Address address = new Address();
        address.setLine1(addressEntity.getLine1());
        address.setLine2(addressEntity.getLine2());
        address.setCity(addressEntity.getCity());
        address.setState(addressEntity.getState());
        address.setZipcode(addressEntity.getZipcode());
        return address;
    }
}