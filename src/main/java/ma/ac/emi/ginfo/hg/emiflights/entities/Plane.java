package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Plane implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    private String model;
    @Nonnull
    private int nbSeats;

    @OneToMany(mappedBy = "plane")
    private List<Seat> seats;

    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL)
    private List<VolGeneric> volsGeneric;
}
