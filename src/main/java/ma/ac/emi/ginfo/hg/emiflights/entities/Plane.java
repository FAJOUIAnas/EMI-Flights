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
public class Plane implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Nonnull
    private String model;

    @Nonnull
    private String companyName;
}
