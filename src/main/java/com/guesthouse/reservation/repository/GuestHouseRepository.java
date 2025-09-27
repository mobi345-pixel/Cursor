package com.guesthouse.reservation.repository;

import com.guesthouse.reservation.model.GuestHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestHouseRepository extends JpaRepository<GuestHouse, Long> {
    List<GuestHouse> findByCityName(String cityName);
    
    @Query("SELECT gh FROM GuestHouse gh WHERE gh.city.name = :cityName")
    List<GuestHouse> findGuestHousesByCityName(@Param("cityName") String cityName);
}