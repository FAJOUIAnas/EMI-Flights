package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds.PlacePK;

import java.io.Serializable;
@Entity
@NoArgsConstructor
@IdClass(PlacePK.class)
public class Place implements Serializable {
    @Id
    private int numero;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "idPlane", nullable = false)
    private Plane plane;

    @OneToOne(mappedBy = "place")
    private Reservation reservation;
}
