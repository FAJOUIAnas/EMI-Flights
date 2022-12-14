package ma.ac.emi.ginfo.hg.emiflights.entities.ref;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Class implements Serializable {
    @Id
    @Column(length = 20)
    private String code;

    private String label;

}
