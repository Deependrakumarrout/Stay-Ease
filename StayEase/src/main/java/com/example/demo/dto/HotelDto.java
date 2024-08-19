package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class HotelDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("hotel_name")
    private String hotelName;

    @JsonProperty("location")
    private String location;

    @JsonProperty("description")
    private String  description;

    @JsonProperty("no_of_available_rooms")
    private int noOfAvailableRooms;

}
