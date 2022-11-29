package ma.ac.emi.ginfo.hg.emiflights.restcontrollers;

import ma.ac.emi.ginfo.hg.emiflights.entities.Vol;
import ma.ac.emi.ginfo.hg.emiflights.entities.VolGeneric;
import ma.ac.emi.ginfo.hg.emiflights.services.VolGenericService;
import ma.ac.emi.ginfo.hg.emiflights.services.VolService;
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
    public ResponseEntity<List<VolGeneric>> getAllVolGenerics() {
        List<VolGeneric> volGenerics = volGenericService.findAllVolGenerics();
        return new ResponseEntity<>(volGenerics, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<VolGeneric> addVolGeneric(@RequestBody VolGeneric volGeneric) {
        VolGeneric newVolGeneric = volGenericService.addVolGeneric(volGeneric);
        return new ResponseEntity<>(newVolGeneric, HttpStatus.CREATED);
    }
}
