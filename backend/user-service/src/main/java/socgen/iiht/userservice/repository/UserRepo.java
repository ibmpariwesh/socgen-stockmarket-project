package socgen.iiht.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socgen.iiht.userservice.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}
