package ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds;

import jakarta.persistence.Column;
import ma.ac.emi.ginfo.hg.emiflights.entities.Plane;

import java.io.Serializable;

public class VolGenericPK implements Serializable {

    private Plane plane;
    @Column(length = 100)
    private String day;
}
