package ma.ac.emi.ginfo.hg.emiflights.repositories;

import jakarta.transaction.Transactional;
import ma.ac.emi.ginfo.hg.emiflights.entities.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlaneRepository extends JpaRepository<Plane, UUID> {
    Optional<Plane> findPlaneById(UUID id);
    List<Plane> findPlanesByModel(String model);
    List<Plane> findPlanesByCompanyName(String CompanyName);
    @Transactional
    void deletePlaneById(UUID id);
}