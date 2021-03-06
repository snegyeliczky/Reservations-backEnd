package com.codecool.reservationsbackend.repositories;

import com.codecool.reservationsbackend.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    Hotel getHotelByName(String name);
}
