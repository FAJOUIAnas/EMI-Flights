package ma.ac.emi.ginfo.hg.emiflights.repositories;

import ma.ac.emi.ginfo.hg.emiflights.entities.Flight;
import ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds.FlightPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolRepository extends JpaRepository<Flight, FlightPK> {
}