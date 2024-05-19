package com.example.vuelosapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Flight {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String origin;
   private String destination;
   private String departureDateTime;
   private String arrivalDateTime;
   private double price;
   private String frequency;

   public Flight(String origin, String destination, String departureDateTime, String arrivalDateTime, double price, String frequency) {
      this.origin = origin;
      this.destination = destination;
      this.departureDateTime = departureDateTime;
      this.arrivalDateTime = arrivalDateTime;
      this.price = price;
      this.frequency = frequency;
   }
}
