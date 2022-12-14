package ma.ac.emi.ginfo.hg.emiflights.repositories;

import jakarta.transaction.Transactional;
import ma.ac.emi.ginfo.hg.emiflights.entities.Seats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SeatsRepository extends JpaRepository<Seats, UUID> {
    Optional<Seats> findSeatsById(UUID id);
    @Transactional
    void deleteSeatsById(UUID id);
    List<Seats> findSeatsByPlane_Id(UUID id);

    List<Seats> findSeatsBy_class_Code(String code);
}
