package ma.ac.emi.ginfo.hg.emiflights.services;

import ma.ac.emi.ginfo.hg.emiflights.entities.User;
import ma.ac.emi.ginfo.hg.emiflights.repositories.FlightRepository;
import ma.ac.emi.ginfo.hg.emiflights.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void deleteUser(UUID id) {
        userRepository.deleteUserById(id);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User modifyUserFirstName(User user, String firstName){
        user.setFirstName(firstName);
        userRepository.save(user);
        return user;
    }

    public User modifyUserLastName(User user, String lastName){
        user.setLastName(lastName);
        userRepository.save(user);
        return user;
    }

    public User modifyUserEmail(User user, String email){
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }

    public User modifyUserAdress(User user, String adress){
        user.setAdress(adress);
        userRepository.save(user);
        return user;
    }

    public User modifyUserBirthDate(User user, LocalDate birthDate){
        user.setBirthDate(birthDate);
        userRepository.save(user);
        return user;
    }
}
