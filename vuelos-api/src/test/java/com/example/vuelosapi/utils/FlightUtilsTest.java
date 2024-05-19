package com.example.vuelosapi.utils;

import com.example.vuelosapi.models.Flight;
import com.example.vuelosapi.models.FlightDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightUtilsTest {

    @Autowired
    FlightUtils flightUtils;

    @BeforeEach
    public void setUp(){
        List<Flight> flightList;
        List<FlightDTO> flightDtoList;
    }
    @Test
    void flightListMapperTest() {
        double dolarPrice = 1000;
        List<Flight> flightList = new ArrayList<>();
        List<FlightDTO> flightDtoList = new ArrayList<>();
        Flight flight = new Flight();
        flight.setId(1L);
        flight.setOrigin("USH");
        flight.setDestination("EZE");
        flight.setDepartureDateTime("Today");
        flight.setArrivalDateTime("Tomorrow");
        flight.setPrice(200);
        flight.setFrequency("everyday");
        flightList.add(flight);

        flightDtoList = flightUtils.flightListMapper(flightList, dolarPrice);
        FlightDTO flightDTO = flightDtoList.get(0);

        assertEquals(1, flightDTO.getId());
        assertEquals("everyday", flightDTO.getFrequency());
        assertEquals(200000, flightDTO.getConvertedPrice());
    }
}