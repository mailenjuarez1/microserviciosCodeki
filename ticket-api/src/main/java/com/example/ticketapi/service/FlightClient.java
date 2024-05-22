package com.example.ticketapi.service;

import com.example.ticketapi.model.FlightDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name= "flight-api")
public interface FlightClient {

    @GetMapping("/flights/allflights")
    List<FlightDTO> getAllFlights();

    @GetMapping("/flights/{id}")
    Optional<FlightDTO> findFlightById(@PathVariable Long id);
}
