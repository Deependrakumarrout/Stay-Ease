package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "hotel_booked")
@Data
public class HotelBooking {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    hotelName,location,userName,hotelId
    @Column(name = "hotel_id", nullable = false)
    private Long hotelId;

    @Column(name = "hotel_name", columnDefinition = "varchar(100)", nullable = false)
    private String hotelName;

    @Column(name= "location", columnDefinition = "varchar(200)", nullable = false)
    private String location;

    @Column(name= "user_name", columnDefinition = "varchar(200)", nullable = false)
    private String userName;

}
