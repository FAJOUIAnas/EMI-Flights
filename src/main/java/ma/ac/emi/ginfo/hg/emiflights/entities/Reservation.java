package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Reservation implements Serializable {
    @Id
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns({ @JoinColumn(name = "seat_id"), @JoinColumn(name = "plane_id") })
    private Seat seat;

    @Nonnull
    private LocalDate date;

    @Nonnull
    @ManyToOne
    private Flight flight;


}
