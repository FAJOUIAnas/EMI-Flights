package ma.ac.emi.ginfo.hg.emiflights.repositories;

import jakarta.transaction.Transactional;
import ma.ac.emi.ginfo.hg.emiflights.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FlightRepository extends JpaRepository<Flight, UUID> {
    Optional<Flight> findFlightById(UUID id);
    @Transactional
    void deleteFlightById(UUID id);
    List<Flight> findAllByFlightGeneric_IdAndDepartureDateIsAfter(UUID flightGenericId);

}