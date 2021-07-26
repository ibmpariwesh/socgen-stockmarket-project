package socgen.iiht.relationshipservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socgen.iiht.relationshipservice.model.CompanyToStockExchange;

import java.util.List;

@Repository
public interface CompanyToStockExchangeRepo extends JpaRepository<CompanyToStockExchange,Integer> {
    List<CompanyToStockExchange> findAll();
    List<CompanyToStockExchange> findAllByStockId(int stockId);
    List<CompanyToStockExchange> findAllByCompanyId(int companyId);
    void deleteAllByCompanyId(int id);
    void deleteAllByStockId(int id);
}
