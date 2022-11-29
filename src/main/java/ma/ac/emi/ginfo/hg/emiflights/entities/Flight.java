package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds.FlightPK;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@IdClass(FlightPK.class)
public class Flight implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumns({ @JoinColumn(name = "plane_id"),
                    @JoinColumn(name = "departureAirport_code") })
    private FlightGeneric flightGeneric;
    @Id
    private LocalDate departureDate;
    private LocalDate arrivalDate;


    public Flight(LocalDate departureDate, LocalDate arrivalDate) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

}
