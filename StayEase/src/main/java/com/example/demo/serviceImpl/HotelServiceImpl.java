package com.example.demo.serviceImpl;

import com.example.demo.dto.BookingDto;
import com.example.demo.dto.HotelDto;
import com.example.demo.model.Hotel;
import com.example.demo.model.HotelBooking;
import com.example.demo.repository.HotelBookingRepository;
import com.example.demo.repository.HotelRepository;
import com.example.demo.service.HotelService;
import com.example.demo.utility.FinalResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {


    private final HotelRepository hotelRepository;

    private final HotelBookingRepository hotelBookingRepository;

    public HotelServiceImpl(HotelRepository hotelRepository, HotelBookingRepository hotelBookingRepository) {
        this.hotelRepository = hotelRepository;
        this.hotelBookingRepository = hotelBookingRepository;
    }


    @Override
    public FinalResponse createHotel(HotelDto hotelDto) {

//        Hotel hotel = Hotel.builder()
//                .hotelName(hotelDto.getHotelName())
//                .location(hotelDto.getLocation())
//                .description(hotelDto.getDescription())
//                .noOfAvailableRooms(hotelDto.getNoOfAvailableRooms())
//                .build();

       // Hotel hotelDetails = hotelRepository.save(hotel);

        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelDto.getHotelName());
        hotel.setDescription(hotelDto.getDescription());
        hotel.setLocation(hotelDto.getLocation());
        hotel.setNoOfAvailableRooms(hotelDto.getNoOfAvailableRooms());

        Hotel hotelDetails = hotelRepository.save(hotel);

        FinalResponse response = new FinalResponse();
        response.setStatus(true);
        response.setMessage("New Hotel Created");
        response.setObject(hotelDetails);
        return response;

    }

    @Override
    public FinalResponse getAllHotelDetails() {

        List<Hotel> getHotelDetails = hotelRepository.findAll();
        List<HotelDto> hotelDtoList = new ArrayList<>();
        for(Hotel hotel : getHotelDetails) {
            HotelDto hotelDto = new HotelDto();
            hotelDto.setId(hotel.getId());
            hotelDto.setHotelName(hotel.getHotelName());
            hotelDto.setDescription(hotel.getDescription());
            hotelDto.setLocation(hotel.getLocation());
            hotelDto.setNoOfAvailableRooms(hotel.getNoOfAvailableRooms());
            hotelDtoList.add(hotelDto);
        }

        FinalResponse response = new FinalResponse();
        response.setStatus(true);
        response.setMessage("All Hotel Details Fetched");
        response.setObject(hotelDtoList);
        return response;
    }

    @Override
    public FinalResponse deleteHotel(long hotelId) {
        hotelRepository.deleteById(hotelId);
        FinalResponse response = new FinalResponse();
        response.setStatus(true);
        response.setMessage("Hotel Got Deleted");
        response.setObject(null);
        return response;
    }

    @Override
    public FinalResponse bookHotel(long hotelId, BookingDto bookingDto) {
        Optional<Hotel> byId = hotelRepository.findById(hotelId);
        Hotel hotel = byId.get();

        // updating the noOfAvailableRooms.
        int n = hotel.getNoOfAvailableRooms() - 1;
        hotel.setNoOfAvailableRooms(n);
        hotelRepository.save(hotel);

        HotelBooking hotelBooking = new HotelBooking();
        hotelBooking.setHotelId(hotelId);
        hotelBooking.setHotelName(bookingDto.getHotelName());
        hotelBooking.setLocation(bookingDto.getLocation());
        hotelBooking.setUserName(bookingDto.getUserName());

        HotelBooking hotelBookingDetails = hotelBookingRepository.save(hotelBooking);

        BookingDto hotelBooked = new BookingDto();
        hotelBooked.setId(hotelBookingDetails.getId());
        hotelBooked.setHotelId(hotelBookingDetails.getHotelId());
        hotelBooked.setHotelName(hotelBookingDetails.getHotelName());
        hotelBooked.setLocation(hotelBookingDetails.getLocation());
        hotelBooked.setUserName(hotelBookingDetails.getUserName());

        FinalResponse response = new FinalResponse();
        response.setStatus(true);
        response.setMessage("Hotel Booked");
        response.setObject(hotelBooked);
        return response;
    }


    @Override
    public FinalResponse deleteBooking(long bookingId) {

        Optional<HotelBooking> byId1 = hotelBookingRepository.findById(bookingId);
        HotelBooking hotelBooking = byId1.get();

        Optional<Hotel> byId = hotelRepository.findById(hotelBooking.getHotelId());
        Hotel hotel = byId.get();

        // updating the noOfAvailableRooms.
        int n = hotel.getNoOfAvailableRooms() + 1;
        hotel.setNoOfAvailableRooms(n);
        hotelRepository.save(hotel);

        hotelBookingRepository.deleteById(bookingId);

        FinalResponse response = new FinalResponse();
        response.setStatus(true);
        response.setMessage("Booking Cancel");
        response.setObject(null);
        return response;

    }


}
