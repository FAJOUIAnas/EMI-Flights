package ma.ac.emi.ginfo.hg.emiflights.entities.ref;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Day implements Serializable {
    @Id
    @Column(length = 5)
    private String code;

    @Nonnull
    private String label;

}