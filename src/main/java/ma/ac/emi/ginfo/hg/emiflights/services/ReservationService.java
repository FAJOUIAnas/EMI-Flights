package ma.ac.emi.ginfo.hg.emiflights.services;

import ma.ac.emi.ginfo.hg.emiflights.entities.Flight;
import ma.ac.emi.ginfo.hg.emiflights.entities.Reservation;
import ma.ac.emi.ginfo.hg.emiflights.exception.FlightNotFoundException;
import ma.ac.emi.ginfo.hg.emiflights.exception.ReservationNotFoundException;
import ma.ac.emi.ginfo.hg.emiflights.repositories.FlightRepository;
import ma.ac.emi.ginfo.hg.emiflights.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final FlightRepository flightRepository;


    @Autowired
    public ReservationService(ReservationRepository reservationRepository, FlightRepository flightRepository){
        this.reservationRepository = reservationRepository;
        this.flightRepository = flightRepository;
    }

    public void deleteReservation(UUID id) {
        reservationRepository.deleteReservationById(id);
    }

    public Reservation modifyReservationSeat(String seatNumber, Reservation reservation){
        reservation.setSeatNumber(seatNumber);
        reservationRepository.save(reservation);
        return reservation;
    }

    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation findReservationById(UUID id){
        return reservationRepository.findReservationById(id)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation by id " + id + "was not found"));
    }

    public Reservation findReservationByCode(String code){
        return reservationRepository.findReservationByCode(code)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation by code " + code + "was not found"));
    }

    public Reservation findReservationByCreationDate(LocalDate creationDate){
        return reservationRepository.findReservationByCreationDate(creationDate)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation by creationDate " + creationDate + "was not found"));
    }

    public Reservation findReservationByModificationDate(LocalDate modificationDate){
        return reservationRepository.findReservationByModificationDate(modificationDate)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation by modificationDate " + modificationDate + "was not found"));
    }

    public Reservation findReservationByFlight_id(UUID flight_id){
        Flight flight = flightRepository.findFlightById(flight_id)
                .orElseThrow(() -> new FlightNotFoundException("Flight by id " + flight_id + "was not found"));
        return reservationRepository.findReservationByFlight(flight)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation by flight " + flight + "was not found"));
    }

    public Reservation findReservationByPassengerFirstName(String firstName){
        return reservationRepository.findReservationByPassengerFirstName(firstName)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation by firstName " + firstName + "was not found"));
    }

    public Reservation findReservationByPassengerLastName(String lastName){
        return reservationRepository.findReservationByPassengerLastName(lastName)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation by lastName " + lastName + "was not found"));
    }
}
