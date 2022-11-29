package ma.ac.emi.ginfo.hg.emiflights.restcontrollers;

import ma.ac.emi.ginfo.hg.emiflights.entities.FlightGeneric;
import ma.ac.emi.ginfo.hg.emiflights.services.VolGenericService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/volgeneric")
public class VolGenericController {
    private final VolGenericService volGenericService;

    public VolGenericController(VolGenericService volGenericService) {
        this.volGenericService = volGenericService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<FlightGeneric>> getAllVolGenerics() {
        List<FlightGeneric> flightGenerics = volGenericService.findAllVolGenerics();
        return new ResponseEntity<>(flightGenerics, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<FlightGeneric> addVolGeneric(@RequestBody FlightGeneric flightGeneric) {
        FlightGeneric newFlightGeneric = volGenericService.addVolGeneric(flightGeneric);
        return new ResponseEntity<>(newFlightGeneric, HttpStatus.CREATED);
    }
}
