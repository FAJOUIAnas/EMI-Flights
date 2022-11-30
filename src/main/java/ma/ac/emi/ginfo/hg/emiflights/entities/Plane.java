package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Plane implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Nonnull
    private String model;

    @OneToMany(mappedBy = "plane")
    private List<Seat> seats;

    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL)
    private List<FlightGeneric> volsGeneric;

}
