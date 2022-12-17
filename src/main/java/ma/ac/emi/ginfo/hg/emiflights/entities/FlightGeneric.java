package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.Day;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FlightGeneric implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @Nonnull
    private Airport departureAirport;

    @OneToOne
    @Nonnull
    private Airport arrivalAirport;

    @Temporal(TemporalType.TIME)
    private Time departureHour;
    @Temporal(TemporalType.TIME)
    private Time arrivalHour;

    private BigDecimal basePrice;

    @ManyToOne
    private Day day;

    @ManyToOne
    private Plane plane;

    @OneToOne
    @Nonnull
    private Terminal departureTerminal;

    @OneToOne
    @Nonnull
    private Terminal arrivalTerminal;
}
