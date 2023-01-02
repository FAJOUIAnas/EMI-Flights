package ma.ac.emi.ginfo.hg.emiflights.authentication.config;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDao {
    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User("saif", "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            ),
            new User("anas", "password_2",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            ),
            new User("youness", "password_3",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            ),new User("houssam", "password_4",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            )
    );

    public UserDetails findUserByEmail(String email){
        return APPLICATION_USERS
                .stream()
                .filter(u -> u.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No user was found"));
    }
}
