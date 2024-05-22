package com.example.ticketapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Ticket {
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private Long id;

      @OneToOne
      @JoinColumn(name = "flightdto_id")
      private FlightDTO flight;
      private String passengerName;
      private String passengerEmail;
      private String passengerPassport;

}
