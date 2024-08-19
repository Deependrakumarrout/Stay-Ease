package com.example.demo.controller;

import com.example.demo.dto.BookingDto;
import com.example.demo.dto.HotelDto;
import com.example.demo.service.HotelService;
import com.example.demo.utility.FinalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    @GetMapping("/get")
    public String getMe() {
        return "getMe";
    }

    @PostMapping("/create-hotel")
    public FinalResponse createHotel(@RequestBody HotelDto hotelDto) {
        return hotelService.createHotel(hotelDto);
    }


    @GetMapping("/get-all-hotel-details")
    public FinalResponse getHotelDetails() {
        return hotelService.getAllHotelDetails();
    }

    @DeleteMapping("/delete/hotel/{hotelId}")
    public FinalResponse deleteHotel(@PathVariable("hotelId") long hotelId) {
        return hotelService.deleteHotel(hotelId);
    }


    @PostMapping("/{hotelId}/book")
    public FinalResponse bookHotel(@PathVariable("hotelId") long hotelId, @RequestBody BookingDto bookingDto) {
        return hotelService.bookHotel(hotelId, bookingDto);
    }


    //DELETE /bookings/{bookingId}
    @DeleteMapping("/booking/{bookingId}")
    public FinalResponse deleteBooking(@PathVariable("bookingId") long bookingId){
        return hotelService.deleteBooking(bookingId);
    }



//http://localhost:8080/api/v1/hotel/create-hotel

}
