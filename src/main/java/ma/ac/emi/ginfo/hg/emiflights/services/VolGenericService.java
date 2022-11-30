package ma.ac.emi.ginfo.hg.emiflights.services;

import ma.ac.emi.ginfo.hg.emiflights.entities.FlightGeneric;
import ma.ac.emi.ginfo.hg.emiflights.repositories.VolGenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolGenericService {
    private final VolGenericRepository volGenericRepository;

    @Autowired
    public VolGenericService(VolGenericRepository volGenericRepository) {
        this.volGenericRepository = volGenericRepository;
    }

    public FlightGeneric addVolGeneric(FlightGeneric flightGeneric) {
        return volGenericRepository.save(flightGeneric);
    }

    public List<FlightGeneric> findAllVolGenerics() {
        return volGenericRepository.findAll();
    }
}
