package socgen.iiht.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import socgen.iiht.userservice.model.Credentials;
import socgen.iiht.userservice.repository.CredRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private CredRepo credRepo;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(s);
        Credentials credentials;
        try{
            credentials=credRepo.findCredentialsByUserName(s);
        }
        catch (Exception e){
            System.out.println("not found");
            throw new UsernameNotFoundException("user name not found");
        }
        List<GrantedAuthority> ls=new ArrayList<>();
        System.out.println(credentials.getRole());
        ls.add((GrantedAuthority) () -> credentials.getRole());
        return new User(credentials.getUserName(),credentials.getPassword(),ls);
    }
}
