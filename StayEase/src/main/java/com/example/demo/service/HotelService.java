package com.example.demo.service;

import com.example.demo.dto.BookingDto;
import com.example.demo.dto.HotelDto;
import com.example.demo.utility.FinalResponse;

public interface HotelService {
    FinalResponse createHotel(HotelDto hotelDto);

    FinalResponse getAllHotelDetails();
    FinalResponse deleteHotel(long bookingId);
    FinalResponse bookHotel(long hotelId, BookingDto bookingDto);
    FinalResponse deleteBooking(long bookingId);
}
