package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.persistence.*;
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
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private VolGeneric volGeneric;
    @Id
    private LocalDate departureDate;
    private LocalDate arrivalDate;


    public Vol(LocalDate departureDate, LocalDate arrivalDate) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

}
