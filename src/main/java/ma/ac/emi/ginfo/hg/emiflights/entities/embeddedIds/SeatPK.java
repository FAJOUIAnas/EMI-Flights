package ma.ac.emi.ginfo.hg.emiflights.entities.embeddedIds;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ma.ac.emi.ginfo.hg.emiflights.entities.Plane;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class SeatPK implements Serializable {
    private Long id;
    private Plane plane;
}
