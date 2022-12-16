package ma.ac.emi.ginfo.hg.emiflights.repositories;

import jakarta.transaction.Transactional;
import ma.ac.emi.ginfo.hg.emiflights.entities.Airport;
import ma.ac.emi.ginfo.hg.emiflights.entities.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AirportRepository extends JpaRepository<Airport, String> {
    Optional<Airport> findAirportByCode(String code);
    List<Airport> findAirportsByCity(String city);
    @Transactional
    void deleteAirportByCode(String code);
}
