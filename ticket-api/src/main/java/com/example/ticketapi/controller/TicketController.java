package com.example.ticketapi.controller;


import com.example.ticketapi.model.FlightDTO;
import com.example.ticketapi.model.Ticket;
import com.example.ticketapi.service.FlightClient;
import com.example.ticketapi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private FlightClient flightClient;

    //READ FLIGHTS
    @GetMapping("/flights/allflights")
    public List<FlightDTO> getAllFlights(){
        return flightClient.getAllFlights();
    }

    @GetMapping("/flights/{id}")
    Optional<FlightDTO> findFlightById(@PathVariable Long id){
        return flightClient.findFlightById(id);
    }
//
//    //Create TICKET
    @PostMapping("/create")
    public void createTicket(@RequestBody Ticket ticket){
        ticketService.createTicket(ticket);
    }

////    //Read
    @GetMapping("/all")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public Optional<Ticket> findTicketById(@PathVariable Long id){
        return ticketService.findTicketById(id);
    }

    //update
      @PutMapping("/update")
    public Optional<Ticket> updateTicket(@RequestBody Ticket ticket){
        return ticketService.updateTicket(ticket);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public void deleteTicket(@PathVariable Long id){
        ticketService.deleteTicket(id);
    }

}

