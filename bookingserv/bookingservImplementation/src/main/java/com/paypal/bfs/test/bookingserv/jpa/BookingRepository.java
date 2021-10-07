package com.paypal.bfs.test.bookingserv.jpa;

import com.paypal.bfs.test.bookingserv.jpa.model.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

import java.util.Optional;

@Repository
public interface BookingRepository extends  JpaRepository<BookingEntity, Integer> {
    Optional<BookingEntity> findById(Integer id);
    List<BookingEntity> findAll();
    Optional<BookingEntity> findByFirstNameAndLastName(String firstName, String lastName);
}
