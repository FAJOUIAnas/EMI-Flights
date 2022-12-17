package ma.ac.emi.ginfo.hg.emiflights.restcontrollers;

import ma.ac.emi.ginfo.hg.emiflights.entities.Reservation;
import ma.ac.emi.ginfo.hg.emiflights.entities.User;
import ma.ac.emi.ginfo.hg.emiflights.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") UUID id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/modify_fN")
    public ResponseEntity<User> modifyUserFirstName(@RequestBody User user,
                                                    @RequestParam("first_name") String firstName) {
        User newUser = userService.modifyUserFirstName(user, firstName);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/modify_lN")
    public ResponseEntity<User> modifyUserLastName(@RequestBody User user,
                                                    @RequestParam("last_name") String lastName) {
        User newUser = userService.modifyUserLastName(user, lastName);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/modify_email")
    public ResponseEntity<User> modifyUserEmail(@RequestBody User user,
                                                @RequestParam("email") String email) {
        User newUser = userService.modifyUserEmail(user, email);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/modify_adress")
    public ResponseEntity<User> modifyUserAdress(@RequestBody User user,
                                                @RequestParam("adress") String adress) {
        User newUser = userService.modifyUserEmail(user, adress);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/modify_birthd")
    public ResponseEntity<User> modifyUserBirthDate(@RequestBody User user,
                                                 @RequestParam("birth_date") LocalDate birthDate) {
        User newUser = userService.modifyUserBirthDate(user, birthDate);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
