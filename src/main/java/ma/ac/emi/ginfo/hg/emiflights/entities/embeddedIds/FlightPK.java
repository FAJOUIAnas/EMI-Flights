package ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ma.ac.emi.ginfo.hg.emiflights.entities.FlightGeneric;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@EqualsAndHashCode
public class FlightPK implements Serializable {
    private FlightGeneric flightGeneric;
    private LocalDate departureDate;
}
