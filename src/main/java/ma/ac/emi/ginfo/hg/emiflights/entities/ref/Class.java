package ma.ac.emi.ginfo.hg.emiflights.entities.ref;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Class implements Serializable {
    @Id
    @Column(length = 20)
    private String code;

    @Nonnull
    private String label;

}
