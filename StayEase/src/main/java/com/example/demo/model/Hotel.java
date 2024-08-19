package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotel_management")
@Data

public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    Hotel Name, Location, Description, Number of Available Rooms

    @Column(name="hotel_name", columnDefinition = "varchar(200)", unique = true, nullable = false)
    private String hotelName;

    @Column(name="location", columnDefinition = "varchar(500)", unique = false, nullable = false)
    private String location;

    @Column(name="description", columnDefinition = "varchar(500)", unique = false, nullable = false)
    private String  description;

    @Column(name="no_of_available_room", unique = false, nullable = false)
    private int noOfAvailableRooms;


}
