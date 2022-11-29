package ma.ac.emi.ginfo.hg.emiflights.restcontrollers;

import ma.ac.emi.ginfo.hg.emiflights.entities.Seat;
import ma.ac.emi.ginfo.hg.emiflights.services.SeatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/seat")
public class SeatController {
    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Seat>> getAllSeats() {
        List<Seat> seats = seatService.findAllSeats();
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Seat> addSeat(@RequestBody Seat seat) {
        Seat newSeat = seatService.addSeat(seat);
        return new ResponseEntity<>(newSeat, HttpStatus.CREATED);
    }
}
