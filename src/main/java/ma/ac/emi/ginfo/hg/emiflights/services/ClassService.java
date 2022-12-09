package ma.ac.emi.ginfo.hg.emiflights.services;

import ma.ac.emi.ginfo.hg.emiflights.entities.Plane;
import ma.ac.emi.ginfo.hg.emiflights.entities.ref.Class;
import ma.ac.emi.ginfo.hg.emiflights.exception.ClassNotFoundException;
import ma.ac.emi.ginfo.hg.emiflights.exception.PlaneNotFoundException;
import ma.ac.emi.ginfo.hg.emiflights.repositories.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClassService {
    private final ClassRepository classRepository;

    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public Class addClass(Class _class) {
        return classRepository.save(_class);
    }

    public List<Class> findAllClasses() {
        return classRepository.findAll();
    }

    public Class updateClass(Class _class) {
        return classRepository.save(_class);
    }

    public Class findClassByCode(String code) {
        return classRepository.findClassByCode(code)
                .orElseThrow(() -> new ClassNotFoundException("Class by code " + code + "was not found"));
    }

    public void deleteClassByCode(String code) {
        classRepository.deleteClassByCode(code);
    }
}
