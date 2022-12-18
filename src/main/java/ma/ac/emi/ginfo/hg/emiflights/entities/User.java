package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.Civility;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Nonnull
    private String firstName;

    @Nonnull
    private String lastName;

    @Nonnull
    private String email;

    @ManyToOne
    private Civility civility;

    @Nonnull
    private LocalDate birthDate;

    @Nonnull
    private String adress;

}
