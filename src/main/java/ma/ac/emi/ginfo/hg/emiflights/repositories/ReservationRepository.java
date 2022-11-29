package ma.ac.emi.ginfo.hg.emiflights.repositories;

import ma.ac.emi.ginfo.hg.emiflights.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}