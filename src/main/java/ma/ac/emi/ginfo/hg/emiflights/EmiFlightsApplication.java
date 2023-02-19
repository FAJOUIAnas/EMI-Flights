package ma.ac.emi.ginfo.hg.emiflights;

import ma.ac.emi.ginfo.hg.emiflights.entities.User;
import ma.ac.emi.ginfo.hg.emiflights.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

@SpringBootApplication
public class EmiFlightsApplication{
    private final UserRepository userRepository;

    public EmiFlightsApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmiFlightsApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(){

        return args -> {
            /*User user = new User("saif", "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            );
            userRepository.save(user);
            user = new User("anas", "password_2",
                            Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            );
            userRepository.save(user);
            user = new User("youness", "password_3",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            );
            userRepository.save(user);
            user = new User("houssam", "password_4",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            );
            userRepository.save(user);
        };
    }
}
