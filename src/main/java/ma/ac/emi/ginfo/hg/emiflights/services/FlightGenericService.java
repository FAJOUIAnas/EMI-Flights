package ma.ac.emi.ginfo.hg.emiflights.services;

import ma.ac.emi.ginfo.hg.emiflights.entities.*;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.Day;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.FlightStatus;
import ma.ac.emi.ginfo.hg.emiflights.exception.*;
import ma.ac.emi.ginfo.hg.emiflights.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Service
public class FlightGenericService {
    private final FlightGenericRepository flightGenericRepository;
    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;
    private final DayRepository dayRepository;
    private final PlaneRepository planeRepository;
    private final TerminalRepository terminalRepository;
    private final FlightStatusRepository flightStatusRepository;

    @Autowired
    public FlightGenericService(FlightGenericRepository flightGenericRepository, FlightRepository flightRepository, AirportRepository airportRepository, DayRepository dayRepository, PlaneRepository planeRepository, TerminalRepository terminalRepository, FlightStatusRepository flightStatusRepository) {
        this.flightGenericRepository = flightGenericRepository;
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
        this.dayRepository = dayRepository;
        this.planeRepository = planeRepository;
        this.terminalRepository = terminalRepository;
        this.flightStatusRepository = flightStatusRepository;
    }

    public FlightGeneric addFlightGeneric(FlightGeneric flightGeneric) {
        Airport departureAirport = airportRepository.findAirportByCode(flightGeneric.getDepartureAirport().getCode())
                .orElseThrow(() -> new AirportNotFoundException("Airport by code " + flightGeneric.getDepartureAirport().getCode() + " was not found"));
        flightGeneric.setDepartureAirport(departureAirport);

        Airport arrivalAirport = airportRepository.findAirportByCode(flightGeneric.getArrivalAirport().getCode())
                .orElseThrow(() -> new AirportNotFoundException("Airport by code " + flightGeneric.getArrivalAirport().getCode() + " was not found"));
        flightGeneric.setArrivalAirport(arrivalAirport);

        Day day = dayRepository.findDayByCode(flightGeneric.getDay().getCode())
                .orElseThrow(() -> new DayNotFoundException("Day by code " + flightGeneric.getDay().getCode() + " was not found"));
        flightGeneric.setDay(day);

        Plane plane = planeRepository.findPlaneById(flightGeneric.getPlane().getId())
                .orElseThrow(() -> new PlaneNotFoundException("Plane by id " + flightGeneric.getPlane().getId() + " was not found"));
        flightGeneric.setPlane(plane);

        Terminal departureTerminal = terminalRepository.findTerminalByCode(flightGeneric.getDepartureTerminal().getCode())
                .orElseThrow(() -> new TerminalNotFoundException("Terminal by code " + flightGeneric.getDepartureTerminal().getCode() + " was not found"));
        flightGeneric.setDepartureTerminal(departureTerminal);

        Terminal arrivalTerminal = terminalRepository.findTerminalByCode(flightGeneric.getArrivalTerminal().getCode())
                .orElseThrow(() -> new TerminalNotFoundException("Terminal by code " + flightGeneric.getArrivalTerminal().getCode() + " was not found"));
        flightGeneric.setArrivalTerminal(arrivalTerminal);

        FlightGeneric flightGenericSaved = flightGenericRepository.save(flightGeneric);

        long currentDate = System.currentTimeMillis();
        FlightStatus scheduled = flightStatusRepository.findFlightStatusByCode("SCHD")
                .orElseThrow(() -> new FlightStatusNotFoundException("FlightStatus by code SCHD was not found"));

        for(int d = 2; d <= 31; d += 7) {
            Flight flight = new Flight();
            flight.setFlightGeneric(flightGenericSaved);
            java.sql.Date date = new java.sql.Date(currentDate);
            date.setYear(123);
            date.setMonth(Calendar.JANUARY);
            date.setDate(d);
            flight.setDepartureDate(date);
            flight.setFlightStatus(scheduled);
            flightRepository.save(flight);
        }
        return flightGenericSaved;
    }

    public List<FlightGeneric> findAllFlightGenerics() {
        return flightGenericRepository.findAll();
    }

    public FlightGeneric updateFlightGeneric(FlightGeneric flightGeneric) {
        flightGenericRepository.findFlightGenericById(flightGeneric.getId())
                .orElseThrow(() -> new FlightGenericNotFoundException("FlightGeneric by id " + flightGeneric.getId() + " was not found"));

        Airport departureAirport = airportRepository.findAirportByCode(flightGeneric.getDepartureAirport().getCode())
                .orElseThrow(() -> new AirportNotFoundException("Airport by code " + flightGeneric.getDepartureAirport().getCode() + " was not found"));
        flightGeneric.setDepartureAirport(departureAirport);

        Airport arrivalAirport = airportRepository.findAirportByCode(flightGeneric.getArrivalAirport().getCode())
                .orElseThrow(() -> new AirportNotFoundException("Airport by code " + flightGeneric.getArrivalAirport().getCode() + " was not found"));
        flightGeneric.setArrivalAirport(arrivalAirport);

        Day day = dayRepository.findDayByCode(flightGeneric.getDay().getCode())
                .orElseThrow(() -> new DayNotFoundException("Day by code " + flightGeneric.getDay().getCode() + " was not found"));
        flightGeneric.setDay(day);

        Plane plane = planeRepository.findPlaneById(flightGeneric.getPlane().getId())
                .orElseThrow(() -> new PlaneNotFoundException("Plane by id " + flightGeneric.getPlane().getId() + " was not found"));
        flightGeneric.setPlane(plane);

        Terminal departureTerminal = terminalRepository.findTerminalByCode(flightGeneric.getDepartureTerminal().getCode())
                .orElseThrow(() -> new TerminalNotFoundException("Terminal by code " + flightGeneric.getDepartureTerminal().getCode() + " was not found"));
        flightGeneric.setDepartureTerminal(departureTerminal);

        Terminal arrivalTerminal = terminalRepository.findTerminalByCode(flightGeneric.getArrivalTerminal().getCode())
                .orElseThrow(() -> new TerminalNotFoundException("Terminal by code " + flightGeneric.getArrivalTerminal().getCode() + " was not found"));
        flightGeneric.setArrivalTerminal(arrivalTerminal);

        return flightGenericRepository.save(flightGeneric);
    }

    public FlightGeneric findFlightGenericById(UUID id) {
        return flightGenericRepository.findFlightGenericById(id)
                .orElseThrow(() -> new FlightGenericNotFoundException("FlightGeneric by id " + id + " was not found"));
    }

    public void deleteFlightGeneric(UUID id) {
        List<Flight> flights = flightRepository.findAllByFlightGeneric_IdAndDepartureDateIsAfter(id, Date.valueOf(LocalDate.now()));
        for(Flight flight : flights) {
            flightRepository.deleteFlightById(flight.getId());
        }
        flightGenericRepository.deleteFlightGenericById(id);
    }
}