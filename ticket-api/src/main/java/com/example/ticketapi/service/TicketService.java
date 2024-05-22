package com.example.ticketapi.service;

import com.example.ticketapi.model.Ticket;
import com.example.ticketapi.repository.TicketRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;
//
    public void createTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> findTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public Optional<Ticket> updateTicket(Ticket ticket) {
        ticketRepository.save(ticket);
        return ticketRepository.findById(ticket.getId());
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
