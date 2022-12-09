package ma.ac.emi.ginfo.hg.emiflights;

import ma.ac.emi.ginfo.hg.emiflights.entities.enumerations.SeatClass;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class EmiFlightsApplicationTests {
}
