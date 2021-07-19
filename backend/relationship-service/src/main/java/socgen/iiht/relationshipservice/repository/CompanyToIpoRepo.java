package socgen.iiht.relationshipservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socgen.iiht.relationshipservice.model.CompanyToIpo;

@Repository
public interface CompanyToIpoRepo extends JpaRepository<CompanyToIpo,Integer> {
    public void deleteAllByCompanyId(int companyId);
    public void deleteAllByCompanyIdAndStockExchangeId(int companyId,int stockEchangeId);
}
