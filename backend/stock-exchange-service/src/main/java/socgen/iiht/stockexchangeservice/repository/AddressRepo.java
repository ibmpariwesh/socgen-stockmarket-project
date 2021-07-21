package socgen.iiht.stockexchangeservice.repository;

import socgen.iiht.stockexchangeservice.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer> {
}
