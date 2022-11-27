package ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds;

import jakarta.persistence.Id;
import ma.ac.emi.ginfo.hg.emiflights.entities.VolGeneric;

import java.io.Serializable;
import java.time.LocalDate;

public class VolPk implements Serializable {
    private VolGeneric volGeneric;
    private LocalDate departureDate;
}
