package ma.ac.emi.ginfo.hg.emiflights;

import ma.ac.emi.ginfo.hg.emiflights.entities.Plane;
import ma.ac.emi.ginfo.hg.emiflights.entities.Seat;
import ma.ac.emi.ginfo.hg.emiflights.entities.enumerations.SeatClass;
import ma.ac.emi.ginfo.hg.emiflights.repositories.PlaneRepository;
import ma.ac.emi.ginfo.hg.emiflights.repositories.SeatRepository;
import ma.ac.emi.ginfo.hg.emiflights.services.PlaneService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class EmiFlightsApplicationTests {
}
