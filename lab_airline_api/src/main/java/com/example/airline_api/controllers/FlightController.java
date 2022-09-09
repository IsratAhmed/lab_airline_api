package com.example.airline_api.controllers;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.Flight;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        List<Flight> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable long id){
        Flight flight = flightService.getFlightById(id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
        Flight savedFlight = flightService.addNewFlight(flight);
        return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Flight> addPassengerToFlight(@PathVariable long id, @RequestBody Booking booking){
        long passengerId = booking.getPassengerId();
        Flight updatedFlight = flightService.addPassengerToFlight(id, passengerId);
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Flight> removePassengerToFlight(@PathVariable long id, @RequestBody Booking booking){
        long passengerId = booking.getPassengerId();
        Flight updatedFlight = flightService.removePassengerToFlight(id, passengerId);
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity cancelFlight(@PathVariable long id){
        flightService.deleteFlight(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

}
