package socgen.iiht.relationshipservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socgen.iiht.relationshipservice.model.CompanyToStockExchange;

import java.util.List;

@Repository
public interface CompanyToStockExchangeRepo extends JpaRepository<CompanyToStockExchange,Integer> {
    public List<CompanyToStockExchange> findAll();
    public void deleteAllByCompanyId(int id);
    public void deleteAllByStockId(int id);
}
