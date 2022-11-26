package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
public class VolG implements Serializable {
    @Id
    private Long idVol;
    @Nonnull
    private LocalTime departureHour;
    @Nonnull
    private LocalTime arrivalTime;
    @Nonnull
    private LocalTime duration;


}