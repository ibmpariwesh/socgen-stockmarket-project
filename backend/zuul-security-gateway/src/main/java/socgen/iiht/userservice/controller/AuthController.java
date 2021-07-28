package socgen.iiht.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import socgen.iiht.userservice.MyUserDetailsService;
import socgen.iiht.userservice.model.AuthenticationRequest;
import socgen.iiht.userservice.model.Credentials;
import socgen.iiht.userservice.repository.CredRepo;
import socgen.iiht.userservice.util.JwtUtil;

@RestController
@CrossOrigin
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private CredRepo credRepo;

    @PostMapping("/jwt-request")
    public String getJwtToken(@RequestBody AuthenticationRequest authenticationRequest){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
        }
        catch (BadCredentialsException e){
            throw e;
        }
        String jwt=jwtUtil.generateToken(myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername()));
        return jwt;
    }
    @PostMapping("/post_cred")
    public void postUser(@RequestBody Credentials credentials){
        credRepo.save(credentials);
    }

//    @PostMapping("/validate_jwt")
//    public boolean validateJwt(@RequestHeader(name="jwtToken") String token){
//        UserDetails userDetails =myUserDetailsService.loadUserByUsername(jwtUtil.extractUsername(token));
//        return jwtUtil.validateToken(token,userDetails);
//    }
}
