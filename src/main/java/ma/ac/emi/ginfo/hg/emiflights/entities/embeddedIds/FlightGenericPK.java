package ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds;

import jakarta.persistence.*;
import ma.ac.emi.ginfo.hg.emiflights.entities.Plane;

import java.io.Serializable;

public class FlightGenericPK implements Serializable {

    @ManyToOne
    @MapsId
    @JoinColumn(name = "plane_id")
    private Plane plane;
    @Column(length = 100)
    private String day;
}
