package ma.ac.emi.ginfo.hg.emiflights.services;

import ma.ac.emi.ginfo.hg.emiflights.entities.Plane;
import ma.ac.emi.ginfo.hg.emiflights.entities.Vol;
import ma.ac.emi.ginfo.hg.emiflights.repositories.PlaneRepository;
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

    public Vol addVol(Vol vol) {
        return volRepository.save(vol);
    }

    public List<Vol> findAllVols() {
        return volRepository.findAll();
    }
}
