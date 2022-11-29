package ma.ac.emi.ginfo.hg.emiflights.services;

import ma.ac.emi.ginfo.hg.emiflights.entities.Plane;
import ma.ac.emi.ginfo.hg.emiflights.entities.VolGeneric;
import ma.ac.emi.ginfo.hg.emiflights.repositories.PlaneRepository;
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

    public VolGeneric addVolGeneric(VolGeneric volGeneric) {
        return volGenericRepository.save(volGeneric);
    }

    public List<VolGeneric> findAllVolGenerics() {
        return volGenericRepository.findAll();
    }
}
