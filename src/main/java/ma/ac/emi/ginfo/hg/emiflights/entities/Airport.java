package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Airport {
    @Id
    @Column(length = 100)
    private String code;
    @Nonnull
    private String name;
    @Nonnull
    private String city;
    @Nonnull
    private String country;
}
