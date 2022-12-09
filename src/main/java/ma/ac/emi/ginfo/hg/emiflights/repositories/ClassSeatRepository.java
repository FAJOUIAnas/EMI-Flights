package ma.ac.emi.ginfo.hg.emiflights.repositories;

import ma.ac.emi.ginfo.hg.emiflights.entities.ref.ClassSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClassSeatRepository extends JpaRepository<ClassSeat, UUID> {
}
