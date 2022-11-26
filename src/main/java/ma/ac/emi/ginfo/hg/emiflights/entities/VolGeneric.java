package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
public class VolGeneric implements Serializable {
    @EmbeddedId
    private VolGenericPKid idVol;
    @Nonnull
    private LocalTime departureHour;
    @Nonnull
    private LocalTime arrivalTime;
    @Nonnull
    private LocalTime duration;


}