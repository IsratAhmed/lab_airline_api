package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.services.FlightService;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightService flightService;

    @Autowired
    PassengerService passengerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Flight flight = new Flight("LDN", 50, "2022-09-09", "10:00:00");
        flightService.addNewFlight(flight);

        Passenger passenger = new Passenger("Israt", "israt.jahan237@gmail.com");
        passengerService.addNewPassenger(passenger);

    }
}
