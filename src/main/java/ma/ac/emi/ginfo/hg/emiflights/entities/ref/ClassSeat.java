package ma.ac.emi.ginfo.hg.emiflights.entities.ref;

import jakarta.persistence.*;
import lombok.*;
import ma.ac.emi.ginfo.hg.emiflights.entities.Plane;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClassSeat classSeat = (ClassSeat) o;
        return id != null && Objects.equals(id, classSeat.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
