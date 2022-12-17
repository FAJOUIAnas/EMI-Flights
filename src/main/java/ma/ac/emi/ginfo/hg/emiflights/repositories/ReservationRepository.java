package ma.ac.emi.ginfo.hg.emiflights.repositories;

import jakarta.transaction.Transactional;
import ma.ac.emi.ginfo.hg.emiflights.entities.Flight;
import ma.ac.emi.ginfo.hg.emiflights.entities.Plane;
import ma.ac.emi.ginfo.hg.emiflights.entities.Reservation;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
    Optional<Reservation> findReservationById(UUID id);

    @Transactional
    void deleteReservationById(UUID id);

    Optional<Reservation> findReservationByCode(String code);

    Optional<Reservation> findReservationByCreationDate(LocalDate creationDate);

    Optional<Reservation> findReservationByModificationDate(LocalDate modificationDate);

    Optional<Reservation> findReservationByFlight(Flight flight);

    Optional<Reservation> findReservationByPassengerFirstName(String firstName);

    Optional<Reservation> findReservationByPassengerLastName(String lastName);


}