package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds.FlightGenericPK;
import ma.ac.emi.ginfo.hg.emiflights.entities.enumerations.Day;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor
@IdClass(FlightGenericPK.class)
public class FlightGeneric implements Serializable {
    @Id
    @ManyToOne
    private Plane plane;
    @Id
    @ManyToOne
    private Airport departureAirport;

    @Column(length = 100)
    private Day day;
    @Nonnull
    private LocalTime departureHour;
    @Nonnull
    private LocalTime arrivalHour;
    @Nonnull
    @ManyToOne
    private Airport arrivalAirport;
    @Nonnull
    private LocalTime duration;

    @OneToMany(mappedBy = "flightGeneric", cascade = CascadeType.ALL)
    private List<Flight> flights;

    @Transient
    private Map<String, Double> prices = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, Double>("Economy", 0d),
            new AbstractMap.SimpleEntry<String, Double>("Business", 0d),
            new AbstractMap.SimpleEntry<String, Double>("Premium", 0d),
            new AbstractMap.SimpleEntry<String, Double>("FirstClass", 0d)
    );
}