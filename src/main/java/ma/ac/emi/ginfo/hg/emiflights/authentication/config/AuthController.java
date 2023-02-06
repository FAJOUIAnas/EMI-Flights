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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtils jwtUtils;

    private Map<UserDetails, String> generatedTokens = new HashMap<>();

    @PostMapping("/authenticate")
    public ResponseEntity<Response> authenticate(@RequestBody AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        final UserDetails userDetails = userDao.findUserByEmail(request.getEmail());
        if (userDetails != null){
            if (generatedTokens.containsKey(userDetails)){
                return ResponseEntity.ok(new Response(this.generatedTokens.get(userDetails)));
            }
            else{
                String token = jwtUtils.generateToken(userDetails);
                this.generatedTokens.put(userDetails, token);
                return ResponseEntity.ok(new Response(token));
            }
        }
        return (ResponseEntity<Response>) ResponseEntity.badRequest();
    }
}

class Response {
    private String token;

    public Response(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
