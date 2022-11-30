package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds.SeatPK;
import ma.ac.emi.ginfo.hg.emiflights.entities.enumerations.SeatClass;

import java.io.Serializable;
@Entity
@NoArgsConstructor
@IdClass(SeatPK.class)
public class Seat implements Serializable {
    @Id
    private Long id;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Plane plane;
    @Nonnull
    private SeatClass classe;

    @OneToOne(mappedBy = "seat")
    private Reservation reservation;
}
