package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds.VolGenericPK;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Entity
@NoArgsConstructor
@IdClass(VolGenericPK.class)
public class VolGeneric implements Serializable {
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "idPlane", nullable = false)
    private Plane plane;
    @Id
    @Column(length = 100)
    private String day;
    @Nonnull
    private LocalTime departureHour;
    @Nonnull
    private LocalTime arrivalTime;
    @Nonnull
    private LocalTime duration;

    @OneToMany(mappedBy = "volGeneric")
    private List<Vol> vols;
}