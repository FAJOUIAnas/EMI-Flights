package ma.ac.emi.ginfo.hg.emiflights.repositories;

import jakarta.transaction.Transactional;
import ma.ac.emi.ginfo.hg.emiflights.entities.Flight;
import ma.ac.emi.ginfo.hg.emiflights.entities.User;
import ma.ac.emi.ginfo.hg.emiflights.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserById(UUID id);

    @Transactional
    void deleteUserById(UUID id);

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByBirthDate(LocalDate birthDate);

    Optional<User> findUserByFirstName(String firstName);

    Optional<User> findUserByLastName(String lastName);

    Optional<User> findUserByAdress(String adress);
}