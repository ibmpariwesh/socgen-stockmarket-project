package socgen.iiht.authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socgen.iiht.authenticationservice.model.Credentials;

@Repository
public interface CredRepo extends JpaRepository<Credentials,Integer> {
    public Credentials findCredentialsByUserName(String userName);

}
