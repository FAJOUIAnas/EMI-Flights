package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;
import ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds.VolPk;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@NoArgsConstructor
@IdClass(VolPk.class)
public class Vol implements Serializable {
    @Id
    @ManyToOne
    private VolGeneric volGeneric;
    @Id
    private LocalDate departureDate;
    private LocalDate arrivalDate;


    public Vol(LocalDate departureDate, LocalDate arrivalDate) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

}
