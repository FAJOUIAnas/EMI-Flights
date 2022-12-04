package ma.ac.emi.ginfo.hg.emiflights;

import ma.ac.emi.ginfo.hg.emiflights.entities.Plane;
import ma.ac.emi.ginfo.hg.emiflights.entities.Seat;
import ma.ac.emi.ginfo.hg.emiflights.repositories.PlaneRepository;
import ma.ac.emi.ginfo.hg.emiflights.repositories.SeatRepository;
import ma.ac.emi.ginfo.hg.emiflights.services.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.management.MXBean;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EmiFlightsApplication {
    @Autowired
    PlaneRepository planeRepository;
    @Autowired
    SeatRepository seatRepository;

    //PlaneService planeService = new PlaneService(planeRepository, seatRepository);

    public static void main(String[] args) {
        SpringApplication.run(EmiFlightsApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            /*planeService.addPlane(new Plane(), 1, 2, 3,4, planeRepository, seatRepository);
            Plane plane =new Plane();
            List<Seat> seats = new ArrayList<>();

            plane.setSeats(seats);
            planeService.updatePlane(plane);*/


            /*Seat seat = new Seat();
            seatRepository.save(seat);*/
        };
    }
}
