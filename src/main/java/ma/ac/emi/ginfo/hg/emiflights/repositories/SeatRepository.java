package ma.ac.emi.ginfo.hg.emiflights.repositories;

import ma.ac.emi.ginfo.hg.emiflights.entities.Seat;
import ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds.SeatPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, SeatPK> {
}