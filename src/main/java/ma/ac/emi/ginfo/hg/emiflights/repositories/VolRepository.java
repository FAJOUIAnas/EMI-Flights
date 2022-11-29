package ma.ac.emi.ginfo.hg.emiflights.repositories;

import ma.ac.emi.ginfo.hg.emiflights.entities.Vol;
import ma.ac.emi.ginfo.hg.emiflights.entities.VolGeneric;
import ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds.VolPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolRepository extends JpaRepository<Vol, VolPk> {
}