package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.Class;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Seats implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Plane plane;

    @ManyToOne
    @Nonnull
    private Class _class;

    private int numberOfSeats;

}
