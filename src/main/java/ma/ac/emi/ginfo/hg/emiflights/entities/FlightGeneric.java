package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds.FlightGenericPK;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Entity
@NoArgsConstructor
@IdClass(FlightGenericPK.class)
public class FlightGeneric implements Serializable {
    @Id
    @ManyToOne
    private Plane plane;
    @Id
    @Column(length = 100)
    private String day;

    @Nonnull
    private LocalTime departureHour;
    @Nonnull
    private LocalTime arrivalTime;
    @Nonnull
    private LocalTime duration;

    @OneToMany(mappedBy = "flightGeneric", cascade = CascadeType.ALL)
    private List<Flight> flights;
}