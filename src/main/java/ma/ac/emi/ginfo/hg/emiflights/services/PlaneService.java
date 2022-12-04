package ma.ac.emi.ginfo.hg.emiflights.services;

import ma.ac.emi.ginfo.hg.emiflights.entities.Plane;
import ma.ac.emi.ginfo.hg.emiflights.entities.Seat;
import ma.ac.emi.ginfo.hg.emiflights.entities.enumerations.SeatClass;
import ma.ac.emi.ginfo.hg.emiflights.exception.PlaneNotFoundException;
import ma.ac.emi.ginfo.hg.emiflights.repositories.PlaneRepository;
import ma.ac.emi.ginfo.hg.emiflights.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PlaneService {
    private final PlaneRepository planeRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public PlaneService(PlaneRepository planeRepository, SeatRepository seatRepository) {
        this.planeRepository = planeRepository;
        this.seatRepository = seatRepository;
    }

    public Plane addPlane(Plane plane,
                          int nbSeatsFirstClass,
                          int nbSeatsBusiness,
                          int nbSeatsPremium,
                          int nbSeatsEconomy) {
        List<Seat> seats = new ArrayList<>();
        for(int i = 1; i <= nbSeatsFirstClass; i++) {
            Seat seat = new Seat(SeatClass.FIRSTCLASS);
            seats.add(seat);
        }
        for(int i = nbSeatsFirstClass + 1; i <= nbSeatsFirstClass + nbSeatsBusiness; i++) {
            Seat seat = new Seat(SeatClass.BUSINESS);
            seats.add(seat);
        }
        for(int i = nbSeatsFirstClass + nbSeatsBusiness + 1; i <= nbSeatsFirstClass + nbSeatsBusiness + nbSeatsPremium; i++) {
            Seat seat = new Seat(SeatClass.PREMUIM);
            seats.add(seat);
        }
        for(int i = nbSeatsFirstClass + nbSeatsBusiness + nbSeatsPremium + 1; i <= nbSeatsFirstClass + nbSeatsBusiness + nbSeatsPremium + nbSeatsEconomy; i++) {
            Seat seat = new Seat(SeatClass.ECONOMY);
            seats.add(seat);
        }
        plane.setSeats(seats);
        Plane newPlane = planeRepository.save(plane);
        return newPlane;
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
        /*for(Seat seat : planeRepository.findPlaneById(id).get().getSeats()) {
            seatService.delete(seat);
        }*/
        planeRepository.deletePlaneById(id);
    }
}
