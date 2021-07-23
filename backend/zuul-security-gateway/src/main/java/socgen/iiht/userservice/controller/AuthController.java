package socgen.iiht.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import socgen.iiht.userservice.MyUserDetailsService;
import socgen.iiht.userservice.model.AuthenticationRequest;
import socgen.iiht.userservice.util.JwtUtil;

@RestController
public class AuthController {
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

//    @PostMapping("/validate_jwt")
//    public boolean validateJwt(@RequestHeader(name="jwtToken") String token){
//        UserDetails userDetails =myUserDetailsService.loadUserByUsername(jwtUtil.extractUsername(token));
//        return jwtUtil.validateToken(token,userDetails);
//    }
}
