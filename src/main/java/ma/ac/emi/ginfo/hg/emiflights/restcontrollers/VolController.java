package ma.ac.emi.ginfo.hg.emiflights.restcontrollers;

import ma.ac.emi.ginfo.hg.emiflights.entities.Seat;
import ma.ac.emi.ginfo.hg.emiflights.entities.Vol;
import ma.ac.emi.ginfo.hg.emiflights.services.SeatService;
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
    public ResponseEntity<List<Vol>> getAllVols() {
        List<Vol> vols = volService.findAllVols();
        return new ResponseEntity<>(vols, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Vol> addVol(@RequestBody Vol vol) {
        Vol newVol = volService.addVol(vol);
        return new ResponseEntity<>(newVol, HttpStatus.CREATED);
    }
}
