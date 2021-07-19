package socgen.iiht.relationshipservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socgen.iiht.relationshipservice.model.CompanyToSector;

@Repository
public interface CompanyToSectorRepo extends JpaRepository<CompanyToSector,Integer> {
    public void deleteAllByCompanyId(int id);
    public void deleteAllBySectorId(int id);
}
