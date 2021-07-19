package socgen.iiht.sectorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socgen.iiht.sectorservice.model.Sector;

@Repository
public interface SectorRepo  extends JpaRepository<Sector,Integer> {

}
