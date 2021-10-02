# bookingserv

## Application Overview
bookingserv is a spring boot rest application which would provide the CRUD operations for `Booking` resource.

There are two modules in this application
- bookingservApi - This module contains the interface.
    - `v1/schema/booking.json` defines the booking resource.
    - `jsonschema2pojo-maven-plugin` is being used to create `Booking POJO` from json file. For more details on plugin please refer `https://github.com/joelittlejohn/jsonschema2pojo#readme`
    - `BookingResource.java` is the interface for CRUD operations on `Booking` resource.
        - POST `/v1/bfs/booking` endpoint defined to create the resource.
- bookingservImplementation - This module contains the implementation for the rest endpoints.
    - `BookingResourceImpl.java` implements the `BookingResource` interface.

## How to run the application
- Please have Maven version `3.3.3` & Java 8 on your system.
- Use command `mvn clean install` to build the project.
- Use command `mvn spring-boot:run` from `bookingservImplementation` folder to run the project.
- Use postman or curl to access `http://localhost:8080/v1/bfs/booking` POST or GET endpoint.

## Assignment
We would like you to enhance the existing project and see you complete the following requirements:

- `booking.json` has only `name`, and `id` elements. Please add `date of birth`, `checkin_datetime`, `checkout_datetime`, `totalprice`, `deposit` and `address` elements to the `Booking` resource. Address will have `line1`, `line2`, `city`, `state` and `zip_code` elements. `line2` is an optional element.
- Add one more operation in `BookingResource` to Get All the bookings. `BookingResource` will have two operations, one to create, and another to retrieve all bookings.
- Implement create and get all the bookings operations in `BookingResourceImpl.java`.
- Please add the unit tests to validate your implementation.
- Please use h2 in-memory database or any other in-memory database to persist the `Booking` resource. Dependency for h2 in-memory database is already added to the parent pom.
- Please make sure the validations done for the requests.*
- Response codes are as per rest guidelines.
- Error handling in case of failures.
- Implement idempotency logic to avoid duplicate resource creation.*


## Input/Output 
Create New Bookings:
Url: http://localhost:8080/v1/bfs/booking
Request body:   
{
    "id": 1,
    "first_name": "first9",
    "last_name": "last9",
    "date_of_birth": "28-05-1998",
    "checkin": "27-03-2021",
    "checkout": "27-03-2021",
    "total_price": 35263.0,
    "deposit": 12187.0,
    "address": {
        "line1": "dgashj",
        "line2": "dyuasd",
        "city": "Bangalore",
        "state": "Karnataka",
        "zipcode": "560103"
    }
}
   
Response:
    {
        "id": 1,
        "first_name": "first9",
        "last_name": "last9",
        "date_of_birth": "28-05-1998",
        "checkin": "27-03-2021",
        "checkout": "27-03-2021",
        "total_price": 35263.0,
        "deposit": 12187.0,
        "address": {
            "line1": "dgashj",
            "line2": "dyuasd",
            "city": "Bangalore",
            "state": "Karnataka",
            "zipcode": "560103"
        }
    }
    
    GetAllBookings:
    Url: http://localhost:8080/v1/bfs/getAllBookings
    [
        {
            "id": 1,
            "first_name": "first1",
            "last_name": "last1",
            "date_of_birth": "28-00-1998",
            "checkin": "27-00-2021",
            "checkout": "27-00-2021",
            "total_price": 35263.0,
            "deposit": 12187.0,
            "address": {
                "line1": "dgashj",
                "line2": "dyuasd",
                "city": "Bangalore",
                "state": "Karnataka",
                "zipcode": "560103"
            }
        },
        {
            "id": 2,
            "first_name": "first2",
            "last_name": "last2",
            "date_of_birth": "28-00-1998",
            "checkin": "27-00-2021",
            "checkout": "27-00-2021",
            "total_price": 35263.0,
            "deposit": 12187.0,
            "address": {
                "line1": "dgashj",
                "line2": "dyuasd",
                "city": "Bangalore",
                "state": "Karnataka",
                "zipcode": "560103"
            }
        },
        {
            "id": 3,
            "first_name": "first3",
            "last_name": "last3",
            "date_of_birth": "28-00-1998",
            "checkin": "27-00-2021",
            "checkout": "27-00-2021",
            "total_price": 35263.0,
            "deposit": 12187.0,
            "address": {
                "line1": "dgashj",
                "line2": "dyuasd",
                "city": "Bangalore",
                "state": "Karnataka",
                "zipcode": "560103"
            }
        }
]



