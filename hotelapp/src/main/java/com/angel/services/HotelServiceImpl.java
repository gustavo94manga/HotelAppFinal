package com.angel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.angel.entities.Hotel;
import com.angel.repository.HotelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Long id, Hotel hotel) {
        Hotel existingHotel = hotelRepository.findById(id).orElse(null);
        if (existingHotel != null) {
            // Update fields of existingHotel with values from hotel
            return hotelRepository.save(existingHotel);
        }
        return null;
    }

    @Override
    public boolean deleteHotel(Long id) {
        if (hotelRepository.existsById(id)) {
            hotelRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Hotel> findHotelsByCustomerIdOrdered(Long customerId) {
        return hotelRepository.findByBookings_Customer_IdOrderByCreateDateDesc(customerId);
    }

    @Override
    public List<Hotel> findHotelsByCity(String city) {
        return hotelRepository.findByCity(city);
    }

    @Override
    public List<Hotel> findHotelsByState(String state) {
        return hotelRepository.findByState(state);
    }

}
