package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.Class;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Seats implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Plane plane;

    @ManyToOne
    private Class _class;

    private int numberOfSeats;

}
