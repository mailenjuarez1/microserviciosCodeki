package com.example.vuelosapi.services;

import com.example.vuelosapi.models.Flight;
import com.example.vuelosapi.repositorys.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;


    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public void createFlight(Flight flight){
        flightRepository.save(flight);
    }

    public Optional<Flight> findFlightById(Long id) {
       return flightRepository.findById(id);
    }

    public Optional<Flight> updateFlight(Flight flight) {
        flightRepository.save(flight);
        return flightRepository.findById(flight.getId());
    }

    public void deleteFlightById(Long id) {
        flightRepository.deleteById(id);
    }

    public List<Flight> getByOrigin(String origin){
        return flightRepository.findByOrigin(origin);
    }

    public List<Flight> getByOriginAndDestination(String origin, String destination){
        return flightRepository.findByOriginAndDestination(origin, destination);
    }

    public List<Flight> getOffer(Integer offerPrice) {
        List<Flight> flights = flightRepository.findAll();
        List<Flight> offerFlights = new ArrayList<>();
        for (Flight flight: flights) {
            if (flight.getPrice() >= offerPrice){
                    offerFlights.add(flight);
            }
        }
        return offerFlights;
    }



}


