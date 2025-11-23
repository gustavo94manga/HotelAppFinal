package com.angel.services;

import java.util.List;

import com.angel.entities.Hotel;

public interface HotelService {
    List<Hotel> getAllHotels();
    Hotel getHotelById(Long id);
    Hotel createHotel(Hotel hotel);
    Hotel updateHotel(Long id, Hotel hotel);
    boolean deleteHotel(Long id);
//    List<Hotel> findHotelsByCustomerEmail(String email);
//    List<Hotel> findHotelsByCustomerId(Long customerId);
    List<Hotel> findHotelsByCustomerIdOrdered(Long customerId);
    List<Hotel> findHotelsByCity(String city);
    List<Hotel> findHotelsByState(String state);
}
