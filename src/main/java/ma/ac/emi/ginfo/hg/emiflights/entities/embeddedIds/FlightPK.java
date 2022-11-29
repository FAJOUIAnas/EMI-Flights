package ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds;

import ma.ac.emi.ginfo.hg.emiflights.entities.FlightGeneric;

import java.io.Serializable;
import java.time.LocalDate;

public class FlightPK implements Serializable {
    private FlightGeneric flightGeneric;
    private LocalDate departureDate;
}
