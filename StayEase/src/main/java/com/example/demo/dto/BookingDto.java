package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class BookingDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("hotel_id")
    private Long hotelId;

    @JsonProperty("hotel_name")
    private String hotelName;

    @JsonProperty("location")
    private String location;

    @JsonProperty("user_name")
    private String userName;

}
