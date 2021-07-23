package socgen.iiht.companyservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import javax.servlet.http.HttpServletRequest;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(httpServletRequest.getHeader("Authorization"));
        return null;
    }
}
