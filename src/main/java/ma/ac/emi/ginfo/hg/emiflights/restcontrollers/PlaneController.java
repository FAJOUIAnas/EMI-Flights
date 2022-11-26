package ma.ac.emi.ginfo.hg.emiflights.restcontrollers;

import ma.ac.emi.ginfo.hg.emiflights.entities.Plane;
import ma.ac.emi.ginfo.hg.emiflights.services.PlaneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/plane")
public class PlaneController {
    private final PlaneService planeService;

    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Plane>> getAllPlanes() {
        List<Plane> planes = planeService.findAllPlanes();
        return new ResponseEntity<>(planes, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Plane> addPlane(@RequestBody Plane plane) {
        Plane newPlane = planeService.addPlane(plane);
        return new ResponseEntity<>(newPlane, HttpStatus.CREATED);
    }
}
