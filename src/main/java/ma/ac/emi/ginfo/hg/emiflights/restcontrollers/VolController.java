package ma.ac.emi.ginfo.hg.emiflights.restcontrollers;

import ma.ac.emi.ginfo.hg.emiflights.entities.Flight;
import ma.ac.emi.ginfo.hg.emiflights.services.VolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/vol")
public class VolController {
    private final VolService volService;

    public VolController(VolService volService) {
        this.volService = volService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Flight>> getAllVols() {
        List<Flight> flights = volService.findAllVols();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Flight> addVol(@RequestBody Flight flight) {
        Flight newFlight = volService.addVol(flight);
        return new ResponseEntity<>(newFlight, HttpStatus.CREATED);
    }
}
