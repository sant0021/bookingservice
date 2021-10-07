package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.exceptions.BadInputException;
import com.paypal.bfs.test.bookingserv.jpa.BookingRepository;
import com.paypal.bfs.test.bookingserv.jpa.model.BookingEntity;
import com.paypal.bfs.test.bookingserv.transformations.DAOToModelTransformer;
import com.paypal.bfs.test.bookingserv.validations.BookingValidationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import static com.paypal.bfs.test.bookingserv.exceptions.ErrorMessages.NO_BOOKING_OBJECT;
import static com.paypal.bfs.test.bookingserv.transformations.ModelToDAOTransformer.transformModelToBookingEntity;

@RestController
public class BookingResourceImpl implements BookingResource {

    private final BookingValidationService bookingValidationService;
    private final BookingRepository bookingRepository;

    public BookingResourceImpl(BookingValidationService bookingValidationService,
                               BookingRepository bookingRepository) {
        this.bookingValidationService = bookingValidationService;
        this.bookingRepository = bookingRepository;
    }

    public ResponseEntity<Booking> bookingGetById(Integer id) {
        Optional<BookingEntity> bookingEntityOptional = bookingRepository.findById(id);
        if(bookingEntityOptional.isPresent()){
            Booking booking = DAOToModelTransformer.transformDAOToBooking(bookingEntityOptional.get());
            return new ResponseEntity<Booking>(booking, HttpStatus.OK);
        }else {
            throw new BadInputException(NO_BOOKING_OBJECT);
        }
    }

    @Override
    public ResponseEntity<Booking> createBooking(Booking booking) {
        bookingValidationService.validate(booking);
        bookingValidationService.checkIfbookingAlreadyExist(booking);
        BookingEntity bookingEntity = transformModelToBookingEntity(booking);
        bookingEntity = bookingRepository.save(bookingEntity);
        return bookingGetById(bookingEntity.getId());
    }

    @Override
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<BookingEntity> bookingEntityList = bookingRepository.findAll();
        List<Booking> bookingList=null;
        for(BookingEntity bookingEntity:bookingEntityList) {
                if(bookingList==null) {
                    bookingList=new ArrayList<Booking>();
                }
                bookingList.add(DAOToModelTransformer.transformDAOToBooking(bookingEntity));
        }
        if(bookingList==null) {
                throw new BadInputException(NO_BOOKING_OBJECT);
            } else {
                return new ResponseEntity<>(bookingList, HttpStatus.OK);
            }
        }
}
