package ma.ac.emi.ginfo.hg.emiflights.authentication.config;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtils jwtUtils;

    private Map<UserDetails, String> generatedTokens = new HashMap<>();

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        final UserDetails userDetails = userDao.findUserByEmail(request.getEmail());
        if (userDetails != null){
            if (generatedTokens.containsKey(userDetails)){
                return ResponseEntity.ok(this.generatedTokens.get(userDetails));
            }
            else{
                String token = jwtUtils.generateToken(userDetails);
                this.generatedTokens.put(userDetails, token);
                return ResponseEntity.ok(token);
            }
        }
        return ResponseEntity.status(400).body("Some error has occurred");
    }
}
