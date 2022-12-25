package ma.ac.emi.ginfo.hg.emiflights.repositories;

import jakarta.transaction.Transactional;
import ma.ac.emi.ginfo.hg.emiflights.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FlightRepository extends JpaRepository<Flight, UUID> {
    Optional<Flight> findFlightById(UUID id);

    @Transactional
    void deleteFlightById(UUID id);
    List<Flight> findAllByFlightGeneric_IdAndDepartureDateIsAfter(UUID flightGenericId, Date date);

    @Query("""
            select f from Flight f
            where f.flightGeneric.departureAirport.code = ?1 and f.flightGeneric.arrivalAirport.code = ?2 and f.departureDate = ?3""")
    List<Flight> findByFlightGeneric_DepartureAirport_CodeAndFlightGeneric_ArrivalAirport_CodeAndDepartureDate(String code, String code1, Date departureDate);


}