package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Airport implements Serializable {
    @Id
    @Column(length = 20)
    private String code;

    @Nonnull
    private String label;

    @Nonnull
    private String city;

    @Nonnull
    private String country;
}
