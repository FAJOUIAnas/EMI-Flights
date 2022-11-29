package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds.SeatPK;

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

    @OneToOne(mappedBy = "seat")
    private Reservation reservation;
}
