package ma.ac.emi.ginfo.hg.emiflights.entities.ref;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Civility implements Serializable {
    @Id
    @Column(length = 20)
    private String code;

    private String label;
}
