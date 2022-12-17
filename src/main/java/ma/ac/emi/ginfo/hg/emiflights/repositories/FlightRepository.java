package ma.ac.emi.ginfo.hg.emiflights.repositories;

import ma.ac.emi.ginfo.hg.emiflights.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FlightRepository extends JpaRepository<Flight, UUID> {

    Optional<Flight> findFlightById(UUID uuid);
}