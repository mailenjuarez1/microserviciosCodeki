package com.example.vuelosapi.utils;

import com.example.vuelosapi.models.Flight;
import com.example.vuelosapi.models.FlightDTO;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightUtils {

    public List<Flight> detectOffer(List<Flight> flights, double offerPrice){
        return flights.stream()
                .filter(flight -> flight.getPrice() < offerPrice)
                .collect(Collectors.toList());
    }

    public FlightDTO flightMapper(Flight flight, double price){
        return new FlightDTO(flight.getId(),flight.getOrigin(), flight.getDestination(),
                flight.getDepartureDateTime(), flight.getArrivalDateTime(),
                flight.getPrice() * price, flight.getFrequency());
    }
}
