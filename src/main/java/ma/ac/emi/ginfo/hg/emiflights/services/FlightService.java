package ma.ac.emi.ginfo.hg.emiflights.services;

import ma.ac.emi.ginfo.hg.emiflights.entities.Flight;
import ma.ac.emi.ginfo.hg.emiflights.entities.FlightGeneric;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.FlightStatus;
import ma.ac.emi.ginfo.hg.emiflights.exception.FlightGenericNotFoundException;
import ma.ac.emi.ginfo.hg.emiflights.exception.FlightNotFoundException;
import ma.ac.emi.ginfo.hg.emiflights.exception.FlightStatusNotFoundException;
import ma.ac.emi.ginfo.hg.emiflights.repositories.FlightGenericRepository;
import ma.ac.emi.ginfo.hg.emiflights.repositories.FlightRepository;
import ma.ac.emi.ginfo.hg.emiflights.repositories.FlightStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private final FlightGenericRepository flightGenericRepository;
    private final FlightStatusRepository flightStatusRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository, FlightGenericRepository flightGenericRepository, FlightStatusRepository flightStatusRepository) {
        this.flightRepository = flightRepository;
        this.flightGenericRepository = flightGenericRepository;
        this.flightStatusRepository = flightStatusRepository;
    }

    public Flight addFlight(Flight flight) {
        FlightGeneric flightGeneric = flightGenericRepository.findFlightGenericById(flight.getFlightGeneric().getId())
                .orElseThrow(() -> new FlightGenericNotFoundException("FlightGeneric by id " + flight.getFlightGeneric().getId() + " was not found"));
        flight.setFlightGeneric(flightGeneric);

        FlightStatus flightStatus = flightStatusRepository.findFlightStatusByCode(flight.getFlightStatus().getCode())
                .orElseThrow(() -> new FlightStatusNotFoundException("FlightStatus by code " + flight.getFlightStatus().getCode() + " was not found"));
        flight.setFlightStatus(flightStatus);

        return flightRepository.save(flight);
    }

    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    public Flight updateFlight(Flight flight) {
        flightRepository.findFlightById(flight.getId())
                .orElseThrow(() -> new FlightNotFoundException("Flight by id " + flight.getId() + " was not found"));

        FlightGeneric flightGeneric = flightGenericRepository.findFlightGenericById(flight.getFlightGeneric().getId())
                .orElseThrow(() -> new FlightGenericNotFoundException("FlightGeneric by id " + flight.getFlightGeneric().getId() + " was not found"));
        flight.setFlightGeneric(flightGeneric);

        FlightStatus flightStatus = flightStatusRepository.findFlightStatusByCode(flight.getFlightStatus().getCode())
                .orElseThrow(() -> new FlightStatusNotFoundException("FlightStatus by code " + flight.getFlightStatus().getCode() + " was not found"));
        flight.setFlightStatus(flightStatus);

        return flightRepository.save(flight);
    }

    public Flight findFlightById(UUID id) {
        return flightRepository.findFlightById(id)
                .orElseThrow(() -> new FlightNotFoundException("Flight by id " + id + " was not found"));
    }

    public void deleteFlight(UUID id) {
        flightRepository.deleteFlightById(id);
    }

    public List<Flight> searchFlights(String depAirport, String arrAirport, Date depDate) {
        return flightRepository.findByFlightGeneric_DepartureAirport_CodeAndFlightGeneric_ArrivalAirport_CodeAndDepartureDate(depAirport, arrAirport, depDate);
    }
}