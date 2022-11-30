package ma.ac.emi.ginfo.hg.emiflights.services;

import ma.ac.emi.ginfo.hg.emiflights.entities.Flight;
import ma.ac.emi.ginfo.hg.emiflights.repositories.VolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolService {
    private final VolRepository volRepository;

    @Autowired
    public VolService(VolRepository volRepository) {
        this.volRepository = volRepository;
    }

    public Flight addVol(Flight flight) {
        return volRepository.save(flight);
    }

    public List<Flight> findAllVols() {
        return volRepository.findAll();
    }
}
