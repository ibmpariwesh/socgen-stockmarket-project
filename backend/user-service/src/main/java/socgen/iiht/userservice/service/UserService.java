package socgen.iiht.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socgen.iiht.userservice.model.User;
import socgen.iiht.userservice.repository.UserRepo;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public void addUser(User user){
        userRepo.save(user);
    }


}
