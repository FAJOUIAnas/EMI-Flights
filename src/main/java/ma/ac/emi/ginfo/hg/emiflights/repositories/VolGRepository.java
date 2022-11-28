package ma.ac.emi.ginfo.hg.emiflights.repositories;

import ma.ac.emi.ginfo.hg.emiflights.entities.VolGeneric;
import ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds.VolGenericPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolGRepository extends JpaRepository<VolGeneric, VolGenericPK> {
}