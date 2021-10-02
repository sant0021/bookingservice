
package com.paypal.bfs.test.bookingserv.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Booking resource
 * <p>
 * Booking resource object
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "first_name",
    "last_name",
    "date_of_birth",
    "checkin",
    "checkout",
    "total_price",
    "deposit",
    "address"
})
public class Booking {

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Booking id")
    private Integer id;
    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    @JsonPropertyDescription("First name")
    private String firstName;
    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    @JsonPropertyDescription("Last name")
    private String lastName;
    /**
     * date of birth
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    @JsonPropertyDescription("date of birth")
    private String dateOfBirth;
    /**
     * checkin
     * (Required)
     * 
     */
    @JsonProperty("checkin")
    @JsonPropertyDescription("checkin")
    private String checkin;
    /**
     * checkout
     * (Required)
     * 
     */
    @JsonProperty("checkout")
    @JsonPropertyDescription("checkout")
    private String checkout;
    /**
     * total price
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    @JsonPropertyDescription("total price")
    private Object totalPrice;
    /**
     * deposit
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    @JsonPropertyDescription("deposit")
    private Object deposit;
    /**
     * Address resource
     * <p>
     * Address resource object
     * (Required)
     * 
     */
    @JsonProperty("address")
    @JsonPropertyDescription("Address resource object")
    private Address address;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * date of birth
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * date of birth
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * checkin
     * (Required)
     * 
     */
    @JsonProperty("checkin")
    public String getCheckin() {
        return checkin;
    }

    /**
     * checkin
     * (Required)
     * 
     */
    @JsonProperty("checkin")
    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    /**
     * checkout
     * (Required)
     * 
     */
    @JsonProperty("checkout")
    public String getCheckout() {
        return checkout;
    }

    /**
     * checkout
     * (Required)
     * 
     */
    @JsonProperty("checkout")
    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    /**
     * total price
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    public Object getTotalPrice() {
        return totalPrice;
    }

    /**
     * total price
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    public void setTotalPrice(Object totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * deposit
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    public Object getDeposit() {
        return deposit;
    }

    /**
     * deposit
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    public void setDeposit(Object deposit) {
        this.deposit = deposit;
    }

    /**
     * Address resource
     * <p>
     * Address resource object
     * (Required)
     * 
     */
    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    /**
     * Address resource
     * <p>
     * Address resource object
     * (Required)
     * 
     */
    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Booking.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null)?"<null>":this.firstName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null)?"<null>":this.lastName));
        sb.append(',');
        sb.append("dateOfBirth");
        sb.append('=');
        sb.append(((this.dateOfBirth == null)?"<null>":this.dateOfBirth));
        sb.append(',');
        sb.append("checkin");
        sb.append('=');
        sb.append(((this.checkin == null)?"<null>":this.checkin));
        sb.append(',');
        sb.append("checkout");
        sb.append('=');
        sb.append(((this.checkout == null)?"<null>":this.checkout));
        sb.append(',');
        sb.append("totalPrice");
        sb.append('=');
        sb.append(((this.totalPrice == null)?"<null>":this.totalPrice));
        sb.append(',');
        sb.append("deposit");
        sb.append('=');
        sb.append(((this.deposit == null)?"<null>":this.deposit));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
