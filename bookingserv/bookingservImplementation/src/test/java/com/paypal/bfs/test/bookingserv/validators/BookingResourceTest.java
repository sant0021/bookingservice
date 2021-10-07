package com.paypal.bfs.test.bookingserv.validators;

import com.paypal.bfs.test.bookingserv.BookingServApplication;
import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BookingServApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookingResourceTest {
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    Booking booking;
    @Before
    public void init(){
        Address address = new Address();
        address.setLine1("Line1");
        address.setCity("Bangalore");
        address.setState("Karnataka");
        address.setZipcode("560103");
        booking = new Booking();
        booking.setFirstName("testFirstName1");
        booking.setLastName("testLastName1");
        booking.setDateOfBirth("25-11-1989");
        booking.setAddress(address);
    }

    @Test
    public void testCreateBooking(){
        HttpEntity<Booking> entity = new HttpEntity<>(booking, headers);
        booking.setLastName("testLastName1");
        ResponseEntity<Booking> response = restTemplate.exchange(
                createURLWithPort("v1/bfs/bookings"),
                HttpMethod.POST, entity, Booking.class);

        Booking body = response.getBody();
        assertNotNull(body);
        assertEquals(body.getFirstName(), null);
    }

    @Test
    public void testGetBooking(){
        HttpEntity<Booking> entity = new HttpEntity<>(booking, headers);

        //make a post call to insert data into db
        ResponseEntity<Booking> createResponse = restTemplate.exchange(
                createURLWithPort("v1/bfs/bookings"),
                HttpMethod.POST, entity, Booking.class);
        assertNotNull(createResponse.getBody());

        //make a get call
        ResponseEntity<Booking> getResponse = restTemplate.exchange(
                createURLWithPort("v1/bfs/bookings/"+createResponse.getBody().getId()),
                HttpMethod.GET, entity, Booking.class);

        assertNotNull(getResponse.getBody());
        assertEquals(getResponse.getBody().getId(), createResponse.getBody().getId());
        assertEquals(getResponse.getBody().getFirstName(), createResponse.getBody().getFirstName());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}