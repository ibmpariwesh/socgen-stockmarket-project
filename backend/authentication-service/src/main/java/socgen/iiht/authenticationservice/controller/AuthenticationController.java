package socgen.iiht.authenticationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import socgen.iiht.authenticationservice.MyUserDetailsService;
import socgen.iiht.authenticationservice.model.AuthenticationRequest;
import socgen.iiht.authenticationservice.util.JwtUtil;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
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
}
