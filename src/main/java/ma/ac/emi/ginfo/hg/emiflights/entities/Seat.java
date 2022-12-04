package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds.SeatPK;
import ma.ac.emi.ginfo.hg.emiflights.entities.enumerations.SeatClass;

import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
//@IdClass(SeatPK.class)
public class Seat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@Id
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="plane_id", nullable=false)
    private Plane plane;
*/
    private SeatClass classe;

    /*@OneToOne(mappedBy = "seat")
    private Reservation reservation = null;*/

    public Seat(SeatClass classe) {
        this.classe = classe;
    }
}
