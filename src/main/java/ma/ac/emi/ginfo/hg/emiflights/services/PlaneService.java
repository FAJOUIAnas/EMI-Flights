package ma.ac.emi.ginfo.hg.emiflights.services;

import ma.ac.emi.ginfo.hg.emiflights.entities.Plane;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.Class;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.ClassSeat;
import ma.ac.emi.ginfo.hg.emiflights.exception.ClassNotFoundException;
import ma.ac.emi.ginfo.hg.emiflights.exception.PlaneNotFoundException;
import ma.ac.emi.ginfo.hg.emiflights.repositories.ClassRepository;
import ma.ac.emi.ginfo.hg.emiflights.repositories.ClassSeatRepository;
import ma.ac.emi.ginfo.hg.emiflights.repositories.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PlaneService {
    private final PlaneRepository planeRepository;
    private final ClassSeatRepository classSeatRepository;

    private final ClassRepository classRepository;

    @Autowired
    public PlaneService(PlaneRepository planeRepository, ClassSeatRepository classSeatRepository, ClassRepository classRepository) {
        this.planeRepository = planeRepository;
        this.classSeatRepository = classSeatRepository;
        this.classRepository = classRepository;
    }

    public Plane addPlane(Plane plane,
                          int firstClassSeats,
                          int businessClassSeats,
                          int economyClassSeats) {
        Class Fclass = classRepository.findClassByCode("FST")
                .orElseThrow(() -> new ClassNotFoundException("Class by code " + "FST" + "was not found"));

        ClassSeat firstClassNb = new ClassSeat(Fclass, firstClassSeats, plane);
        classSeatRepository.save(firstClassNb);

        return planeRepository.save(plane);
    }

    public List<Plane> findAllPlanes() {
        return planeRepository.findAll();
    }

    public Plane updatePlane(Plane plane) {
        return planeRepository.save(plane);
    }

    public Plane findPlaneById(UUID id) {
        return planeRepository.findPlaneById(id)
                .orElseThrow(() -> new PlaneNotFoundException("Plane by id " + id + "was not found"));
    }

    public Plane findPlaneByModel(String model) {
        return planeRepository.findPlaneByModel(model);
    }

    public void deletePlane(UUID id) {
        planeRepository.deletePlaneById(id);
    }
}
