package socgen.iiht.iposervice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socgen.iiht.iposervice.model.Ipo;

@Repository
public interface IpoRepo extends JpaRepository<Ipo,Integer> {

}
