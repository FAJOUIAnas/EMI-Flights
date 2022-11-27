package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@NoArgsConstructor
public class Reservation implements Serializable {
    @Id
    private Long id;

    @OneToOne
    private Place place;
}
