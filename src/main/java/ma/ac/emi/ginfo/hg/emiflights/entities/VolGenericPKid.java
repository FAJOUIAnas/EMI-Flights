package ma.ac.emi.ginfo.hg.emiflights.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Embeddable
public class VolGenericPKid implements Serializable {
    private Long idPlane;
    private String day;
}
