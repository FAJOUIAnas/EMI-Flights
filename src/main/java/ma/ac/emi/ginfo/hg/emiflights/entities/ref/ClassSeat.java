package ma.ac.emi.ginfo.hg.emiflights.entities.ref;

import jakarta.persistence.*;
import lombok.Data;
import ma.ac.emi.ginfo.hg.emiflights.entities.Plane;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
public class ClassSeat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Class _class;

    private int numberOfSeats;

    @OneToOne(cascade = CascadeType.ALL)
    private Plane plane;

    public ClassSeat(Class _class, int numberOfSeats, Plane plane) {
        this._class = _class;
        this.numberOfSeats = numberOfSeats;
        this.plane = plane;
    }
}
