package ma.ac.emi.ginfo.hg.emiflights.restcontrollers;

import ma.ac.emi.ginfo.hg.emiflights.authentication.config.JwtUtils;
import ma.ac.emi.ginfo.hg.emiflights.entities.Reservation;
import ma.ac.emi.ginfo.hg.emiflights.services.ReservationService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final JwtUtils jwtUtils;
    private final ReservationService reservationService;

    public ReservationController(JwtUtils jwtUtils, ReservationService reservationService) {
        this.jwtUtils = jwtUtils;
        this.reservationService = reservationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> Reservations = reservationService.findAllReservations();
        return new ResponseEntity<>(Reservations, HttpStatus.OK);
    }

    /*@GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservations(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {
        String token = bearerToken.substring(7);
        String username = jwtUtils.extractUsername(token);
        List<Reservation> Reservations = reservationService.findAllReservations();
        return new ResponseEntity<>(Reservations, HttpStatus.OK);
    }*/

    @GetMapping("/find/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") UUID id) {
        Reservation Reservation = reservationService.findReservationById(id);
        return new ResponseEntity<>(Reservation, HttpStatus.OK);
    }

    @GetMapping("/find/{Code}")
    public ResponseEntity<Reservation> getReservationByCode(@PathVariable("Code") String Code) {
        Reservation Reservation = reservationService.findReservationByCode(Code);
        return new ResponseEntity<>(Reservation, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        Reservation newReservation = reservationService.addReservation(reservation);
        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }

    @PostMapping("/modify")
    public ResponseEntity<Reservation> modifyReservation(@RequestBody Reservation reservation,
                                                         @RequestParam("seat_number") String seatNumber) {
        Reservation newReservation = reservationService.modifyReservationSeat(seatNumber,reservation);
        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable("id") UUID id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
