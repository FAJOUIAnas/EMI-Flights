package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.AgeGroup;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.Civility;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.Class;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.ReservationStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Nonnull
    private String code;

    @Nonnull
    private LocalDate creationDate;

    @Nonnull
    private LocalDate modificationDate;

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
    private Class _class;

    @Nonnull
    private String seatNumber;

    @Nonnull
    @ManyToOne
    private ReservationStatus reservationStatus;

    @Nonnull
    private double price;

    @ManyToOne
    private Flight flight;

}
