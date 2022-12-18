package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.FlightStatus;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private FlightGeneric flightGeneric;

    @Temporal(TemporalType.DATE)
    private Date departureDate;

    private Boolean isFull;

    @ManyToOne
    private FlightStatus flightStatus;

}
