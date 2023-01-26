package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.AgeGroup;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.Civility;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.Class;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.ReservationStatus;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Nonnull
    private String code;


    @Temporal(TemporalType.DATE)
    @Nonnull
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @Nonnull
    private Date modificationDate;

    @Nonnull
    private String passengerLastName;

    @Nonnull
    private String passengerFirstName;

    @Nonnull
    @ManyToOne
    private Civility passengerCivility;

    @Nonnull
    @ManyToOne
    private AgeGroup passengerAgeGroup;

    @Nonnull
    @ManyToOne
    private Class seatClass;

    @Nonnull
    private String seatNumber;

    @Nonnull
    @ManyToOne
    private ReservationStatus reservationStatus;

    @Nonnull
    private double price;

    @ManyToOne
    private Flight flight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Reservation that = (Reservation) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
