package ma.ac.emi.ginfo.hg.emiflights.services;

import ma.ac.emi.ginfo.hg.emiflights.entities.Plane;
import ma.ac.emi.ginfo.hg.emiflights.exception.PlaneNotFoundException;
import ma.ac.emi.ginfo.hg.emiflights.repositories.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService {
    private final PlaneRepository planeRepository;

    @Autowired
    public PlaneService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    public Plane addPlane(Plane plane) {
        return planeRepository.save(plane);
    }

    public List<Plane> findAllPlanes() {
        return planeRepository.findAll();
    }

    public Plane updatePlane(Plane plane) {
        return planeRepository.save(plane);
    }

    public Plane findPlaneById(Long id) {
        return planeRepository.findPlaneById(id)
                .orElseThrow(() -> new PlaneNotFoundException("Plane by id " + id + "was not found"));
    }

    public void deletePlane(Long id) {
        planeRepository.deletePlaneById(id);
    }
}
