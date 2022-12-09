package ma.ac.emi.ginfo.hg.emiflights.restcontrollers;

import jakarta.websocket.server.PathParam;
import ma.ac.emi.ginfo.hg.emiflights.entities.Plane;
import ma.ac.emi.ginfo.hg.emiflights.services.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<Plane> addPlane(@RequestBody Plane plane,
                                          int firstClassSeats,
                                          int businessClassSeats,
                                          int economyClassSeats) {
        Plane newPlane = planeService.addPlane(plane, firstClassSeats, businessClassSeats, economyClassSeats);
        return new ResponseEntity<>(newPlane, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Plane> getPlaneById(@PathVariable("id") UUID id) {
        Plane plane = planeService.findPlaneById(id);
        return new ResponseEntity<>(plane, HttpStatus.OK);
    }

    @GetMapping("/find/{model}")
    public ResponseEntity<Plane> getPlaneById(@PathVariable("model") String model) {
        Plane plane = planeService.findPlaneByModel(model);
        return new ResponseEntity<>(plane, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Plane> updatePlane(@RequestBody Plane plane) {
        Plane updatePlane = planeService.updatePlane(plane);
        return new ResponseEntity<>(updatePlane, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePlane(@PathVariable("id") UUID id) {
        planeService.deletePlane(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
