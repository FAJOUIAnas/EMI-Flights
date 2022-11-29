package ma.ac.emi.ginfo.hg.emiflights.repositories;

import ma.ac.emi.ginfo.hg.emiflights.entities.FlightGeneric;
import ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds.FlightGenericPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolGRepository extends JpaRepository<FlightGeneric, FlightGenericPK> {
}