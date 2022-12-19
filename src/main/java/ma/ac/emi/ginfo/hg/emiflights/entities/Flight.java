package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.FlightStatus;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Flight flight = (Flight) o;
        return id != null && Objects.equals(id, flight.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
